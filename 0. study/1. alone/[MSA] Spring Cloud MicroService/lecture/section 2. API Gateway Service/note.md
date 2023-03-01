# section 2. API Gateway Service

- 사용자의 요청을 대신 받아서 실제 MicroService에게 요청을 한다!

```text
With so many clients and servers in play, it’s often helpful to include an API gateway in your cloud architecture. A gateway can take care of securing and routing messages, hiding services, throttling load, and many other useful things. Spring Cloud Gateway gives you precise control of your API layer, integrating Spring Cloud service discovery and client-side load-balancing solutions to simplify configuration and maintenance.

사용 중인 클라이언트와 서버가 너무 많기 때문에 클라우드 아키텍처에 API 게이트웨이를 포함하는 것이 종종 도움이 됩니다. 게이트웨이는 메시지 보안 및 라우팅, 서비스 숨기기, 부하 조절 및 기타 많은 유용한 작업을 처리할 수 있습니다. Spring Cloud Gateway는 구성 및 유지 관리를 단순화하기 위해 Spring Cloud 서비스 검색 및 클라이언트 측 로드 밸런싱 솔루션을 통합하여 API 계층을 정밀하게 제어할 수 있도록 합니다.
```

[Ref By](https://spring.io/cloud)

## Netflix Zuul

- Spring 2.4 version 이전에 사용 가능

- `localhost:8080/서비스명`에 요청 오면 `http://localhost:서비스_포트번호` 으로 전달이 가게 하자!
  - `localhost:8080/first-service` -> `http://localhost:8081` 
  - `localhost:8080/second-service` -> `http://localhost:8082` 

```yml
server:
  port: 8000

spring:
  application:
    name: my-zuul-service

zuul:
  routes:
    first-service:
      path: /first-service/**
      url: http://localhost:8081
    second-service:
      path: /second-service/**
      url: http://localhost:8082
```

```java
@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        log.info("**************** printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("**************** " + request.getRequestURI());

        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
```

[Boot 2.3.8, Ref By](https://github.com/joneconsulting/msa_with_spring_cloud/blob/main/zuul-service/src/main/resources/application.yml)

## Spring Cloud Gateway

- Zuul과는 다르게 논블락킹을 지원한다
  - Server도 Tomcat이 아닌 Netty 기동

```yaml
server:
  port: 8000

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka

spring:
  application:
    name: apigateway-service # 게이트웨이짱의 이름이다 이말이여~

  cloud:
    gateway:
      routes: # forwarding 시켜버리기
        - id: first-service 
          url: http://localhost:8081/
          predicates: # 조건절
            - Path=/first-service/**
        - id: second-service
          url: http://localhost:8082/
          predicates: #
            - Path=/second-service/**
```

- 예시) `xxx:8000/first-service/welcome` 로 요청이 오면 `localhost:8081/first-service/welcome` 으로 라우팅한다!

- 다만, `/MS명` 으로 요청이 오면 `:MS포트번호_/MS명` 로 고스란히 요청이 가게 되는 불편함이 있다
  - 추후에 수정하는 방법을 알려주시는 것 같다


header를 추가하는 방법(`spring.cloud.gateway.routes`)은 아래 두 가지가 있다

```kotlin
@Configuration
class FilterConfig {

    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes {
            route {
                path("/first-service/**")
                    .filters {
                        it
                            .addRequestHeader("first-request", "first-request-value")
                            .addResponseHeader("first-response", "first-response-value")
                    }
                    .uri("http://localhost:8081")
            }
            route {
                path("/second-service/**")
                    .filters {
                        it
                            .addRequestHeader("second-request", "second-request-value")
                            .addResponseHeader("second-response", "second-response-value")
                    }
                    .uri("http://localhost:8082")
            }
        }
}
```

```yaml
spring:
  ...
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8081/
          predicates:
            - Path=/first-service/**
          filters:
            - AddRequestHeader=first-request, first-request-value
            - AddResponseHeader=first-response, first-response-value
        - id: second-service
          uri: http://localhost:8082/
          predicates:
            - Path=/second-service/**
          filters:
            - AddRequestHeader=second-request, second-request-value
            - AddResponseHeader=second-response, second-response-value
```

커스텀 필터를 등록해보자

커스텀 필터

```kotlin
@Component
class CustomFilter : AbstractGatewayFilterFactory<CustomFilter.Config>() {

    private val log = LoggerFactory.getLogger(CustomFilter::class.java)

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            val request: ServerHttpRequest = exchange.request
            val response: ServerHttpResponse = exchange.response

            log.info("custom pre filter: request id: {}", request.id)

            chain
                .filter(exchange)
                .then(Mono.fromRunnable {
                    log.info("custom post filter: request id: {}", response.statusCode)
                })
        }

    class Config {
        // put the configuration properties if exist
    }
}
```

설정

```yml
spring:
  cloud:
    gateway:
      routes:
        - id: first-service
        ...
          filters:
            - CustomFilter
        - id: second-service
        ...
          filters:
            - CustomFilter
```

`글로벌 필터`도 크게 다른건 없다

```kotlin
@Component
class GlobalFilter : AbstractGatewayFilterFactory<GlobalFilter.Config>(Config::class.java) {

    val log = LoggerFactory.getLogger(GlobalFilter::class.java)!!

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            if (config == null) {
                throw NullPointerException("config should not be null")
            }

            log.info("Global Filter baseMessage: {}", config.baseMessage)

            if (config.preLogger) {
                log.info("Global Filter Start: request id -> {}", exchange.request.id)
            }

            chain
                .filter(exchange)
                .then(Mono.fromRunnable {
                    if (config.postLogger) {
                        log.info("Global Filter End: request id -> {}", exchange.response.statusCode)
                    }
                })
        }

    class Config {
        lateinit var baseMessage: String
        var preLogger: Boolean = false
        var postLogger: Boolean = false
    }
}
```


```yml
spring.cloud.gateway.default-filters:
  - name: GlobalFilter
    args:
      baseMessage: "Spring Cloud Gateway GlobalFilter"
      preLogger: true
      postLogger: true
```

로깅 필터

```kotlin
@Component
class LoggingFilter : AbstractGatewayFilterFactory<LoggingFilter.Config>(Config::class.java) {

    val log = LoggerFactory.getLogger(LoggingFilter::class.java)!!

    override fun apply(config: Config?): GatewayFilter =
        OrderedGatewayFilter({ exchange, chain ->
            if (config == null) {
                throw NullPointerException("config should not be null")
            }

            log.info("Logging Filter baseMessage: {}", config.baseMessage)

            if (config.preLogger) {
                log.info("Logging Filter Start: request id -> {}", exchange.request.id)
            }

            chain
                .filter(exchange)
                .then(Mono.fromRunnable {
                    if (config.postLogger) {
                        log.info("Logging Filter End: request id -> {}", exchange.response.statusCode)
                    }
                })
        }, Ordered.LOWEST_PRECEDENCE)

    class Config {
        lateinit var baseMessage: String
        var preLogger: Boolean = false
        var postLogger: Boolean = false
    }
}

```

```yml
spring.cloud.gateway.routes:
  - id: second-service
  ...
    filters:
      - name: LoggingFilter
        args:
          baseMessage: "Spring Cloud Gateway GlobalFilter"
          preLogger: true
          postLogger: true
```


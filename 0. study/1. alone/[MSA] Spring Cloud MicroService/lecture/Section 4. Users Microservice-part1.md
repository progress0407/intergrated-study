# Section 4. Users Microservice-part1

## Greeting 출력 2가지 방법

1. Environment

```kotlin
env.getProperty("greeting.message") ?: "No Message"
```

2. Bean + Value

```kotlin
@Component
class Greeting(
    @Value("\${greeting.message}")
    val message: String
)
```

```kotlin
greeting.message
```

## h2 설정

```yml
spring:
  h2:
    console:
      enabled: true
      settings:
        web-allow-others: true
      path: /h2
```

## 디버깅 등 오답노트

### @Value in Kotlin 

코틀린에서는 이슈가 있다

자세한 건 [여기서](https://milosgarunovic.com/posts/spring-value-annotation-in-kotlin-throws-an-error-must-be-a-compile-time-constant/) 확인할 수 있다

### h2 db

custom path 설정이 되지 않는다

오래된 버전의 경우 부트 3.0.2 이 막는 것 같다 (보안 등의 이슈?)

조치사항으로 **최신 버전으로 변경**했다

# section 1. Service Discovery

- Service Discovery: 서비스를 찾아서 탐색한다.
  - 예) localhost:8001, 8002 등 각각 다른 서비스를 등록
    - localhost:8001 -> localhost/order 등

## Discovery Service - Eureka

- Server의 개념이다
- 이곳에서 MS를 등록한다

## Discovery Service - Client

- Client의 개념이다
  - MS 자체이다
  
```yaml
server:
  port: 9021

spring:
  application:
    name: user-service

eureka:
  client:
    register-with-eureka: true # 유레카 서버에 등록할지 여부
    fetch-registry: true # 서버와 주기적으로 통신할 지 여부
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka # 유레카 서버 url 
      # 강사님이 localhost 보다는 이 표기 법을 선호
  ```

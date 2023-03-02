# Section 3. E-commerce 애플리케이션

## 서버 종류

(마이크로서비스의 약어로 MS를 사용)

Eureka Server: (Registry Service) MS 등록 / 검색

API Gateway Server: (Routing Service) MS 부하 분산 / 서비스 라우팅

Config Server: (Configuration Service) MS 설정 정보를 동적으로 변경

Queuing System: MS 간 메시지 발행 및 구독 (ex. kafka)

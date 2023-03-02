# section 0. Microservice와 Spring Cloud의 소개

## MSA 이걸 도대체 왜 할까?

- DB에 트랜잭션 잠금 등으로 시스템이 전면 마비가 되어버린다...
  - 리뷰로 DDOS 공격 받듯이 요청이 왔는데... 주문이 마비 되어 버린다.. ㅠㅠ

- 일반적으로 Scale Out보다는 Scale Up이 더 저렴하다

- MSA... 어떻게든 전면마비, 성능 문제, 확장 문제로부터 자유로워지고자 만들어진 시스템 ...

![image](https://user-images.githubusercontent.com/66164361/219222274-56031265-e375-4461-a636-12777d069fa9.png)

![image](https://user-images.githubusercontent.com/66164361/219222544-2fef8c9d-0394-4b0c-85f7-8b3a4277c2d6.png)

![image](https://user-images.githubusercontent.com/66164361/219222988-03fe34bc-62c9-43cf-b1e6-176cd6522f85.png)

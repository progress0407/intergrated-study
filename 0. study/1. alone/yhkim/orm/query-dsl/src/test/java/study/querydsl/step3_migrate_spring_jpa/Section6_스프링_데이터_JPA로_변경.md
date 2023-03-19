# Section6_스프링_데이터_JPA로_변경

## 스프링 데이터 JPA 리포지토리로 변경

## 사용자 정의 리포지토리

CQRS를 분리하는 것도 좋은 방법

변경(CUD)을 위한 엔티티 조회는 DomainRepository로,
화면 조회 전용 API는 DomaminQueryRepository로

## 스프링 데이터 페이징 활용1 - Querydsl 페이징 연동

fetchResults() 는 fetch() 와 다르게 count쿼리도 출력한다

## 스프링 데이터 페이징 활용2 - CountQuery 최적화

count 쿼리 생략 가능한 경우 생략해서 처리

생략 조건
- 시작 페이지(`page index: 0`)이면서 컨텐츠 size < 페이지 자체 size
  - ex) 조회한 컨텐츠는 3개, 페이지 자체 크기는 5개이면, 당연힌 현재 fetch한 데이터로 총 데이터 갯수 유도 가능
- 마지막 페이지(`last page index`)일 때
  - ex) 페이지 자체 크기 5, 마지막 페이지: 10, 조회한 컨텐츠 3개: 5 * 10 + 3 = 53개
    
```java
PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchCount());
```

쿼리 실행을 위임한다!

`() -> countQuery.fetchCount()` 이와 같은 함수를 이용해서 지연 평가 활용


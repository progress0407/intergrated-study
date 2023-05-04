# 스프링 데이터 JPA가 제공하는 Querydsl 기능

## 인터페이스 지원 - QuerydslPredicateExecutor

한 개의 엔티티 를 조회하는 용도를 좋다

그러나 아래와 같은 단점이 존재한다

- 조인이 불가하다. (left join)
- 클라이언트 코드에 querydsl 의존성이 생긴다

## Querydsl Web 지원

장점보다는 단점이 많은 기술...

- 복잡함
- 컨트롤러가 querydsl 에 의존

## 리포지토리 지원 - QuerydslRepositorySupport

페이징 처리를 간편하게 제공

(아래 코드 생략 가능)

```java
.offset(pageable.getOffset())
.limit(pageable.getPageSize())
```

```java
public <T> JPQLQuery<T> applyPagination(Pageable pageable, JPQLQuery<T> query) {
    ...
    query.offset(pageable.getOffset());
    query.limit(pageable.getPageSize());
    ...
}
```

단점
- 그렇게 간편해 보이진 않음
- 메서드 체이닝이 중간에 끊겨서 ㅃ치게 만듬
- Sort 동작 X, QSort를 넣으면 된다고는 한다 (...)

## Querydsl 지원 클래스 직접 만들기

영한님이 만드신 QuerydslSupport 커스텀 래퍼 클래스

메서드 체이닝이 끊기는 부분을 람다 파라미터로 보완하셨다 (`일급 함수로 보완`)

```java
class MemberRepoWithQuerydslSupportCustom extends Querydsl4RepositorySupport
```
             
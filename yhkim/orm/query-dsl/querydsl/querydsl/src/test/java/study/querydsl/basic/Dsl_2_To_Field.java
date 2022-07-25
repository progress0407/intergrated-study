package study.querydsl.basic;

import static org.assertj.core.api.Assertions.assertThat;

public class Dsl_2_To_Field extends AbstractQuerydslTest {

    /**
     * JPAQueryFactory 를 필드로 두었다는 의미
     *
     * 이때 "동시성" 문제에 대해 생각해볼 수 있다
     *
     * 결론적으로 멀티 쓰레드 환경에서도 문제 없다
     * 이유는 JPAQueryFactory 는 EntityManger 를 사용하는데,
     * 여러 쓰레드에서 EntityManger 에 접근하더라도
     * 트랜잭션마다 별도의 P.C.를 제공하기 때문이다.
     */
}

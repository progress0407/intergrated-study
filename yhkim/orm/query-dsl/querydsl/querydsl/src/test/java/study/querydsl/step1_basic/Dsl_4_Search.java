package study.querydsl.step1_basic;

import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;

import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.AbstractQuerydslTest;
import study.querydsl.entity.Member;

public class Dsl_4_Search extends AbstractQuerydslTest {

    /**
     * JPQL의 검색 조건 제공
     *
     * username.eq("member1") // username = 'member1'
     * username.ne("member1") //username != 'member1'
     * username.eq("member1").not() // username != 'member1'
     * username.isNotNull() //이름이 is not null
     * age.in(10, 20) // age in (10,20)
     * age.notIn(10, 20) // age not in (10, 20)
     * age.between(10,30) //between 10, 30
     * age.goe(30) // age >= 30
     * age.gt(30) // age > 30
     * age.loe(30) // age <= 30
     * age.lt(30) // age < 30
     * username.like("member%") //like 검색
     * username.contains("member") // like ‘%member%’ 검색
     * username.startsWith("member") //like ‘member%’ 검색
     */

    @Test
    public void search() {
        Member findMember = queryFactory
                .selectFrom(qMember)
                .where(qMember.username.eq("member1")
                        .and(qMember.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void searchAndParam() {
        final List<Member> result = queryFactory
                .selectFrom(qMember)
                .where(qMember.username.eq("member1"),
                        qMember.age.eq(10))
                .fetch();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void search_and_1() {
        final Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1")
                        .and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void search_and_2() {
        final List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"),
                        member.age.eq(10))      // 이걸 컴마로 처리할 수 있다
                .fetch();

        assertThat(result.size()).isEqualTo(1);
    }
}

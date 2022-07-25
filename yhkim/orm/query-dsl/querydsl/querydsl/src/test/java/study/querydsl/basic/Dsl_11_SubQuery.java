package study.querydsl.basic;

import static com.querydsl.jpa.JPAExpressions.select;
import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;

import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;

public class Dsl_11_SubQuery extends AbstractQuerydslTest {

    @Test
    void subQuery() {
        final QMember memberSub = new QMember("memberSub");

        final List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        // JPAExpressions.select
                        select(memberSub.age.max())
                                .from(memberSub)
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(40);
    }

    @Test
    void subQueryGoe() {
        final QMember memberSub = new QMember("memberSub");

        final List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        select(memberSub.age.avg())
                                .from(memberSub)
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(30, 40);
    }

    @Test
    void subQueryIn() {
        final QMember memberSub = new QMember("memberSub");

        final List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.in(
                        select(memberSub.age)
                                .from(memberSub)
                                .where(memberSub.age.gt(10))
                ))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(20, 30, 40);
    }
}

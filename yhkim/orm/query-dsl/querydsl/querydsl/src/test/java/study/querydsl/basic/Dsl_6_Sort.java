package study.querydsl.basic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.Member;

public class Dsl_6_Sort extends AbstractQuerydslTest {

    @Test
    void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        final List<Member> result = queryFactory
                .selectFrom(qMember)
                .where(qMember.age.eq(100))
                .orderBy(qMember.age.desc(), qMember.username.asc().nullsLast())
                .fetch();

        final Member member5 = result.get(0);
        final Member member6 = result.get(1);
        final Member memberNull = result.get(2);

        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isNull();
    }
}

package study.querydsl.step2_middle;

import static java.lang.System.out;

import com.querydsl.core.types.dsl.Expressions;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.Member;
import study.querydsl.support.AbstractQuerydslTest;

public class Dsl4_bulkUpdate extends AbstractQuerydslTest {

    /**
     * 1차 캐시를 거치지 않고 실행된다 !
     */
    @Test
    void bulkUpdate() {
        final long count = queryFactory
                .update(qMember)
                .set(qMember.username, "비회원")
                .where(qMember.age.lt(28))
                .execute();

        out.println("count = " + count);

        em.flush();
        em.clear();

        final List<Member> result = queryFactory
                .selectFrom(qMember)
                .fetch();

        for (final Member member : result) {
            out.println("member = " + member);
        }
    }

    @Test
    void bulkAdd() {
        final long count = queryFactory
                .update(qMember)
                .set(qMember.age, qMember.age.multiply(2))
                .execute();
    }

    @Test
    void bulkDelete() {
        final long count = queryFactory
                .delete(qMember)
                .where(qMember.age.gt(18))
                .execute();

        out.println("count = " + count);
    }
}

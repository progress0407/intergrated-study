package study.querydsl.step2_middle;

import static org.assertj.core.api.Assertions.assertThat;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.Member;
import study.querydsl.support.AbstractQuerydslTest;

public class Dsl3_Boolean_Builder extends AbstractQuerydslTest {

    @Test
    void dynamicQuery_booleanBuilder() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember1(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember1(final String usernameCond, final Integer ageCond) {
        final BooleanBuilder builder = new BooleanBuilder();
        if (usernameCond != null) {
            builder.and(qMember.username.eq(usernameCond));
        }
        if (ageCond != null) {
            builder.and(qMember.age.eq(ageCond));
        }

        return queryFactory
                .selectFrom(qMember)
                .where(builder)
                .fetch();
    }

    @Test
    void dynamicQuery_WhereParam() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember2(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    /**
     * 아래와 where 절을 설정 할 수 있는 이유는 null 값이 무시되기 때문이다 !
     */
    private List<Member> searchMember2(final String usernameCond, final Integer ageCond) {
        return queryFactory
                .selectFrom(qMember)
                .where(usernameEq(usernameCond), ageEq(ageCond))
                .where(allEq(usernameCond, ageCond))
                .fetch();
    }

    private BooleanExpression usernameEq(final String usernameCond) {

        return usernameCond != null ? qMember.username.eq(usernameCond) : null;
    }

    private BooleanExpression ageEq(final Integer ageCond) {

        return ageCond != null ? qMember.age.eq(ageCond) : null;
    }

    /**
     * Predicate 보다는 BooleanExpression 이 있어야 활용이 가능하다 !
     */
    private Predicate allEq(final String usernameCond, final Integer ageCond) {

        return usernameEq(usernameCond).and(ageEq(ageCond));
    }
}

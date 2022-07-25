package study.querydsl.basic;

import static java.lang.System.out;
import static study.querydsl.entity.QMember.member;

import org.junit.jupiter.api.Test;

public class Dsl_13_Concat extends AbstractQuerydslTest {

    @Test
    void concat() {
        final String result = queryFactory
                .select(member.username.concat("_").concat(member.age.stringValue()))
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        out.println("result = " + result);
    }
}

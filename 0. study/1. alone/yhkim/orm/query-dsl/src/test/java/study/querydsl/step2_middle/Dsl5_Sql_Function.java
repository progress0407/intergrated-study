package study.querydsl.step2_middle;

import static java.lang.System.out;

import com.querydsl.core.types.dsl.Expressions;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.support.AbstractQuerydslTest;

public class Dsl5_Sql_Function extends AbstractQuerydslTest {

    /**
     * function('replace', 테이블.컬럼, 전_값, 후_값);
     *
     * ANSI 표준 함수인가?
     */
    @Test
    void sqlFunction() {
        final List<String> result = queryFactory
                .select(
                        Expressions.stringTemplate("function('replace', {0}, {1}, {2})",
                                qMember.username, "member", "M"))
                .from(qMember)
                .fetch();

        for (final String member : result) {
            out.println("member = " + member);
        }
    }
}

package study.querydsl.step1_basic;

import static java.lang.System.out;

import com.querydsl.core.types.dsl.CaseBuilder;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.support.AbstractQuerydslTest;

class Dsl_12_Case extends AbstractQuerydslTest {

    @Test
    void case_simple() {
        final List<String> dataList = queryFactory
                .select(qMember.age.when(10).then("열살")
                        .when(20).then("스무살")
                        .otherwise("기타"))
                .from(qMember)
                .fetch();

        for (final String data : dataList) {
            out.println("data = " + data);
        }
    }

    @Test
    void case_complicated() {
        final CaseBuilder caseBuilder = new CaseBuilder();

        final List<String> dataList = queryFactory
                .select(caseBuilder
                        .when(qMember.age.between(0, 20)).then("0~20살")
                        .when(qMember.age.between(21, 30)).then("21살~39살")
                        .otherwise("기타"))
                .from(qMember)
                .fetch();

        for (final String data : dataList) {
            out.println("data = " + data);
        }
    }
}

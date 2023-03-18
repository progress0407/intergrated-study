package study.querydsl.step1_basic;

import static java.lang.System.out;
import static study.querydsl.entity.QMember.member;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.CaseBuilder;
import java.util.List;

import com.querydsl.core.types.dsl.NumberExpression;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.QMember;
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

    @Test
    void 강의_이후_추가된_내용() {
        NumberExpression<Integer> rankPath = new CaseBuilder()
                .when(member.age.between(0, 20)).then(2)
                .when(member.age.between(21, 30)).then(3)
                .otherwise(3);

        List<Tuple> result = queryFactory
                .select(member.username, member.age, rankPath)
                .from(member)
                .orderBy(rankPath.asc())
                .fetch();

        for (Tuple tuple : result) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);
            Integer rank = tuple.get(rankPath);

            out.printf("username = %s, age = %s, rank = %s \n", username, age, rank);
        }
    }
}

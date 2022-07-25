package study.querydsl.basic;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.querydsl.entity.QMember.member;

import com.querydsl.core.NonUniqueResultException;
import com.querydsl.core.QueryResults;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import study.querydsl.entity.Member;

public class Dsl_5_ResultType extends AbstractQuerydslTest {

    /**
     * fetch 리스트 조회
     * <p>
     * fetchFirst  아무거나 하나 조회 결과 둘 이상이면 Exception
     * <p>
     * fetchResults  페이징 정보 포함, total count 쿼리 추가 실행
     * <p>
     * fetchCount  count 쿼리로 변경해서 count 수 조회
     */
    @Test
    void result_search() {
        final List<Member> fetch = queryFactory.selectFrom(member)
                .fetch();

        out.println("fetch = " + fetch);
        final Supplier<Member> memberNull = () ->
                (queryFactory
                        .selectFrom(member)
                        .fetchOne());// 결과가 둘 이상이면 NonUniqueException

        assertThatExceptionOfType(NonUniqueResultException.class)
                .isThrownBy(() -> memberNull.get());

        final Member fetch_first = queryFactory
                .selectFrom(member)
                .fetchFirst();

        out.println("fetch_first = " + fetch_first);

        final QueryResults<Member> queryResults = queryFactory
                .selectFrom(member)
                .fetchResults();

        out.println("queryResults = " + queryResults);

        final long count = queryFactory
                .selectFrom(member)
                .fetchCount();

        out.println("count = " + count);
    }
}

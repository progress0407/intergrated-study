package study.querydsl.step2_middle;

import static java.lang.System.out;

import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.dto.MemberDto;
import study.querydsl.dto.QMemberDto;
import study.querydsl.support.AbstractQuerydslTest;

class Dsl2_Query_Projection extends AbstractQuerydslTest {

    /**
     * 앞서 있는 DTO Projection 방식들 보다 훨씬 더 간편한 방식 !
     *
     * 그러나 @QueryProjection 어노테이션이 QueryDsl 자체에 의존한다.
     * 이때 이걸 사용하는 DTO가, 여러 계층에서 돌아댕기게 되는데...
     * QueryDsl을 사용하게 되지 않을 때에 변경에 대한 여파가 크다 !
     */
    @Test
    void findDtoByQueryProjection() {
        final List<MemberDto> result = queryFactory
                .select(new QMemberDto(qMember.username, qMember.age))
                .from(qMember)
                .fetch();

        for (final MemberDto memberDto : result) {
            out.println("memberDto = " + memberDto);
        }
    }
}

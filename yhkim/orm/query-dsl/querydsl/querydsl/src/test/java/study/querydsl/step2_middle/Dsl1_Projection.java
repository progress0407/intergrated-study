package study.querydsl.step2_middle;

import static java.lang.System.out;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.dto.MemberDto;
import study.querydsl.dto.UserDto;
import study.querydsl.entity.QMember;
import study.querydsl.support.AbstractQuerydslTest;

class Dsl1_Projection extends AbstractQuerydslTest {

    @Test
    void simpleProjection() {
        final List<String> result = queryFactory
                .select(qMember.username)
                .from(qMember)
                .fetch();

        for (final String s : result) {
            out.println("s = " + s);
        }
    }

    /**
     * 조회 대상이 둘 이상일 때 튜플로 조회한다 !
     */
    @Test
    void tupleProjection() {
        final List<Tuple> result = queryFactory
                .select(qMember.username, qMember.age)
                .from(qMember)
                .fetch();

        for (final Tuple tuple : result) {
            final String username = tuple.get(qMember.username);
            final Integer age = tuple.get(qMember.age);
            out.println("username = " + username);
            out.println("age = " + age);
        }
    }

    @Test
    void findDtoByJPQL() {
        final List<MemberDto> result = em.createQuery("select new study.querydsl.dto.MemberDto() "
                        + "from Member m", MemberDto.class)
                .getResultList();

        for (final MemberDto memberDto : result) {
            out.println("memberDto = " + memberDto);
        }
    }

    /**
     * java bean property 규약을 말하는 것 같다
     */
    @Test
    void findDtoBySetter() {
        final List<MemberDto> result = queryFactory
                .select(Projections.bean(MemberDto.class,
                        qMember.username,
                        qMember.age))
                .from(qMember)
                .fetch();

        for (final MemberDto memberDto : result) {
            out.println("memberDto = " + memberDto);
        }
    }

    @Test
    void findDtoByField() {
        final List<MemberDto> result = queryFactory
                .select(Projections.fields(MemberDto.class,
                        qMember.username,
                        qMember.age))
                .from(qMember)
                .fetch();

        for (final MemberDto memberDto : result) {
            out.println("memberDto = " + memberDto);
        }
    }

    @Test
    void findDtoByConstructor() {
        final List<MemberDto> result = queryFactory
                .select(Projections.constructor(MemberDto.class,
                        qMember.username,
                        qMember.age))
                .from(qMember)
                .fetch();

        for (final MemberDto memberDto : result) {
            out.println("memberDto = " + memberDto);
        }
    }


    /***
     * 별칭이 다를 때
     */
    @Test
    void findDtoUserDto() {

        /**
         * 아래의 경우에 대해서는 바인딩을 해주는 것 같다
         * .select(Projections.constructor(UserDto.class,
         *                         qMember.username,
         *                         qMember.age))
         */

        final List<UserDto> result = queryFactory
                .select(Projections.fields(UserDto.class,
                        qMember.username.as("name"),
                        qMember.age))
                .from(qMember)
                .fetch();

        for (final UserDto userDto : result) {
            out.println("userDto = " + userDto);
        }
    }

    /**
     * select
     *      member0_.username as col_0_0_,
     *      (select max(member1_.age) from member member1_) as col_1_0_
     * from member member0_;
     */
    @Test
    void findDtoUserDto2() {

        final QMember memberSub = new QMember("memberSub");

        final List<UserDto> result = queryFactory
                .select(Projections.fields(UserDto.class,
                                qMember.username.as("name"),
                                ExpressionUtils.as(
                                        JPAExpressions
                                                .select(memberSub.age.max())
                                                .from(memberSub), "age")
                        )
                )
                .from(qMember)
                .fetch();

        for (final UserDto userDto : result) {
            out.println("userDto = " + userDto);
        }
    }

}

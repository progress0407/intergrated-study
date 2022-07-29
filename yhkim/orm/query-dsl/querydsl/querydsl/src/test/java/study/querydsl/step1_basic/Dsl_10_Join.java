package study.querydsl.step1_basic;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

import com.querydsl.core.Tuple;
import java.util.List;
import org.junit.jupiter.api.Test;
import study.querydsl.support.AbstractQuerydslTest;
import study.querydsl.entity.Member;

class Dsl_10_Join extends AbstractQuerydslTest {

    /**
     * 일반 조인
     * inner join 으로 연산한다
     */

    /**
     * select
     * 	member0_.member_id as member_i1_1_,
     * 	member0_.age as age2_1_, member0_.team_id as team_id4_1_,
     * 	member0_.username as username3_1_
     * from member member0_
     * 	inner join team team1_
     * 	on member0_.team_id=team1_.team_id
     * where team1_.name='teamA';
     */
    @Test
    void join() {
        final List<Member> result = queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");
    }

    /**
     * 막 조인
     * 쎄타 조인
     * 크로스 프로덕트
     * 곱연산
     * 모든 경우의 수를 조회해 온다
     */
    @Test
    void theta_join() {
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));

        final List<Member> result = queryFactory
                .select(member)
                .from(member, team)
                .where(member.username.eq(team.name))
                .fetch();

        out.println("result = " + result);

        assertThat(result)
                .extracting("username")
                .containsExactly("teamA", "teamB");
    }

    @Test
    void join_on_filtering() {
        final List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(member.team, team)
                .on(team.name.eq("teamA"))
                .fetch();

        for (final Tuple tuple : result) {
            out.println("tuple = " + tuple);
        }
    }

    @Test
    void fetch_on_no_relation() {
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));

        final List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team)
                .on(member.username.eq(team.name))
                .fetch();

        for (final Tuple tuple : result) {
            out.println("tuple = " + tuple);
        }
    }

    @Test
    void noUseFetchJoin() {
        em.flush();
        em.clear();

        final Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        final boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).isFalse();
    }

    /**
     * 페치 조인 !
     * FetchJoin !
     */
    @Test
    void useFetchJoin() {
        em.flush();
        em.clear();

        final Member findMember = queryFactory
                .selectFrom(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetchOne();

        final boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).isFalse();
    }
}

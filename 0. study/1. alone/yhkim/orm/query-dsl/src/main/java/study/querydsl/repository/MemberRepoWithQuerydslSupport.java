package study.querydsl.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.dto.QMemberTeamDto;
import study.querydsl.entity.Member;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

@Repository
public class MemberRepoWithQuerydslSupport extends QuerydslRepositorySupport {


    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     */
    public MemberRepoWithQuerydslSupport() {
        super(Member.class);
    }

    public List<MemberTeamDto> search(MemberSearchCondition condition) {

        return from(member)
                .leftJoin(member.team, team)
                .where(
                        userNameEq(condition.getUsername()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe())
                )
                .select(new QMemberTeamDto(
                        member.id,
                        member.username,
                        member.age,
                        team.id,
                        team.name))
                .fetch();
    }

    public List<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable) {

        JPQLQuery<MemberTeamDto> jpqlQuery = from(member)
                .leftJoin(member.team, team)
                .where(
                        userNameEq(condition.getUsername()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe())
                )
                .select(new QMemberTeamDto(
                        member.id,
                        member.username,
                        member.age,
                        team.id,
                        team.name
                ));

        JPQLQuery<MemberTeamDto> query = getQuerydsl().applyPagination(pageable, jpqlQuery);

        return query.fetch();
    }

    private BooleanExpression userNameEq(final String username) {
        return isEmpty(username) ? null : member.username.eq(username);
    }

    private BooleanExpression teamNameEq(final String teamName) {
        return isEmpty(teamName) ? null : team.name.eq(teamName);
    }

    private BooleanExpression ageGoe(final Integer ageGoe) {
        return ageGoe == null ? null : member.age.goe(ageGoe);
    }

    private BooleanExpression ageLoe(final Integer ageLoe) {
        return ageLoe == null ? null : member.age.loe(ageLoe);
    }
}

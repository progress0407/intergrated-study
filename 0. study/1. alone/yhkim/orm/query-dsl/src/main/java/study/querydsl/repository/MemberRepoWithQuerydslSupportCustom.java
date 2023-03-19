package study.querydsl.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.dto.QMemberTeamDto;
import study.querydsl.entity.Member;
import study.querydsl.support.Querydsl4RepositorySupport;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

@Repository
public class MemberRepoWithQuerydslSupportCustom extends Querydsl4RepositorySupport {


    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     */
    public MemberRepoWithQuerydslSupportCustom() {
        super(Member.class);
    }

    public List<Member> basicSelect() {

        return select(member)
                .from(member)
                .fetch();
    }

    public List<Member> basicSelectFrom() {

        return selectFrom(member)
                .fetch();
    }

    public Page<Member> searchPageByApplyPage(MemberSearchCondition condition, Pageable pageable) {

        return applyPagination(pageable, query -> query
                .selectFrom(member)
                .leftJoin(member.team, team)
                .where(
                        userNameEq(condition.getUsername()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe())
                )
        );
    }

    public Page<Member> searchPageByApplyPage2(MemberSearchCondition condition, Pageable pageable) {

        return applyPagination(
                pageable,

                contentQuery -> contentQuery
                        .selectFrom(member)
                        .leftJoin(member.team, team)
                        .where(
                                userNameEq(condition.getUsername()),
                                teamNameEq(condition.getTeamName()),
                                ageGoe(condition.getAgeGoe()),
                                ageLoe(condition.getAgeLoe())
                        ),

                countQuery -> countQuery
                        .selectFrom(member)
                        .where(
                                userNameEq(condition.getUsername()),
                                teamNameEq(condition.getTeamName()),
                                ageGoe(condition.getAgeGoe()),
                                ageLoe(condition.getAgeLoe())
                        )
        );
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

package study.querydsl.step1_basic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.querydsl.AbstractQuerydslTest;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;

class Dsl_3_Q_Type extends AbstractQuerydslTest {

    @Test
    public void startQuerydsl3() {

//        final QMember qMember = new QMember("m");
        final QMember qMember = QMember.member;

        //member1을 찾아라.
        Member findMember = queryFactory
                .select(qMember)
                .from(qMember)
                .where(qMember.username.eq("member1"))
                .fetchOne();
        assertThat(findMember.getUsername()).isEqualTo("member1");
    }
}

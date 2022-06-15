package jpa.app.shop.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import jpa.app.shop.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@DataJpaTest // bean 을 못가져온다
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원가입 및 조회")
    @Test
    void save_find() {
        Member member = new Member("swcho");
        Long savedId = memberRepository.save(member);

        Member find = memberRepository.findById(savedId);
        assertThat(find.getName()).isEqualTo("swcho");
    }

    @DisplayName("리스트 조회")
    @Test
    void findAll() {
        Member member1 = new Member("user-A");
        Member member2 = new Member("user-B");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();
        assertThat(members).containsExactlyInAnyOrder(member1, member2);
    }

    @DisplayName("이름 조회 테스트")
    @Test
    void findByName() {
        Member member1 = new Member("user-A");
        Member member2 = new Member("user-B");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> find = memberRepository.findByName("user-A");
        assertThat(find.get(0)).isSameAs(member1);
    }

    @DisplayName("일치하는 회원수 조회")
    @Test
    void memberExistCount() {
        Member member1 = new Member("user-A");
        Member member2 = new Member("user-B");
        Member member3 = new Member("user-A");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        long existRow = memberRepository.memberExistCount("user-A");
        long nonExistRow = memberRepository.memberExistCount("user-EE");

        assertThat(existRow).isSameAs(2L);
        assertThat(nonExistRow).isSameAs(0L);
    }
}
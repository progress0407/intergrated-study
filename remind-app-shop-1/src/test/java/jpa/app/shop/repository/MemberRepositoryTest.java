package jpa.app.shop.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import jpa.app.shop.domain.Member;
import org.junit.jupiter.api.BeforeEach;
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

    private Long savedId1;
    private Long savedId2;
    private Long savedId3;

    private Member member1;
    private Member member2;
    private Member member3;

    @BeforeEach
    void setUp() {
        memberRepository.clear();

        member1 = new Member("user-A");
        member2 = new Member("user-B");
        member3 = new Member("user-A");

        savedId1 = memberRepository.save(member1);
        savedId2 = memberRepository.save(member2);
        savedId3 = memberRepository.save(member3);
    }

    @DisplayName("회원가입 및 조회")
    @Test
    void save_find() {
        Member find = memberRepository.findById(savedId1).get();
        assertThat(find.getName()).isEqualTo("user-A");
    }

    @DisplayName("리스트 조회")
    @Test
    void findAll() {
        List<Member> members = memberRepository.findAll();
        assertThat(members).containsExactlyInAnyOrder(member1, member2, member3);
    }

    @DisplayName("이름 조회 테스트")
    @Test
    void findByName() {
        List<Member> find = memberRepository.findByName("user-A");
        assertThat(find.get(0)).isSameAs(member1);
    }

    @DisplayName("일치하는 회원수 조회")
    @Test
    void memberExistCount() {
        long existRow = memberRepository.memberExistCount("user-A");
        long nonExistRow = memberRepository.memberExistCount("user-EE");

        assertThat(existRow).isSameAs(2L);
        assertThat(nonExistRow).isSameAs(0L);
    }

    @DisplayName("ID 삭제 테스트")
    @Test
    void deleteById() {
        memberRepository.deleteById(savedId1);
        Optional<Member> findOne = memberRepository.findById(savedId1);

        assertThat(findOne).isEmpty();
    }
}

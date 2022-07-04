package practice.spring.data.jpa.doing.v2;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test_Isolation_Test {

    @Autowired
    DiscussionRepository discussionRepository;

    /**
     * 테스트 격리를 하기 위해 clearAll() 메서드를 setUp에 넣어서 구현하면 좋다
     *
     * 그러나 id 값을 초기화하는 것은 DML 이 아닌 DDL 의 레벨인데... JPQL 문법으로 불가능하기 때문에
     *
     * id값은 테스트할때 뺴는 것이 좋을 것 같다
     */

    @BeforeEach
    void setUp() {
//        discussionRepository.clearAll();
    }

    @DisplayName("id 발급: 1")
    @Transactional
    @Test
    void test_1() {
        Discussion discussion = new Discussion();
        discussionRepository.save(discussion);

        assertThat(discussion.getId()).isEqualTo(1);
    }

    @DisplayName("id 발급: 2")
    @Transactional
    @Test
    void test_2() {
        Discussion discussion = new Discussion();
        discussionRepository.save(discussion);

        assertThat(discussion.getId()).isEqualTo(1);
    }
}

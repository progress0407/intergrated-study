package practice.spring.data.jpa.doing.v2;

import static java.lang.System.out;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Discussion_Opinion_Test {

    @Autowired
    DiscussionRepository repository;

    @Autowired
    EntityManager em;

    @DisplayName("save")
    @Test
    @Transactional
    void save() throws InterruptedException {
        Discussion discussion = new Discussion();
        discussion.setTitle("sample discussion");
        discussion.setAnonymous(true);
        discussion.setViews(5);

        Discussion savedDiscussion = repository.save(discussion);

        out.println("savedDiscussion = " + savedDiscussion);

        Thread.sleep(1000L);

        em.flush();
        em.clear();

        discussion.setContent("update discussion");

        out.println("savedDiscussion = " + savedDiscussion);
    }

}
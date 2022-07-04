package practice.spring.data.jpa.doing.v2;

import static java.lang.System.out;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class Discussion_Opinion_Test {

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    OpinionRepository opinionRepository;

    @Autowired
    EntityManager em;

    @DisplayName("save")
    @Test
    void save() throws InterruptedException {
        Discussion discussion = new Discussion();
        discussion.setTitle("sample discussion");
        discussion.setAnonymous(true);
        discussion.setViews(5);

        Discussion savedDiscussion = discussionRepository.save(discussion);

        out.println("savedDiscussion = " + savedDiscussion);

        Thread.sleep(1000L);

        discussion.setContent("update discussion");

        em.flush();

        out.println("savedDiscussion = " + savedDiscussion);
    }

    @DisplayName("d-find")
    @Test
    void opinion_discussion_() {
        Discussion discussion = new Discussion();
        Discussion save = discussionRepository.save(discussion);
        Optional<Discussion> optional = discussionRepository.findById(save.getId());
        out.println("optional = " + optional);
    }

    @DisplayName("d_o")
    @Test
    void d_o_() {
        Discussion discussion = new Discussion();

        discussionRepository.save(discussion);

        Opinion opinion = new Opinion();
//        opinion.setDiscussion(discussion);
//        discussion.getOpinions().add(opinion);
        discussion.addOpinion(opinion);

        opinionRepository.save(opinion);

        em.flush();

        Discussion findDiscussion = discussionRepository.findById(discussion.getId()).get();
        Opinion findOpinion = opinionRepository.findById(opinion.getId()).get();

        out.println("findDiscussion opinions = " + findDiscussion.getOpinions());
        out.println("opinion discussion" + opinion.getDiscussion());
    }
}

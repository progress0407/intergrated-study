package hellojpa.doing.v3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.doing.GlobalTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class V3_Test extends GlobalTestConfig {

    Team team1;
    User user1;
    Item item;


    @BeforeEach
    void setUp() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        team1 = new Team("team-1");

        user1 = new User("user-1");

        item = new Item("item-1");

        user1.setTeam(team1);
        item.setUser(user1);

        em.persist(team1);

        em.flush();
        em.clear();
        tx.commit();
    }

    @DisplayName("team - user - item 3개 조인")
    @Test
    void fetch_join_with_3() {
        List<Team> teams = em.createQuery("select t from Team t join fetch t.users u join fetch u.item i", Team.class)
                .getResultList();

        for (Team team : teams) {
            System.out.println("# team = " + team);
            for (User user : team.getUsers()) {
                System.out.println("# user = " + user);
                for (Item item : user.getItems()) {
                    System.out.println("# item = " + item);
                }
            }
        }
    }
}

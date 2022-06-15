package hellojpa.doing.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class V2Test {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    EntityManager em = emf.createEntityManager();

    @DisplayName("qwe")
    @Test
    void qwe2() {
        Team team = new Team("t1", "team1");
        User user = new User("u1", "user1");
        User user2 = new User("u2", "user2");
        user.setTeam(team);
        user2.setTeam(team);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user);
        em.persist(user2);
        em.persist(team);

        em.flush();
        em.clear();

//        Team findTeam = em.find(Team.class, "t1");

        User findUser = em.find(User.class, "u1");
        System.out.println("findUser = " + findUser);

        tx.commit();
    }
}

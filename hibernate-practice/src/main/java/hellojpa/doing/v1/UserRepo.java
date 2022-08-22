package hellojpa.doing.v1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    private EntityManager em = emf.createEntityManager();

    public void save(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user);

        tx.commit();

//        em.persist(new User("user-2", "sec 회원"));
//        tx.commit(); // 커밋뿐만 안리ㅏ tx를 닫는다

//        em.close();
    }

    public User find(String id) {
        return em.find(User.class, id);
    }
}

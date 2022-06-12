package hellojpa;

import hellojpa.domain.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PureJavaMain {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");


	public static void main(String[] args) {
		PureJavaMain main = new PureJavaMain();
		main.run();
	}

	public void run() {

		User user = createMember("user-1", "최초 회원");

		user.setUserName("변경된 회원");

		mergeUser(user);

	}

	private User createMember(String id, String name) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		User user = new User(id, name);

		em.persist(user);

		tx.commit();

		em.detach(user);

		em.close();

		return user;
	}

	private User mergeUser(User user) {

		EntityManager em2 = emf.createEntityManager();

		EntityTransaction tx = em2.getTransaction();
		tx.begin();

		User mergedUser = em2.merge(user);

		tx.commit();

		System.out.println("user.getUserName() = " + user.getUserName());
		System.out.println("mergedUser.getUserName() = " + mergedUser.getUserName());
		System.out.println("em2.contains(user) = " + em2.contains(user));
		System.out.println("em2.contains(mergedUser) = " + em2.contains(mergedUser));

		em2.close();

		return mergedUser;
	}
}

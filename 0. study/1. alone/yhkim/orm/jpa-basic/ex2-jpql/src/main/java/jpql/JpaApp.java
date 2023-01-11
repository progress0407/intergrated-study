package jpql;

import static java.lang.System.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

public class JpaApp {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			// code1(em);
			// code2(em);
			// code3(em);
			// code4(em);
			// code5(em);
			code6(em);

			tx.commit();

		} catch (Exception e) {
			out.println("------------------------------------ rollback ------------------------------------");
			tx.rollback();
			e.printStackTrace();
		}
	}

	private static void code6(EntityManager em) {
		Member userA = Member.builder()
			.name("user a")
			.age(20)
			.build();

		Member userB = Member.builder()
			.name("user b")
			.age(20)
			.build();

		Member userC = Member.builder()
			.name("user c")
			.age(20)
			.build();

		Team teamA = Team.builder()
			.name("team a")
			.build();

		Team teamB = Team.builder()
			.name("team b")
			.build();

		teamA.addMembers(userA, userB);
		teamB.addMembers(userC);

		em.persist(teamA);
		em.persist(teamB);

		em.flush();
		em.clear();

		String query = "select t from Team t";

		List<Team> result = em.createQuery(query, Team.class)
			.getResultList();

		for (Team team : result) {
			out.println("team = " + team);
			List<Member> members = team.getMembers();
			for (Member member : members) {
				out.println(" - member name = " + member.getName());
			}
		}
	}

	private static void code5(EntityManager em) {
		Team teamA = Team.builder().name("team a").build();

		Member userA = Member.builder()
			.name("user a")
			.age(15)
			.build();

		Member userB = Member.builder()
			.name("user b")
			.age(19)
			.build();

		teamA.addMembers(userA, userB);

		em.persist(teamA);

		em.flush();
		em.clear();

		PersistenceUtil pu = Persistence.getPersistenceUtil();

		Member findMemberA = em.find(Member.class, userA.getId());

		Team findTeam = findMemberA.getTeam();
		out.println("#1 is findTeam load ? " + pu.isLoaded(findTeam));
		out.println("#1 findTeam = " + findTeam.getClass().getName());

		findTeam.getId();
		out.println("#2 is findTeam load ? " + pu.isLoaded(findTeam));
		out.println("#2 findTeam = " + findTeam.getClass().getName());

		findTeam.getName();

		out.println("#3 is findTeam load ? " + pu.isLoaded(findTeam));
		out.println("#3 findTeam = " + findTeam.getClass().getName());
	}

	private static void code4(EntityManager em) {
		Member member = Member.builder()
			.name("swcho")
			.age(30)
			.build();

		em.persist(member);

		em.flush();
		em.clear();

		Member findMember = em.createQuery("select m from Member m where m.name = :username", Member.class)
			.setParameter("username", "swcho")
			.getSingleResult();

		findMember.setAge(31);
	}

	private static void code3(EntityManager em) {

		Member[] userArr = new Member[101];

		for (int i = 1; i <= 40; i++) {
			userArr[i] = Member.builder()
				.name("foo " + i)
				.age(i)
				.build();
			// em.persist(userArr[i]);
		}

		Team[] teamArr = new Team[101];

		for (int i = 21; i < 60; i++) {
			teamArr[i] = Team.builder()
				.name("foo " + i)
				.build();
			// em.persist(teamArr[i]);
		}

		for (int i = 31; i <= 40; i++) {
			userArr[i].changeTeam(teamArr[i]);
		}

		Order order = Order.builder()
			.orderAmount(2000)
			.address(new Address("ciry a", "steet a", "zipcode a"))
			.build();

		Product product = Product.builder()
			.name("apple m1 mac")
			.stockAmount(1_000)
			.price(1_000_000)
			.build();

		product.addOrders(order);

		em.persist(order);
		em.persist(product);

		userArr[10].addOrders(order);

		String jpql =
			// "select m from Member m where exists (select t from m.team t where t.name = 'foo 31') ";
			// "select o from Order o where o.orderAmount > ALL (select p.stockAmount from Product p)";
			"select m from Member m where m.team = ANY (select t from Team t) ";

		List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();
		// List<Order> orderList = em.createQuery(jpql, Order.class).getResultList();

		out.println("------------------ start ------------------");
		out.println("#resultList.size() = " + resultList.size());
		out.println("------------------ end ------------------");

	}

	private static void code2(EntityManager em) {

		Member[] userArr = new Member[101];

		for (int i = 1; i <= 100; i++) {
			userArr[i] = Member.builder()
				.name("user " + i)
				.age(i)
				.build();
			em.persist(userArr[i]);
		}

		em.flush();

		String jpql = "select m from Member m order by m.age asc ";

		List<Member> resultList = em.createQuery(jpql, Member.class)
			.setFirstResult(3)
			.setMaxResults(20)
			.getResultList();

		for (Member findMember : resultList) {
			out.println(findMember);
		}
	}

	private static void code1(EntityManager em) {
		Team teamA = Team.builder().name("team a").build();

		Member userA = Member.builder()
			.name("user a")
			.age(15)
			.build();

		Member userB = Member.builder()
			.name("user b")
			.age(19)
			.build();

		teamA.addMembers(userA, userB);

		Order order = Order.builder()
			.orderAmount(500)
			.address(new Address("ciry a", "steet a", "zipcode a"))
			.build();
		userA.addOrders(order);

		Product product = Product.builder()
			.name("product a")
			.stockAmount(1200)
			.price(1500)
			.build();

		product.addOrders(order);

		em.persist(teamA);
		em.persist(userA);
		em.persist(userB);

		em.persist(order);
		em.persist(product);

		TypedQuery<MemberDto> query =
			em.createQuery("select new jpql.MemberDto(m.name, m.age) from Member m ", MemberDto.class);
		List<MemberDto> resultList = query.getResultList();

		for (MemberDto memberDto : resultList) {
			out.println("memberDto = " + memberDto);
		}
	}
}

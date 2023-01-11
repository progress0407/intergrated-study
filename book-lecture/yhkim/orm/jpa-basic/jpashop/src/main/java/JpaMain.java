import static java.lang.System.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Album;
import domain.Book;
import domain.Member;
import domain.Movie;
import domain.Order;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			// tx1(em); // member ~ order
			// tx2(em); // order ~ item
			// tx3(em); // 다양한 연관관계
			tx4(em); // 상속

			tx.commit();
		} catch (Exception e) {
			out.println("-------------- rollback !! --------------");
			tx.rollback();
			e.printStackTrace();
		}

		em.close();
		emf.close();

	}

	private static void tx4(EntityManager em) {

		Movie movie = new Movie();
		movie.setName("movie a");
		movie.setActor("actor a");

		Book book = new Book();
		book.setName("book b");
		book.setAuthor("author b");

		Album album = new Album();
		album.setName("album c");
		album.setArtist("artist c");

		em.persist(movie);
		em.persist(book);
		em.persist(album);
	}

/*
	private static void tx3(EntityManager em) {

		Member member = new Member("swcho");
		member.setId2(123L);

		Delivery delivery = new Delivery();
		delivery.setStatus(DeliveryStatus.DELIVERING);
		delivery.setCity("seoul");
		delivery.setZipCode("12-345");

		Order order = new Order();
		order.setOrderStatus(OrderStatus.ORDER);
		order.setDelivery(delivery);

		member.setOrders(Arrays.asList(order));
		order.setMember(member);

		Item item = new Item("한성 올데이롱 TFX-5470H");

		Category parentCategory = new Category("전자기기");
		Category childCategory = new Category("노트북");

		childCategory.setParent(parentCategory);

		// item.setCategories(Arrays.asList(childCategory)); // read-only 이기 때문에 쓰기 불가
		// childCategory.setItems(Arrays.asList(item));

		// 연관관계 편의 메서드
		childCategory.addItem(item);

		em.persist(member);
		em.persist(order);
		em.persist(delivery);
		em.persist(parentCategory);
		em.persist(childCategory);
		em.persist(item);

	}
*/

/*
	private static void tx2(EntityManager em) {
		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus(OrderStatus.ORDER);
		em.persist(order);

		Item item = new Item("맥북 m1");
		em.persist(item);

		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		orderItem.setOrder(order);
		orderItem.setCount(10);
		orderItem.setOrderPrice(30_000);

		em.persist(orderItem);
	}
*/

	private static void tx1(EntityManager em) {
		Member member = new Member("성우초짱");
		em.persist(member);

		Order order = new Order();
		em.persist(order);

		order.addMember(member);

		Long findMemberId = member.getId();
		out.println("findMemberId = " + findMemberId);
		Member findMember = em.find(Member.class, findMemberId);
		List<Order> findOrders = findMember.getOrders();

		out.println("===============================================================");
		for (Order findOrder : findOrders) {
			out.println("findOrder = " + findOrder);
		}
		out.println("===============================================================");
	}
}

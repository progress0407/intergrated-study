package jpa.app.shop.repository;

import javax.persistence.EntityManager;
import jpa.app.shop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

	private final EntityManager em;

	public Long save(Order order) {
        em.persist(order);
        return order.getId();
	}

	public Order findOne(Long id) {
        return em.find(Order.class, id);
	}

	// 동적인 것은 queryDsl 로 뽑자 !
	/*public List<Order> findAll(OrderSearch orderSearch) {
	}

	// 순수 jpql 로 힘듬 1
	public List<Order> findAllByString(OrderSearch orderSearch) {
	}

	// 순수 jpql 로 힘듬 2
	public List<Order> findAllByCriteria(OrderSearch orderSearch) {
	}*/

	public void clear() {
		em.createQuery("delete from Order m").executeUpdate();
	}
}

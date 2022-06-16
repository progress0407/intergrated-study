package jpa.app.shop.service;

import java.util.List;
import jpa.app.shop.domain.Delivery;
import jpa.app.shop.domain.Member;
import jpa.app.shop.domain.Order;
import jpa.app.shop.domain.OrderItem;
import jpa.app.shop.domain.item.Item;
import jpa.app.shop.repository.ItemRepository;
import jpa.app.shop.repository.MemberRepository;
import jpa.app.shop.repository.OrderRepository;
import jpa.app.shop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	private final MemberRepository memberRepository;

	private final ItemRepository itemRepository;

	/**
	 * 주문
	 */
	@Transactional
	public Long order(Long memberId, Long itemId, long orderCount) {

		Member member = memberRepository.findById(memberId)
				.orElse(null);
		Item item = itemRepository.findById(itemId)
				.orElse(null);

		Delivery delivery = new Delivery();
		delivery.setAddress(member.getAddress());

		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderCount);

		Order order = Order.createOrder(member, delivery, orderItem);

		orderRepository.save(order);

		return order.getId();
	}

	/**
	 * 주문 취소
	 */
	@Transactional
	public void cancelOrder(long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElse(null);
		order.cancel();
	}

	/**
	 * 검색
	 */
	public List<Order> findOrders(OrderSearch orderSearch) {
		return orderRepository.findAllByString(orderSearch);
	}

}

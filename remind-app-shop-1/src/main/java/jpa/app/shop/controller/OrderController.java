package jpa.app.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OrderController {

/*	private final OrderService orderService;
	private final MemberService memberService;
	private final ItemService itemService;

	@GetMapping("/order")
	public String createForm(Model model) {

		List<Member> members = memberService.findMembers();
		List<Item> items = itemService.findItems();

		model.addAttribute("members", members);
		model.addAttribute("items", items);

		return "order/orderForm";
	}

	@PostMapping("/order")
	public String order(
		@RequestParam Long memberId,
		@RequestParam Long itemId,
		@RequestParam int count) {

		orderService.order(memberId, itemId, count);

		return "redirect:/orders";
	}

	@GetMapping("/orders")
	public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

		List<Order> orders = orderService.findOrders(orderSearch);
		model.addAttribute("orders", orders);

		return "order/orderList";
	}

	@PostMapping("/orders/{orderId}/cancel")
	public String cancelOrder(@PathVariable Long orderId) {
		orderService.cancelOrder(orderId);
		return "redirect:/orders";
	}*/
}

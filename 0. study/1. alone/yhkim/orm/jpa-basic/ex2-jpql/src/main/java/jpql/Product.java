package jpql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Builder.Default
	@OneToMany(mappedBy = "product")
	private List<Order> orders = new ArrayList<>();

	private int price;

	@Column(name = "STOCK_AMOUNT")
	private int stockAmount;

	public void addOrders(Order... orders) {
		this.orders.addAll(Arrays.asList(orders));
		Arrays.stream(orders).forEach(order -> order.setProduct(this));
	}
}

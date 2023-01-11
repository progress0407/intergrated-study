package jpql;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ORDERS")
@Builder @Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@JoinColumn(name = "ORDER_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@Setter @ToString.Exclude
	private Member member;

	@JoinColumn(name = "PRODUCT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@Setter @ToString.Exclude
	private Product product;

	@Column(name = "ORDER_AMOUNT")
	private int orderAmount;

	@Embedded
	private Address address;

}

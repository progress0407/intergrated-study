package domain;

import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Delivery {

	@Id @GeneratedValue
	private Long id;

	private DeliveryStatus status;

	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	@ToString.Exclude
	private Order order;

	@Embedded
	private Address address;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Delivery delivery = (Delivery)o;
		return Objects.equals(getId(), delivery.getId()) && getStatus() == delivery.getStatus()
			&& Objects.equals(getOrder(), delivery.getOrder()) && Objects.equals(getAddress(),
			delivery.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getStatus(), getOrder(), getAddress());
	}
}

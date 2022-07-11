package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
abstract public class Item extends DateTimeBaseEntity{

	@Id
	@GeneratedValue(generator = "item_uuid_generator")
	@GenericGenerator(name = "item_uuid_generator", strategy = "uuid")
	@Column(name = "ITEM_ID")
	private String id;

	@Column(name = "ITEM_NAME")
	private String name;

	private int price;

	private int stockQuantity;

	@OneToMany(mappedBy = "item")
	@ToString.Exclude
	private List<OrderItem> orderItem = new ArrayList<>();

	@ManyToMany(mappedBy = "items")
	@ToString.Exclude
	private List<Category> categories = new ArrayList<>();

	public Item(String name) {
		this.name = name;
	}
}

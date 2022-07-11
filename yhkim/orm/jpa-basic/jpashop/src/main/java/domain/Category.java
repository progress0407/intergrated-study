package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter @Setter @ToString
public class Category {

	@Id @GeneratedValue
	private Long id;

	private String name;

	// 셀프 조인
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	@ToString.Exclude
	private Category parent;

	// 셀프 조인
	@OneToMany(mappedBy = "parent")
	@ToString.Exclude
	private List<Category> child = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM",
		joinColumns = @JoinColumn(name = "CATEGORY_ID"),
		inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)
	@ToString.Exclude
	private List<Item> items = new ArrayList<>();

	public Category(String name) {
		this.name = name;
	}

	public void addItem(Item item) {
		items.add(item);
		item.getCategories().add(this);
	}
}

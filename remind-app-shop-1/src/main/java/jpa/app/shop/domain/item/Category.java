package jpa.app.shop.domain.item;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private Long id;

    private String name;

    private List<Item> items = new ArrayList<>();

    @JoinColumn(name = "parent_id")
    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public Category(String name, List<Item> items, Category parent, List<Category> child) {
        this.name = name;
        this.items = items;
        this.parent = parent;
        this.child = child;
    }
}

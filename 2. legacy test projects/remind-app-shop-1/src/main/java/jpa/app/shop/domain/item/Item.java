package jpa.app.shop.domain.item;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import jpa.app.shop.domain.OrderItem;
import jpa.app.shop.exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private long price;

    @Column(name = "stock_quantity")
    private long stockQuantity;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Item(String name, long price, long stockQuantity) {
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(long quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(long quantity) {
        long restStock = stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

    public void changeItem(Item item) {
        this.price = item.price;
        this.name = item.name;
        this.stockQuantity = item.stockQuantity;
    }
}

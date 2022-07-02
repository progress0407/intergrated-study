package hellojpa.doing.v5;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

//@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private long price;

    @Column(name = "stock_quantity")
    private long stockQuantity;

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
            throw new RuntimeException("need more stock");
        }
        this.stockQuantity = restStock;
    }

    public void changeItem(Item item) {
        this.price = item.price;
        this.name = item.name;
        this.stockQuantity = item.stockQuantity;
    }
}

package jpa.app.shop.domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "item_id")
    private Long id;

    private String name;

    @Column(name = "stock_quantity")
    private Long stockQuantity;

    public Item(String name, Long stockQuantity) {
        this.name = name;
        this.stockQuantity = stockQuantity;
    }
}

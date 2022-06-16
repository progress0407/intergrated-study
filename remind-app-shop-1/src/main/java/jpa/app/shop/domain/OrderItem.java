package jpa.app.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import jpa.app.shop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "order_item")
@ToString
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_item_id")
    private Long id;

    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private Long orderPrice;

    private Long count;

    protected OrderItem() {
    }

    public static OrderItem createOrderItem(Item item, long orderPrice, long orderCount) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(orderCount);

        item.removeStock(orderCount);

        return orderItem;
    }

    public void cancel() {
        getItem().addStock(count);
    }

    public long getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}

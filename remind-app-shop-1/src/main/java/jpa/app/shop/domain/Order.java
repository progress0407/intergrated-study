package jpa.app.shop.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id")
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @JoinColumn(name = "delivery_id")
    @OneToOne
    private Delivery delivery;


    public void setMember(Member member) {
//        member.getOrders().add(this); // 정말 주의해야 한다... 2중으로 데이터가 쌓일 수 있다
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.addOrders(this);
    }
}

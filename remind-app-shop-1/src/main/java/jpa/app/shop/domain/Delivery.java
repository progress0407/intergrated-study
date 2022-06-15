package jpa.app.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import jpa.app.shop.domain.constant.DeliveryStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}

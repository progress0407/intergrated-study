package practice.spring.data.jpa.doing.v1;

import org.springframework.beans.factory.annotation.Value;

interface ItemView2 {
    Long getId();
    String getName();

    @Value("#{target.price + ' ' + target.stockQuantity}")
    String getPriceAndQuantity();
}

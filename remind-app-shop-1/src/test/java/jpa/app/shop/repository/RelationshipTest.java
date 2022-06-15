package jpa.app.shop.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDateTime;
import jpa.app.shop.domain.Member;
import jpa.app.shop.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class RelationshipTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    private Member member1;
    private Member member2;
    private LocalDateTime now;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        member1 = new Member("user-1");
        member2 = new Member("user-2");

        now = LocalDateTime.now();

        order1 = Order.builder()
                .orderDate(now)
                .build();
        order2 = Order.builder()
                .orderDate(now)
                .build();
    }

    /**
     * 교훈.. 양방향 메서드는 한쪽만 작성하자 !
     * 너무 어렵다...
     */
    @DisplayName("회원 및 주문을 등록할 수 있다, 일대다 편의 메서드")
    @Test
    void save_find_member_orders() {
        order1.setMember(member1);
        order2.setMember(member1);

        Long savedMemberId = memberRepository.save(member1);
        Long savedOrderId = orderRepository.save(order1);
        Long savedOrderId2 = orderRepository.save(order2);

        양방향_매핑_검증(savedMemberId, savedOrderId, savedOrderId2);
    }

    @DisplayName("회원 및 주문을 등록할 수 있다, 다대일 편의 메서드")
    @Test
    void save_find_member_orders_2() {
        member1.addOrders(order1, order2);

        Long savedMemberId = memberRepository.save(member1);
        Long savedOrderId = orderRepository.save(order1);
        Long savedOrderId2 = orderRepository.save(order2);

        양방향_매핑_검증(savedMemberId, savedOrderId, savedOrderId2);
    }

    @DisplayName("회원 및 주문을 등록할 수 있다, 다대일 편의 메서드, 여러번 등록시")
    @Test
    void save_find_member_orders_3() {
        member1.addOrders(order1, order2, order1, order2);

        Long savedMemberId = memberRepository.save(member1);
        Long savedOrderId = orderRepository.save(order1);
        Long savedOrderId2 = orderRepository.save(order2);

        양방향_매핑_검증(savedMemberId, savedOrderId, savedOrderId2);
    }

    @DisplayName("회원 및 주문을 등록할 수 있다, 삭제되지 않은 관계")
    @Test
    void save_find_member_orders_4() {
        order1.setMember(member1);
        order1.setMember(member2);

        assertAll(
                () -> assertThat(member1.getOrders().size()).isEqualTo(0),
                () -> assertThat(member2.getOrders().get(0)).isEqualTo(order1)
        );
    }

    @DisplayName("(단수) 프록시 객체 조회시 - 이경우 protected가 아니면 에러가 발생한다")
    @Test
    void proxy_object_should_be_protected() {
        order1.setMember(member1);
        order2.setMember(member1);

        Long savedMemberId = memberRepository.save(member1);
        Long savedOrderId = orderRepository.save(order1);
        Long savedOrderId2 = orderRepository.save(order2);

        Order findOrder1 = orderRepository.findOne(savedOrderId);
        System.out.println("findOrder1 = " + findOrder1);
    }

    @DisplayName("clear 2")
    @Test
    void clear2() {
        Long savedMemberId = memberRepository.save(member1);

        memberRepository.clear();

        Member find = memberRepository.findById(savedMemberId);
        System.out.println("find = " + find);
    }

    private void 양방향_매핑_검증(Long savedMemberId, Long savedOrderId, Long savedOrderId2) {
        Member findMember = memberRepository.findById(savedMemberId);
        Order findOrder1 = orderRepository.findOne(savedOrderId);
        Order findOrder2 = orderRepository.findOne(savedOrderId2);

        assertAll(
                () -> assertThat(findMember.getName()).isEqualTo(member1.getName()),
                () -> assertThat(now).isEqualTo(findOrder1.getOrderDate())
                        .isEqualTo(findOrder2.getOrderDate()),
                () -> assertThat(findMember.getOrders().size()).isEqualTo(2),
                () -> assertThat(findMember.getOrders()).containsExactlyInAnyOrder(findOrder1, findOrder2),
                () -> assertThat(findMember).isSameAs(findOrder1.getMember())
                        .isSameAs(findOrder2.getMember())
        );
    }
}

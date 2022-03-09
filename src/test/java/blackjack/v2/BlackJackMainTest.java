package blackjack.v2;

import org.junit.jupiter.api.Test;

public class BlackJackMainTest {

    /**
     * Inner 클래스로 new 로 재 생성
     * -> 실패
     */

    @Test
    void test1() {
        Denomination[] denominations = Denomination.values();
        for (Denomination denomination : denominations) {
            System.out.println("denomination = " + denomination);
        }
    }
}

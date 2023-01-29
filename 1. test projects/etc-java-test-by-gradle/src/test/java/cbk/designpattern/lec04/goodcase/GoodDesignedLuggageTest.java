package cbk.designpattern.lec04.goodcase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GoodDesignedLuggageTest {

    @Test
    @DisplayName("수하물이 일정 용량 안에 있으면 굳이 예외를 던지지 않는다")
    void in_store_amount_then_non_exception() {
        // given
        Container container = new Container(4);
        Luggage luggageA = new Luggage(2);
        Luggage luggageB = new Luggage(2);

        // when & then
        Assertions.assertDoesNotThrow(() -> {
            container.put(luggageA);
            container.put(luggageB);
        });
    }

    @Test
    @DisplayName("수하물이 용량을 초과하면 예외를 던진다")
    void out_of_store_amount_then_exception() {
        // given
        Container container = new Container(4);
        Luggage luggageA = new Luggage(2);
        Luggage luggageB = new Luggage(3);

        // when & then
        Assertions.assertThrows(NotEnoughSpaceException.class, () -> {
            container.put(luggageA);
            container.put(luggageB);
        });
    }
}

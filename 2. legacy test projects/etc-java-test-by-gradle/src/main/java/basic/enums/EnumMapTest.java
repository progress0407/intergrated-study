package basic.enums;

import java.util.EnumMap;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class EnumMapTest {

    @Test
    void test() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        ranks.put(Rank.SECOND, 2);
        ranks.put(Rank.FIRST, 1);
        ranks.put(Rank.THIRD, 3);
        for (Entry<Rank, Integer> entry : ranks.entrySet()) {
            System.out.printf("key = %s, value = %s \n", entry.getKey(), entry.getValue());
        }
    }

    private enum Rank {
        FIRST, SECOND, THIRD;
    }
}

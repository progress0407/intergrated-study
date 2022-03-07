package simple;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

public class SimpleTest {

    @Test
    void test() {

    }

    private static class LottoTicket {

    }

    private enum LottoTicketFactory {
        INSTANCE;

        public static LottoTicketFactory getInstance() {
            return INSTANCE;
        }
    }
}

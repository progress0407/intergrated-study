package expiry.mine;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ServiceExpirationCalculatorTest {

    /**
     * 1. 서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한달 뒤가 서비스 만료일이 된다.
     * <p>
     * 2. 2개월 이상 요금을 납부할 수 있다.
     * <p>
     * 3. 10만 원을 납부하면 서비스를 1년 제공한다.
     */

    @ParameterizedTest
    @CsvSource(value = {"2022-3-7-2023-3-7", "2021-4-7-2022-4-7"}, delimiter = '-')
    @DisplayName("10만 원을 납부하면 서비스를 1년 제공한다")
    void if_pay_10_000_then_provide_service_for_1_month(int baseYear, int baseMonth, int baseDay,
                                                        int expirationYear, int expirationMonth, int expirationDay) {
        // given
        LocalDate baseDate = LocalDate.of(baseYear, baseMonth, baseDay);
        ServiceExpirationCalculator serviceExpirationCalculator = new ServiceExpirationCalculator(baseDate, 100_000);
        // when
        LocalDate expirationDate = serviceExpirationCalculator.getExpirationDay();

        // then
        Assertions.assertEquals(expirationDate, LocalDate.of(expirationYear, expirationMonth, expirationDay));
    }

    @ParameterizedTest
    @CsvSource(value = {"2022-3-7-2022-4-7", "2021-4-7-2021-5-7"}, delimiter = '-')
    @DisplayName("1만원을 납부하면 서비스를 1개월 제공한다")
    void if_pay_100_000_then_provide_service_for_1_year(int baseYear, int baseMonth, int baseDay,
                                                        int expirationYear, int expirationMonth, int expirationDay) {
        // given
        LocalDate baseDate = LocalDate.of(baseYear, baseMonth, baseDay);
        ServiceExpirationCalculator serviceExpirationCalculator = new ServiceExpirationCalculator(baseDate, 10_000);
        // when
        LocalDate expirationDate = serviceExpirationCalculator.getExpirationDay();

        // then
        Assertions.assertEquals(expirationDate, LocalDate.of(expirationYear, expirationMonth, expirationDay));
    }

    @Test
    @DisplayName("2개월 이상 요금을 납부하면 해당 월만큼 이용이 가능하다")
    void if_pay_n_10_000_then_provide_service_for_n_year() {
        // given
        LocalDate baseDate = LocalDate.of(2022, 3, 8);
        ServiceExpirationCalculator serviceExpirationCalculator = new ServiceExpirationCalculator(baseDate, 10_000);
        serviceExpirationCalculator.payAdditional(10_000);

        // when
        LocalDate expirationDate = serviceExpirationCalculator.getExpirationDay();

        // then
        Assertions.assertEquals(expirationDate, LocalDate.of(2022, 5, 8));
    }

    @ParameterizedTest
    @ValueSource(ints = {9_000, 12_000})
    @DisplayName("10,000원 혹은 100,000원이 아닌 단위의 금액을 내면 예외가 발생한다.")
    void if_pay_another_unit_then_exception(int payment) {
        // given
        LocalDate baseDate = LocalDate.of(2022, 3, 8);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ServiceExpirationCalculator(baseDate, payment));
    }

    @ParameterizedTest
    @ValueSource(ints = {9_000, 12_000})
    @DisplayName("초기에 10,000원을 납입하고 10,000원 혹은 100,000원이 아닌 단위의 금액을 내면 예외가 발생한다.")
    void if_init_pay_10000_and_pay_another_unit_then_exception(int payment) {
        // given
        LocalDate baseDate = LocalDate.of(2022, 3, 8);

        // when & then
        ServiceExpirationCalculator serviceExpirationCalculator = new ServiceExpirationCalculator(baseDate, 10_000);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> serviceExpirationCalculator.payAdditional(payment));
    }


}

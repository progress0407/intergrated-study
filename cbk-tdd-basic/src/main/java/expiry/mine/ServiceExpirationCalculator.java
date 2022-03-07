package expiry.mine;

import java.time.LocalDate;
import java.util.Arrays;

public class ServiceExpirationCalculator {
    public static final String UNACCEPTABLE_PAYMENT_UNIT = "허용되지 않는 금액의 단위입니다.";
    private LocalDate baseDate;
    private int payment;

    public ServiceExpirationCalculator(LocalDate baseDate, int payment) {
        this.baseDate = baseDate;
        this.payment = payment;
        validatePaymentUnit(payment);
    }

    public LocalDate getExpirationDay() {
        if (PaymentUnit.sameYearPayment(payment)) {
            return baseDate.plusYears(1L);
        }
        return baseDate.plusMonths(1L);
    }

    public void payAdditional(int payment) {
        this.payment += payment;
        baseDate = baseDate.plusMonths(1L);
        validatePaymentUnit(payment);

    }

    private void validatePaymentUnit(int payment) {
        if (PaymentUnit.notInPayment(payment)) {
            throw new IllegalArgumentException(UNACCEPTABLE_PAYMENT_UNIT);
        }
    }

    private enum PaymentUnit {
        MONTH_PAYMENT(10_000), YEAR_PAYMENT(100_000);

        private final int payment;

        PaymentUnit(int payment) {
            this.payment = payment;
        }

        public static boolean sameYearPayment(int payment) {
            return payment == YEAR_PAYMENT.payment;
        }

        public static boolean inPayment(int payment) {
            return Arrays.stream(PaymentUnit.values())
                    .anyMatch((PaymentUnit paymentUnit) -> paymentUnit.payment == payment);
        }

        public static boolean notInPayment(int payment) {
            return !inPayment(payment);
        }
    }
}

package vacation;

import static vacation.DateTimeUnit.*;
import static vacation.PlusMinus.*;

public enum Vacation {

      V01(1_000_001L, "휴가", DAY, MINUS)
    , V02(1_000_002L, "반차", HALF_DAY, MINUS)
    , V03(1_000_003L, "외출", HOUR, MINUS)
    , V04(1_000_004L, "조퇴", HOUR, MINUS)
    , V05(1_000_005L, "지각", SEC, MINUS)
    , V06(1_000_006L, "공가", DAY, NEUTRAL)
    , V07(1_000_107L, "대체휴일", DAY, PLUS);

    final Long id;
    final String name;
    final DateTimeUnit dateTimeUnit;
    final PlusMinus plusMinus;

    Vacation(Long id, String name, DateTimeUnit dateTimeUnit, PlusMinus plusMinus) {
        this.id = id;
        this.name = name;
        this.dateTimeUnit = dateTimeUnit;
        this.plusMinus = plusMinus;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateTimeUnit=" + dateTimeUnit +
                '}';
    }
}

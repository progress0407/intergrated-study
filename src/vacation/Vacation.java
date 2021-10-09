package vacation;

import static vacation.DateTimeUnit.*;
import static vacation.PlusMinus.*;

public enum Vacation {

      V01(1000_1001L, "휴가", DAY, MINUS)
    , V02(1000_1002L, "반차", HALF_DAY, MINUS)
    , V03(1000_1003L, "외출", HOUR, MINUS)
    , V04(1000_1004L, "조퇴", HOUR, MINUS)
    , V05(1000_1005L, "지각", SEC, MINUS)
    , V06(1000_1006L, "공가", HOUR, NEUTRAL);

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

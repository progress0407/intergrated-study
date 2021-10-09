package vacation;

import java.time.LocalDateTime;

public class VacationRequest {

    private final static int HOUR_SECOND = 3600;
    private final static int MINUTE_SECOND = 60;

    Vacation vacation;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public VacationRequest(Vacation vacation, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.vacation = vacation;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    // 휴가/부재의 종류에 다라 다른 연산 적용
    public int second() {

        int term = vacation.plusMinus.term;

        switch (this.vacation) {
            case V03: // 외출
            case V04: // 조퇴
                int timeInterval = (endDateTime.getHour() * HOUR_SECOND + endDateTime.getMinute() * MINUTE_SECOND)
                        - (startDateTime.getHour() * HOUR_SECOND + startDateTime.getMinute() * MINUTE_SECOND);
                return timeInterval * term;
            case V05: // 지각
                timeInterval = (endDateTime.getHour() * HOUR_SECOND + endDateTime.getMinute() * MINUTE_SECOND + endDateTime.getSecond())
                        - (9 * HOUR_SECOND);
                return timeInterval * term;
        }

        return vacation.dateTimeUnit.second * term;
    }

    @Override
    public String toString() {
        return "VacationRequest{" +
                "vacation=" + vacation +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}

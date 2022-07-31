package skeleton.code.schedule.application;

import java.time.DayOfWeek;
import java.time.LocalTime;
import skeleton.code.schedule.entity.MeetingSchedule;

public abstract class EventCondition {

    private static DayOfWeek DAY_OF_WEEK = DayOfWeek.MONDAY;
    private static LocalTime TIME = LocalTime.of(9, 30);

    public static boolean isOpen(MeetingSchedule meetingSchedule) {
        dayOfWeekCondition(meetingSchedule);
        timeCondition(meetingSchedule);

        return dayOfWeekCondition(meetingSchedule) && timeCondition(meetingSchedule);
    }

    private static boolean timeCondition(final MeetingSchedule meetingSchedule) {
        final LocalTime openTime = TIME.minusMinutes(30);
        return TIME.isAfter(openTime);
    }

    private static boolean dayOfWeekCondition(final MeetingSchedule meetingSchedule) {
        return DAY_OF_WEEK.equals(meetingSchedule.getDayOfWeek());
    }
}

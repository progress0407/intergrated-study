package skeleton.code.schedule.application;

import java.util.List;
import org.springframework.stereotype.Component;
import skeleton.code.schedule.entity.MeetingSchedule;

@Component
public class AsyncTasker {

    public void postProcess(final List<MeetingSchedule> meetingSchedules) {
        for (final MeetingSchedule meetingSchedule : meetingSchedules) {
            if (EventCondition.isOpen(meetingSchedule)) {
                System.out.println("condition satisfy meetingSchedule = " + meetingSchedule);
            }
        }
    }
}

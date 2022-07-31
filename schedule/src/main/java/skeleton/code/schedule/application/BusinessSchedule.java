package skeleton.code.schedule.application;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import skeleton.code.schedule.entity.MeetingSchedule;
import skeleton.code.schedule.repository.MeetingScheduleRepository;

/**
 * 0 * * * * MON-FRI sec  min  hour  day  month  DoW
 */
@Component
@RequiredArgsConstructor
public class BusinessSchedule {

    /**
     * 테이블 구조1: 요일별
     *   예) 월,화...일
     *
     * 테이블 구조2: 모든 날짜에 대하여
     *   예) 1월 1일, 1월 2일... 31일
     */

    private final MeetingScheduleRepository repository;
    private final AsyncTasker asyncTasker;

    @Scheduled(cron = "*/1 * * * * *")
    public void selectData() {
        final List<MeetingSchedule> meetingSchedules = repository.findAll();

        /**
         * 필요한 후 처리는 여기서!
         */
        asyncTasker.postProcess(meetingSchedules);
    }
}

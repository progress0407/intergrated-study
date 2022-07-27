package skeleton.code.schedule.config;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.time.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import skeleton.code.schedule.entity.Meeting;
import skeleton.code.schedule.entity.Meeting.MeetingBuilder;
import skeleton.code.schedule.entity.MeetingSchedule;
import skeleton.code.schedule.repository.MeetingRepository;
import skeleton.code.schedule.repository.MeetingScheduleRepository;

@Component
@RequiredArgsConstructor
public class InitDataProvider implements ApplicationListener<ContextRefreshedEvent> {

    private final MeetingRepository meetingRepository;
    private final MeetingScheduleRepository meetingScheduleRepository;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final Meeting meeting1 = Meeting.builder().build();

        meetingRepository.save(meeting1);

        final MeetingSchedule meetingSchedule1 = MeetingSchedule.builder().meeting(meeting1).dayOfWeek(MONDAY).build();
        final MeetingSchedule meetingSchedule2 = MeetingSchedule.builder().meeting(meeting1).dayOfWeek(TUESDAY).build();
        final MeetingSchedule meetingSchedule3 = MeetingSchedule.builder().meeting(meeting1).dayOfWeek(WEDNESDAY).build();
        final MeetingSchedule meetingSchedule4 = MeetingSchedule.builder().meeting(meeting1).dayOfWeek(THURSDAY).build();
        final MeetingSchedule meetingSchedule5 = MeetingSchedule.builder().meeting(meeting1).dayOfWeek(FRIDAY).build();

        meetingScheduleRepository.save(meetingSchedule1);
        meetingScheduleRepository.save(meetingSchedule2);
        meetingScheduleRepository.save(meetingSchedule3);
        meetingScheduleRepository.save(meetingSchedule4);
        meetingScheduleRepository.save(meetingSchedule5);
    }
}

package practice.spring.data.jpa.doing.v3;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class V3_Repository_Test {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("test-1")
    @Test
    void test_1() {
        final LocalDate nowDate = LocalDate.now();
        final LocalTime nowTime = LocalTime.now();
        final Meeting meeting = new Meeting("모임-1", nowDate, nowDate, nowTime, nowTime);
        meetingRepository.save(meeting);

        meetingRepository.findById(meeting.getId());

        assertThat(meeting.getName()).isEqualTo("모임-1");
    }

    @DisplayName("test-2")
    @Test
    void test_2() {
        final LocalDate nowDate = LocalDate.now();
        final LocalTime nowTime = LocalTime.now();
        final Meeting meeting = new Meeting("모임-1", nowDate, nowDate, nowTime, nowTime);

        meetingRepository.save(meeting);

        final User user1 = new User("user-1", meeting);
        final User user2 = new User("user-2", meeting);
        final User user3 = new User("user-3", meeting);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        final Attendance attendance1 = new Attendance(user1, meeting);
        final Attendance attendance2 = new Attendance(user2, meeting);
        final Attendance attendance3 = new Attendance(user3, meeting);

        attendanceRepository.save(attendance1);
        attendanceRepository.save(attendance2);
        attendanceRepository.save(attendance3);
    }
}

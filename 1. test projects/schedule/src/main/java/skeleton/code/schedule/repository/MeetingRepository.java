package skeleton.code.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skeleton.code.schedule.entity.Meeting;
import skeleton.code.schedule.entity.MeetingSchedule;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}

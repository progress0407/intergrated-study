package skeleton.code.schedule.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MeetingSchedule {

    @Id
    @GeneratedValue
    private Long id;

    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    @JoinColumn(name = "meeting_id")
    @ManyToOne
    private Meeting meeting;
}

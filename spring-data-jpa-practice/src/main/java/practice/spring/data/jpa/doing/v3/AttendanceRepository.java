package practice.spring.data.jpa.doing.v3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
public class AttendanceRepository {

    @PersistenceContext
    private final EntityManager em;

    public AttendanceRepository(final EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Attendance save(final Attendance attendance) {
        em.persist(attendance);
        return attendance;
    }

    public List<Attendance> findByMeetingId(final Long meetingId) {
        return em.createQuery("select a from Attendance a where a.meeting.id = :meetingId", Attendance.class)
                .setParameter("meetingId", meetingId)
                .getResultList();
    }
}

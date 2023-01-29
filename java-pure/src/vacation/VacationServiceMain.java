package vacation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class VacationServiceMain {

    public static void main(String[] args) {

        VacationServiceMain vacationMain = new VacationServiceMain();

        VacationRequests vacationRequests = new VacationRequests(vacationMain.initVacationSampleDays());
        vacationMain.calcVacationDays(vacationRequests);

        /**
         * test something
         */
//        vacationMain.testLocalDateDiff();

    }

    private List<VacationRequest> initVacationSampleDays() {

        List<VacationRequest> vacationsRequests = new ArrayList<>();

        // 휴가 8시간
        vacationsRequests.add(
                new VacationRequest(Vacation.V01,
                        LocalDateTime.of(2021, 10, 6, 0, 0)
                ));

        // 휴가 8시간
        vacationsRequests.add(
                new VacationRequest(Vacation.V01,
                        LocalDateTime.of(2021, 10, 13, 0, 0, 0)
                ));

        // 반차 4시간
        vacationsRequests.add(new VacationRequest(
                Vacation.V02,
                LocalDateTime.of(2021, 10, 19, 9, 0, 0),
                LocalDateTime.of(2021, 10, 19, 14, 0, 0)
        ));

        // 외출 1시간
        vacationsRequests.add(new VacationRequest(
                Vacation.V03,
                LocalDateTime.of(2021, 10, 20, 9, 0, 0),
                LocalDateTime.of(2021, 10, 20, 10, 0, 0)
                ));

        // 조퇴 2시간
        vacationsRequests.add(new VacationRequest(
                    Vacation.V04,
                    LocalDateTime.of(2021, 10, 20, 16, 0, 0),
                    LocalDateTime.of(2021, 10, 20, 18, 0, 0)
                ));

        // 지각 15분
        vacationsRequests.add(new VacationRequest(
                Vacation.V05,
                LocalDateTime.of(2021, 10, 21, 9, 15, 0),
                LocalDateTime.of(2021, 10, 21, 18, 0,0)
                ));

        // 공가 1회
        vacationsRequests.add(new VacationRequest(
                Vacation.V06,
                LocalDateTime.of(2021, 10, 26, 9, 0, 0)
        ));

        // 경조 휴가 1회
        vacationsRequests.add(new VacationRequest(
                Vacation.V07,
                LocalDateTime.of(2021, 10, 28, 9, 0,0))
        );

        return vacationsRequests;
    }

    private void testLocalDateDiff() {
        LocalDateTime end = LocalDateTime.of(2021, 10, 9, 14, 30, 0);
        LocalDateTime start = LocalDateTime.of(2021, 10, 9, 13, 45, 0);

        out.println("(end - start) = " + ((end.getHour() * 60 + end.getMinute()) - (start.getHour() * 60 + start.getMinute())));
    }

    private void calcVacationDays(VacationRequests vacationRequests) {

        double diffDays = vacationRequests.getDiffDays();

        out.println("diffDays = " + diffDays);

        double remainVacationDays = vacationRequests.getVacationRaminDays();

        out.println("remainVacationDays = " + remainVacationDays);
    }


}

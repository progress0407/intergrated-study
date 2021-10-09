package vacation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.lang.System.out;

public class VacationMain {
    public static void main(String[] args) {
        List<VacationRequest> vacationsRequests = new ArrayList<>();

        // 휴가 8시간
        vacationsRequests.add(new VacationRequest(Vacation.V01,
                LocalDateTime.of(2021, 10, 6, 0, 0),
                LocalDateTime.of(2021, 10, 6, 0, 0)
        ));

        // 휴가 8시간
        vacationsRequests.add(new VacationRequest(Vacation.V01,
                LocalDateTime.of(2021, 10, 13, 0, 0, 0),
                LocalDateTime.of(2021, 10, 15, 0, 0, 0)
        ));

        // 반차 4시간
        vacationsRequests.add(new VacationRequest(Vacation.V02,
                LocalDateTime.of(2021, 10, 19, 9, 0, 0),
                LocalDateTime.of(2021, 10, 19, 14, 0, 0)
        ));

        // 외출 1시간
        vacationsRequests.add(new VacationRequest(Vacation.V03,
                LocalDateTime.of(2021, 10, 20, 9, 0, 0),
                LocalDateTime.of(2021, 10, 20, 10, 0, 0)
        ));

        // 조퇴 2시간
        vacationsRequests.add(new VacationRequest(Vacation.V04,
                LocalDateTime.of(2021, 10, 20, 16, 0, 0),
                LocalDateTime.of(2021, 10, 20, 18, 0, 0)
        ));

        // 지각 15분
        vacationsRequests.add(new VacationRequest(Vacation.V05,
                LocalDateTime.of(2021, 10, 21, 9, 15, 0),
                LocalDateTime.of(2021, 10, 21, 18, 0,0))
        );



//        vacationsRequests.stream()
//                .filter(e -> e.vacation.equals(Vacation.V01))
//                .forEach(out::println);
//
//        Function<Integer, Integer> fn = a -> a + 4;
//
//        fn.apply(11);
//
//        out.println("fn.apply(11) = " + fn.apply(11));
//
//        UnaryOperator<Integer> un = a -> a + 4;
//        out.println("un.apply(11) = " + un.apply(11));
//
//        BinaryOperator<Integer> bn = (a, b) -> a + b + 4;
//
//        out.println("bn.apply(3,4) = " + bn.apply(3, 4));


//        double result = vacationsRequests.stream()
//                .filter(e -> e.vacation.equals(Vacation.V01))
//                .map(e -> e.vacation.dateTimeUnit.sec).
//                reduce((a, b) -> a + b)
//                .get() / (3600);

        double result = vacationsRequests.stream()
                .map(request -> request.second())
                .reduce((a, b) -> a + b)
                .get() / (3600);

        out.println("result = " + result);

        LocalDateTime end = LocalDateTime.of(2021, 10, 9, 14, 30, 0);
        LocalDateTime start = LocalDateTime.of(2021, 10, 9, 13, 45, 0);

        out.println("(end - start) = " + ((end.getHour() * 60 + end.getMinute()) - (start.getHour() * 60 + start.getMinute())));


    }
}

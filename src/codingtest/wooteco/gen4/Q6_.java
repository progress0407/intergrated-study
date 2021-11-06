package codingtest.wooteco.gen4;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Q6_ {
    public static void main(String[] args) {
        Solution sol = new Solution();

        double time = 3.5;
        String[][] plans = {{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}};

        sol.solution(time, plans);

    }

    static class Solution {

        private static List<Plan> plans = new ArrayList<>();

        public String solution(double vactaionTimeInput, String[][] plansInput) {

            for (String[] planInput : plansInput) {
                Plan plan = new Plan(planInput);
                plan.calNeedVacationMinute();
                plans.add(plan);
            }

//            plans.forEach(out::println);


            int vacationRemainTime = (int) vactaionTimeInput * 60;
            for (Plan plan : plans) {
                if (plan.needVacationMinute < vacationRemainTime) {
//                    out.println("마지막 여행지 plan = " + plan);
                    return plan.country;
                }
            }

            return "만족하는 마지막 여행지가 존재하지 않습니다";
        }

        enum WORKING_TIME {
            MONDAY(LocalTime.of(13, 00), LocalTime.of(18, 0)),
            FIRDAY(LocalTime.of(9, 30), LocalTime.of(18, 0));

            LocalTime startTime;
            LocalTime endTime;

            WORKING_TIME(LocalTime startTime, LocalTime endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }

        static class Plan {
            String country; // 여행 도착지
            LocalTime startTime; // 출발시각
            LocalTime endTime; // 도착시각
            int needVacationMinute; // 휴가를 가기 위하여 필요한 총 분수

            public void calNeedVacationMinute() {

                int timeDuration1 = 0;
                if (WORKING_TIME.FIRDAY.endTime.isAfter(this.startTime)) {
                    timeDuration1 = (int) Duration.between(this.startTime, WORKING_TIME.FIRDAY.endTime).getSeconds() / 60;
                }

                int timeDuration2 = 0;
                if (WORKING_TIME.MONDAY.startTime.isBefore(this.endTime)) {
                    timeDuration2 = (int) Duration.between(WORKING_TIME.MONDAY.startTime, this.endTime).getSeconds() / 60;
                }

                this.needVacationMinute = timeDuration1 + timeDuration2;
            }

            public Plan(String[] plan) {
                this.country = plan[0];
                this.startTime = convert(plan[1]);
                this.endTime = convert(plan[2]);
                ;
            }

            private LocalTime convert(String str) {
                int hour = 0;
                if (str.contains("PM")) {
                    hour = Integer.parseInt(str.split("PM")[0]) + 12;
                } else {
                    hour = Integer.parseInt(str.split("AM")[0]);
                }

                LocalTime time = LocalTime.of(hour, 0);
                return time;
            }

            @Override
            public String toString() {
                return "Plan{" +
                        "country='" + country + '\'' +
                        ", startTime=" + startTime +
                        ", endTime=" + endTime +
                        ", needVacationMinute=" + needVacationMinute +
                        '}';
            }
        }
    }
}

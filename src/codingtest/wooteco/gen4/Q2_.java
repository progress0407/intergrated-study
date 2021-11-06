package codingtest.wooteco.gen4;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Q2_ {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
//        String[] log = {"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};

        sol.solution(log);

    }

    static class Solution {
        public String solution(String[] logs) {

            boolean isOdd = true;
            Study study = null;
            List<Study> studies = new LinkedList<>();
            for (String log : logs) {

                if (isOdd) {
                    study = new Study(log);
                } else {
                    study.setEndTime(log);
                    studies.add(study);
                }
                isOdd = !isOdd;
            }

            /*studies.stream()
                    .map(e -> Duration.between(e.startTime, e.endTime).getSeconds() / 60)
                    .mapToInt(Integer::parseInt)
                    .filter(e -> e >= 5)
                    .map(e -> {
                        if (e >= 105) return 105;
                        return Integer.parseInt(e);
                    })*/

            int result = 0;
            for (Study std : studies) {
                int min = (int) Duration.between(std.startTime, std.endTime).getSeconds() / 60;
                if(min <5) continue;
                if(min >= 105) result += 105;
                else result += min;
            }

            String hour = String.valueOf(result / 60);
            String min = String.valueOf(result % 60);

            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            if (min.length() == 1) {
                min = "0" + min;
            }

            String answer = hour + ":" + min;

            return answer;
        }

        static class Study {
            LocalTime startTime;
            LocalTime endTime;

            public LocalTime convert(String log) {
                String[] split = log.split(":");
                int hour = Integer.parseInt(split[0]);
                int minute = Integer.parseInt(split[1]);

                return LocalTime.of(hour, minute);
            }

            public Study(String log) {
                this.startTime = convert(log);
            }

            public void setEndTime(String log) {
                this.endTime = convert(log);
            }

            @Override
            public String toString() {
                return "Study{" +
                        "startTime=" + startTime +
                        ", endTime=" + endTime +
                        '}';
            }
        }
    }
}

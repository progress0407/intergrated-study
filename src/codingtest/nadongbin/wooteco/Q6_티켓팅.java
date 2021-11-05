package codingtest.nadongbin.wooteco;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Q6_티켓팅 {
    public static void main(String[] args) {
        String[] logs = {
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };

        int totalTicket = 2000;

        Solution sol = new Solution();
//        sol.solution(totalTicket, logs);

        LocalTime p1 = LocalTime.of(2, 2, 59);
        LocalTime p2 = LocalTime.of(2, 1, 49);

        Duration d = Duration.between(p2, p1);
        out.println("d.getSeconds() = " + d.getSeconds());


    }

    static class Solution {

        public String[] solution(int totalTicket, String[] logs) {

            List<TicketRequest> list = new ArrayList<>();

            for (String log : logs) {
                String[] split = log.split(" ");

                String name = split[0];
                String status = split[1];
                String time = split[2];

                int[] timeArr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
                int hour = timeArr[0];
                int minute = timeArr[1];
                int second = timeArr[2];

                TicketRequest find = list.stream().filter(e -> e.name.equals(name)).findAny().orElseGet(() -> null);

                TicketRequest ticketRequest;

                if (find == null)
                    ticketRequest = new TicketRequest(name, status);
                else
                    ticketRequest = find;

                if (status.equals("request"))
                    ticketRequest.setStartTime(hour, minute, second);

                else if (status.equals("leave"))
                    ticketRequest.setEndTime(hour, minute, second);

                if (find == null) list.add(ticketRequest);

            }

//            Collections.sort(list, (a, b) -> a.time.compareTo(b.time);
//            Collections.sort(list, (a, b) -> b.time.compareTo(a.time);
            Collections.sort(list, Comparator.comparing(a -> a.startTime));

            Queue<TicketRequest> q = new LinkedList<>();

            List<String> result = new ArrayList<>();

            for (TicketRequest ticket : list) {
                if (q.isEmpty()) {
                    q.offer(ticket);
                    continue;
                }
                TicketRequest last = q.poll();
                if (last.endTime != null) {
                    Duration diff = Duration.between(ticket.startTime, last.endTime);
                    if (diff.getSeconds() >= 0) {
                        q.poll();
                        q.offer(ticket);
                    } else {

                    }
                } else { // endTime 이 없음
                    Duration diff = Duration.between(ticket.startTime, last.startTime.plusMinutes(1));
                    if (diff.getSeconds() >= 0) {
                        result.add(last.name);
                        q.poll();
                        q.offer(ticket);
                    }
                }
            }

            list.forEach(out::println);

            return null;
        }

        static class TicketRequest {
            String name;
            String status;
            LocalTime startTime;
            LocalTime endTime;

            public TicketRequest(String name, String status) {
                this.name = name;
                this.status = status;
            }

            public void setStartTime(int hour, int minute, int second) {
                this.startTime = LocalTime.of(hour, minute, second);
            }

            public void setEndTime(int hour, int minute, int second) {
                this.endTime = LocalTime.of(hour, minute, second);
            }

            @Override
            public String toString() {
                return "TicketRequest{" +
                        "name='" + name + '\'' +
                        ", status='" + status + '\'' +
                        ", startTime=" + startTime +
                        ", endTime=" + endTime +
                        '}';
            }
        }
    }
}

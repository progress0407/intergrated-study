package codingtest.programmers.stackqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Prg_기능개발_복습 {
    public static void main(String[] args) {

        Solution sol = new Solution();

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};


        sol.solution(progresses, speeds);

    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Work> q = new LinkedList<>();
            Queue<Rel> rels = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                q.offer(new Work(progresses[i], speeds[i]));
            }

            int day = 0;
            while (!q.isEmpty()) {
                day++;
                q.forEach(Work::working); // 일시킨다
//                List<Work> completeWorks = q.stream().filter(Work::isCompleted).collect(Collectors.toList());
                // Collections.emptyList()

                int cnt = 0;
                if (!q.isEmpty()) {
                    while (!q.isEmpty() && q.peek().isCompleted()) {
                        q.poll();
                        cnt++;
                    }
                    out.printf("배포 cnt = %d, %d \n", cnt, day);
                    if (cnt != 0) rels.offer(new Rel(cnt, day));
                }
            }

            out.println("======================");
            rels.forEach(out::println);

            int[] ints = rels.stream().mapToInt(e -> e.cnt).toArray();

            return ints;
        }

        static class Rel {
            int cnt; // 배포갯수
            int day; // 배포일

            public Rel(int cnt, int day) {
                this.cnt = cnt;
                this.day = day;
            }

            @Override
            public String toString() {
                return "Rel{" +
                        "cnt=" + cnt +
                        ", day=" + day +
                        '}';
            }
        }

        static class Work {
            int progress;
            int speed;

            public Work(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }

            public void working() {
                if (progress + speed >= 100) {
                    progress = 100;
                    return;
                }
                out.println("# working: " + this);
                progress += speed;
            }

            public boolean isCompleted() {
                return progress == 100;
            }

            @Override
            public String toString() {
                return "Work{" +
                        "progress=" + progress +
                        ", speed=" + speed +
                        '}';
            }
        }

    }
}

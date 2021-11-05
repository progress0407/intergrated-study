package codingtest.programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class Prg_프린터_복습 {

    public static void main(String[] args) {

        Solution sol = new Solution();

//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int myPosition = sol.solution(priorities, location);

        out.println("myPosition = " + myPosition);

    }

    static class Solution {
        public int solution(int[] priorities, int location) {

            Queue<Priority> q = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {

                Priority priority;
                if (i == location) {
                    priority = new Priority(priorities[i], true);
                } else {
                    priority = new Priority(priorities[i], false);
                }
                q.offer(priority);
            }

            Queue<Priority> results = new LinkedList<>();

            while (!q.isEmpty()) {
                Priority first = q.poll();

                Priority hasLarger = q.stream().filter(e -> first.priority < e.priority).findAny().orElseGet(() -> null);

                if (hasLarger != null) {
                    q.offer(first);
                    out.println("# 더 큰 원소가 존재하므로 맨 뒤에 추가" + first);
                    continue;
                }
                results.offer(first);
                out.println("# 현재 원소가 가장 크므로 출력 " + first);
            }

            int cnt = 0;
            for (Priority result : results) {
                cnt++;
                if (result.isMine) return cnt;
            }

            return -1;
        }

        static class Priority {
            int priority;
            boolean isMine;

            public Priority(int priority, boolean isMine) {
                this.priority = priority;
                this.isMine = isMine;
            }

            @Override
            public String toString() {
                return "Priority{" +
                        "priority=" + priority +
                        ", isMine=" + isMine +
                        '}';
            }
        }

    }
}

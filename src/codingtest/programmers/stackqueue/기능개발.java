package codingtest.programmers.stackqueue;

import java.util.*;

import static java.lang.System.out;

public class 기능개발 {
    public static void main(String[] args) {

//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Solution sol = new Solution();
        sol.solution(progresses, speeds);
    }
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
//            int[] answer = {};

            ArrayList<Integer> answer = new ArrayList<>();

            LinkedList<FunctionDeveloping> workQueue = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                workQueue.offer(new FunctionDeveloping(progresses[i], speeds[i]));
            }

            workQueue.forEach(out::println);
            out.println("workQueue = " + workQueue);
            workQueue.clear();

            while (!workQueue.isEmpty()) {
                for (int i = 0; i < workQueue.size(); i++) {
                    workQueue.get(i).work(); // 일 진행
                }

                // 첫번째 큐의 원소만 확인
                int progress = workQueue.get(0).progress;
                int cnt = 0;
                while (progress == 100) {
                    out.printf("기능이 완성되었습니다 : %d \n", progress);
                    workQueue.poll();
                    cnt++;
                    if (workQueue.isEmpty()) break;
                    progress = workQueue.get(0).progress;
                }
                if (cnt != 0) answer.add(cnt);
            }



            int[] answer2 = answer.stream().mapToInt(e -> e).toArray();
            out.println("Arrays.toString(answer2) = " + Arrays.toString(answer2));
            return answer2;
        }
    }

    static class FunctionDeveloping {
        int progress;
        int speed;

        public FunctionDeveloping(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        void work() {
            progress += speed;
            if (progress >= 100) {
                progress = 100;
            }
        }

        @Override
        public String toString() {
            return "FunctionDeveloping{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    '}';
        }
    }

}

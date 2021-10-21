package codingtest.nadongbin.stackqueue;

import java.util.LinkedList;

import static java.lang.System.out;

public class Prg_다리를_지나는_트럭 {
    public static void main(String[] args) {
        out.println("Prg_다리를_지나는_트럭.main");

        Solution sol = new Solution();
        sol.solution(2, 10, new int[]{7, 4, 5, 6});
//        sol.solution(100, 100, new int[]{10});
//        sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            // 대기 큐
            LinkedList<Integer> idleQueue = new LinkedList<>();

            for (int truckWeight : truck_weights) {
                idleQueue.offer(truckWeight);
            }

            LinkedList<Integer[]> bridgeQueue = new LinkedList<>();

            do {
                answer++;
                // 다리 위 트럭의 총 무게
                int weightOnBridge = (int) bridgeQueue.stream()
                        .map(e -> e[0])
                        .reduce((a, b) -> a + b)
                        .orElse(0);

                // 다리 위 트럭의 총 댓수
                int countOnBridge = (int) bridgeQueue.stream().count();

                Integer truck = idleQueue.peek();

                if (truck != null // 트럭이 있을 경우에만 실행
                        && weightOnBridge + truck <= weight  // 다리가 견딜수 있는 무게보다 낮고
                        && countOnBridge <= bridge_length  // 다리의 길이 이하
                ) {
                    bridgeQueue.offer(new Integer[]{truck, bridge_length}); // 다리위에 트럭, 대기시간(다리길이) 추가
                    idleQueue.poll(); // 대기큐에 트럭 제외
                    out.printf("## 트럭이 다리 위로 올라옴 : %s \n", truck);
                }

                for (Integer[] truckOnBridge : bridgeQueue) { // 모든 트럭이 다리를 지나감
                    truckOnBridge[1]--;
                }

                Integer loadRemain = bridgeQueue.getFirst()[1]; // 얼마나 남아있는지
                if (loadRemain.equals(0)) { // 가장 첫번째로 들어온 트럭 다리위를 지나는 것 감지
                    out.printf("## 트럭 %s 가 탈출함 \n", bridgeQueue.poll());
                }
                
            } while (!idleQueue.isEmpty() || !bridgeQueue.isEmpty());

            out.println("## answer = " + (answer + 1));

            return answer + 1;
        }
    }
}

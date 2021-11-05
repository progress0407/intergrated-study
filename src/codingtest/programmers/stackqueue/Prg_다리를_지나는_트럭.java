package codingtest.programmers.stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.out;

public class Prg_다리를_지나는_트럭 {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.solution(2, 10, new int[]{7, 4, 5, 6});
//        sol.solution(100, 100, new int[]{10});
//        sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});

//        sol.solution2(2, 10, new int[]{7, 4, 5, 6});
//        sol.solution2(100, 100, new int[]{10});
        sol.solution2(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }

    /**
     * 다리를 지나는 트럭.. 객체 지향적으로 다시 구성해 보자
     */
    static class Solution {

        public int solution2(int bridge_length, int weight, int[] truck_weights) {

            Queue<Truck> remainTrucks = new LinkedList<>();
            for (int i = 0; i < truck_weights.length; i++) {
                remainTrucks.add(new Truck(truck_weights[i], bridge_length));
            }

            Queue<Truck> bridgeOnTrucks = new LinkedList<>();
            Queue<Truck> outOfBridge = new LinkedList<>();

            int timeElapsed = 0;
            while (!(remainTrucks.isEmpty() && bridgeOnTrucks.isEmpty())) {

                timeElapsed++;

                if (bridgeOnTrucks.isEmpty()) { // 트럭이 비었을 경우
                    Truck truck = remainTrucks.poll();
                    bridgeOnTrucks.offer(truck);
                    out.println("## (다리비었음)트럭이 위로 올라옴" + truck);

                } else { // 다리위에 트럭이 존재함

                    bridgeOnTrucks.stream().forEach(Truck::move); // 이동

                    if (bridgeOnTrucks.peek().remain == 0) { // 가장 임박한 트럭을 조사
                        // 탈출 시간이 되면 탈출한다
                        Truck poll = bridgeOnTrucks.poll();
                        out.println("## 트럭 탈출 = " + poll);
                    }

                    int sum = bridgeOnTrucks.stream().mapToInt(e -> e.weight).sum();

                    if (!remainTrucks.isEmpty() && sum + remainTrucks.peek().weight <= weight) {
                        Truck truck = remainTrucks.poll();
                        bridgeOnTrucks.offer(truck);
                        out.println("## 트럭이 위로 올라옴" + truck);
                    }
                }
            }

            out.println("timeElapsed = " + timeElapsed);

            return timeElapsed;
        }
        
        static class Truck {
            int weight;
            int remain;

            public Truck(int weight, int remain) {
                this.weight = weight;
                this.remain = remain;
            }

            public void move() {
                remain--;
                out.println("move = " + this);
            }

            @Override
            public String toString() {
                return "Truck{" +
                        "weight=" + weight +
                        ", remain=" + remain +
                        '}';
            }

        }

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
                    truckOnBridge[1]--; // 대기시간 감소
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

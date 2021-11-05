package codingtest.dongbinna.lec2greedy;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;


public class Q4_모험가_길드 {
    public static void main(String[] args)
    {
//        풀이1_실패(); // 1차원 List
        풀이2(); // 2차원 Map + List
    }
    private static void 풀이2() {
        int N = 5;
        List<Map<String, Integer>> fearList = new ArrayList<>();
        fearList.add(getNewMap(2, 1));
        fearList.add(getNewMap(3, 1));
        fearList.add(getNewMap(1, 1));
        fearList.add(getNewMap(2, 1));
        fearList.add(getNewMap(2, 1));

        Collections.sort(fearList, (o1, o2) -> o1.get("fear").compareTo(o2.get("fear")));

        fearList.forEach(out::println);

        int groupCnt = 0;
        int leaveCnt = 0;
        for (Map<String, Integer> fear : fearList) {

            long existCnt = fearList.stream().filter(e -> e.get("exist").equals(1)).count();

            if (leaveCnt > 0) {
                fear.replace("exist", 0); // 그룹원 만큼 마을을 떠남
                leaveCnt--;
                continue;
            }

            if (fear.get("exist").equals(1)) { // 마을에 존재하는 모험가일 경우
                if (existCnt >= fear.get("fear")) { // 남아있는 잔류인원이 공포도보다 높다면
                    fear.replace("exist", 0); // 한명은 그룹원
                    leaveCnt = fear.get("fear") - 1; // 마을 떠날 인원
                    groupCnt++; // 그룹이 결성되는 시점 !
                }
            }
        }

        out.println("groupCnt = " + groupCnt);

    }

    /**
     * @param fear  공포도
     * @param exist  인원이 마을에 존재 유무
     * @return Map
     */
    private static Map<String, Integer> getNewMap(int fear, int exist) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("fear", fear);
        map.put("exist", exist);
        return map;
    }

    private static void 풀이1_실패() {
        int N = 5;
        List<Integer> fearList = new ArrayList<>(List.of(2, 3, 1, 2, 2));

        // 정렬
        fearList = fearList.stream().sorted().collect(Collectors.toList());

        int cnt = 0; // 그룹 결성 갯수
//        for (Integer fear : fearList) { // ConcurrentModificationException
//            if (fearList.size() >= fear.intValue()) {
//                for (int i = 0; i < fear; i++) {
//                    fearList.remove(0);
//                }
//                cnt++;
//            }
//        }

        for (Iterator<Integer> iterator = fearList.iterator(); iterator.hasNext(); ) {
            Integer fear = iterator.next();
            if (fearList.size() >= fear) {
                fearList.remove(0);
            }
        }
    }
}


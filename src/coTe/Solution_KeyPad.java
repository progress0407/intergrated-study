package coTe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Solution_KeyPad {
    public static void main(String[] args) {
        Solution_KeyPad2 sol = new Solution_KeyPad2();
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        sol.solution(numbers, hand);
    }
}

class Solution_KeyPad2 {
    public String solution(int[] numbers, String whatHand) {
        String answer = "";
        KeyPad.init(whatHand);
        for(int e : numbers) {
            KeyPad.touch(e);
        }
        answer = KeyPad.getResultString();
        out.println(answer);
        return answer;
    }
}

class KeyPad {
    static Map<String, Map<String, Integer>> lastPos = new HashMap<>();
    final static int map[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1, 0, -1}
    };

    final static List<Integer> Lside = Stream.of(map).map(e->(int)e[0]).limit(3).collect(Collectors.toList());
    final static List<Integer> Rside = Stream.of(map).map(e->(int)e[2]).limit(3).collect(Collectors.toList());
    final static List<Integer> CenterSide = Stream.of(map).map(e->(int)e[1]).limit(4).collect(Collectors.toList());

    static Map<String, Integer> tempMap = new HashMap<>();
    static String resultList = "";
    static String hand = "";

    public static void init(String whatHand) {

        tempMap.put("col", 0);
        tempMap.put("row", 3);
        lastPos.put("L", tempMap);

        tempMap = new HashMap<>();

        tempMap.put("col", 2);
        tempMap.put("row", 3);
        lastPos.put("R", tempMap);
        hand = whatHand.equals("left")? "L" : "R";

    }

    public static void touch(int num) {

        if (isMatch(Lside, num)) {
            doMemory("L", num);
        }
        else if (isMatch(Rside, num)) {
            doMemory("R", num);
        }
        else { // CenterSide
            if (whoNearMoreSide(num).equals("L")) {
                doMemory("L", num);
            }
            else if (whoNearMoreSide(num).equals("R")) {
                doMemory("R", num);
            }
            else { // 거리가 같아?
                doMemory(hand, num);
            }
        }
    }

    private static boolean isMatch(List<Integer> side, int num) {
        return side.stream().anyMatch(e->e==num);
    }

    private static String whoNearMoreSide(int num) {

        Map<String, Integer> coordMap = getCoord(num);
        int row = coordMap.get("row");
        int col = coordMap.get("col");

        int dist_L =
                Math.abs(row - lastPos.get("L").get("row")) + Math.abs(col - lastPos.get("L").get("col"));

        int dist_R =
                Math.abs(row - lastPos.get("R").get("row")) + Math.abs(col - lastPos.get("R").get("col"));

        return dist_L < dist_R ? "L" : dist_L == dist_R? "same" : "R";
    }

    // doMemory 안에 숫자를 넣어라
    private static void doMemory(String hand_input, int num) {
        resultList += hand_input;
        lastPos.put(hand_input, getCoord(num));
    }

    public static Map<String, Integer> getCoord(int keyNum) {
        Map<String, Integer> t_map = new HashMap<>();
        int row= 0, col =0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == keyNum) {
                    t_map.put("row", row);
                    t_map.put("col", col);
                    return t_map;
                }
            }
        }
        return null;
    }

    public static String getResultString() {
        return resultList;
    }
}

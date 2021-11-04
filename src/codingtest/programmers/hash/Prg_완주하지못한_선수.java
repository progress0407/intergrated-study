package codingtest.programmers.hash;

import test.grammer.enumtest.EnumTest;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

import static java.lang.System.out;

public class Prg_완주하지못한_선수 {

    public static void main(String[] args) {

        Solution sol = new Solution();

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};

//        sol.solution2(participant, completion);

        sol.solution3(participant, completion);

    }

    static class Solution {

        public String solution3(String[] participants, String[] completions) {

            HashMap<String, Integer> map = new HashMap<>();

            for (String participant : participants) {
                Integer num = map.getOrDefault(participant, 0);
                map.put(participant, num + 1);
            }

            for (String completion : completions) {
                Integer num = map.get(completion);
                map.put(completion, num - 1);
            }

            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    out.println("key = " + key);
                    return key;
                }
            }
            return null;
        }

        public String solution2(String[] participants, String[] completions) {

            HashMap<String, Integer> map = new HashMap<>();

            for (String participant : participants) {
                Integer num = map.get(participant);
                if (num != null) {
                    map.replace(participant, ++num);
                    continue;
                }
                map.put(participant, 1);
            }

            for (String completion : completions) {
                Integer num = map.get(completion);
                map.replace(completion, --num);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    return entry.getKey();
                }
            }
            return null;
        }
        
        // 풀이는 깔끔했으나.. 효율성 실패
        public String solution(String[] p, String[] completions) {

            List<String> participants = new ArrayList<>(List.of(p));

            for (String completion : completions) {
                participants.remove(completion);
            }

            return participants.get(0);
        }
    }
}

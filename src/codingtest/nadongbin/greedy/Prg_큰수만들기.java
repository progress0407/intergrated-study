package codingtest.nadongbin.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

public class Prg_큰수만들기 {

    public static void main(String[] args) {

//        char[] chars = str.toCharArray();
//
//        List<Integer> list = new LinkedList<>();
//
//        for (char aChar : chars) {
//            list.add(Integer.valueOf(String.valueOf(aChar)));
//        }

//        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
//        List<Integer> minimum = sortedList.stream().limit(2).collect(Collectors.toList());

        // a b c
        // a < b일경우... a를 지운다


        Solution solution = new Solution();



        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100_000; i++) {
            int n = ThreadLocalRandom.current().nextInt(10_000, 100_000);
            sb.append(n);
        }

        String strNumber = sb.toString();
        int k = ThreadLocalRandom.current().nextInt(1, strNumber.length());

        out.println("strNumber = " + strNumber);
        out.println("length = " + strNumber.length());
        out.println("k = " + k);

//        solution.solution(strNumber, k);
//        solution.solution("1924", 2);
        solution.solution("1231234", 3);
//        solution.solution("4177252841", 4); // expected :  775841


    }

    static class Solution {

        public String solution(String number, int k) {


            String str = number;
            int cnt = k;

            char[] chars = str.toCharArray();
            List<Integer> list = new LinkedList<>();

            for (char aChar : chars) {
                list.add(Integer.valueOf(String.valueOf(aChar)));
            }

            long t2 = System.currentTimeMillis();

            // 마지막까지 가면 out of range
//            for (int i = 0; i < list.size() - 1; i++) {
//                if (list.get(i) < list.get(i + 1)) {
//                    list.remove(((Integer) list.get(i)));
//                    cnt--;
//                    i--;
//                    if (cnt == 0) {
//                        break;
//                    }
//                }
//            }

            LinkedList<Integer> nextList = new LinkedList<>();

            while (cnt > 0) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) < list.get(i + 1)) {
                        Integer smallRemoved = list.remove(i);
                        Integer largeRemoved = list.remove(i + 1);

                        cnt--;

                        if (!nextList.isEmpty()) {
                            if (nextList.getLast() < largeRemoved) {
                                nextList.add(largeRemoved);
                            }
                        }


                        break;
//                        if(cnt == 0) break;
                    }
                }
            }

//            removeList.forEach(e->{
//                list.remove((int) e); // 값으로 비교
//                list.remove(e); // 위치로 비교
//            });

            long t3 = System.currentTimeMillis();
            out.println("(t3-t2) = " + (t3 - t2));

            StringBuilder sb = new StringBuilder();

            for (Integer e : list) {
                sb.append(e);
            }

            String answer = sb.toString();
            out.println("answer = " + answer);


            return answer;
        }

    }
}

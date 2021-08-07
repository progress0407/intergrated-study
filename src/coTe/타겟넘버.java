/*
package coTe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class 타겟넘버 {
    public static void main(String[] args) {
        Solution_타겟넘버 sol = new Solution_타겟넘버();
//        int[] numbers = {3,5};
//        int target = -2;

//        int[] numbers = {1,1,1,1,1};
//        int target = 3;

//        int[] numbers = {1,1,1,1,1,1};
//        int target = 2;

        */
/*int[] numbers = {1,2,3,4,5};
        int target = 5;*//*


        */
/*int[] numbers = {10,10,10,10,10};
        int target = 30;*//*


        int[] numbers = {
                10,10,10,10,10,
                10,10,10,10,10,
                10,10,10,10,10,
                10,10,10,10,10
        };
        int target = 180;

        int wayToMakeTarget = sol.solution(numbers, target);
        out.println("wayToMakeTarget: "+wayToMakeTarget);
    }
}

class Solution_타겟넘버 {
    public int solution(int[] numbers, int target) {
        int wayToMakeTarget = 0; // target을 만드는 방법의 갯수
        List<List<Integer>> binList = makeBinList(numbers);

        for(int i=0; i< binList.size(); i++) {
            List<Integer> binListOne = binList.get(i); // [0,1]
            int result = 0;
            for(int j=0; j< binList.get(0).size(); j++) {
                if(binListOne.get(j) == 0) { // 0이라면 +
                    result += numbers[j];
                } else {
                    result -= numbers[j];
                }
            }
            if(result == target) {
                wayToMakeTarget++;
            }
        }

        // 람다 안에서는 지역변수를 사용하지 못한다 !
        */
/*
        binList.stream().forEach(elements->{ // e : element
            int result = 0;
            IntStream.range(0, elements.size()).forEach(i->{
                int element = elements.get(i);
                if(elements.get(i) == 0) {
                    result += element;
                } else {

                }
            });
        });
         *//*


        return wayToMakeTarget;
    }

    private List<List<Integer>> makeBinList(int[] numbers) {
        int numbersCnt = numbers.length;
        int arrSize = 1<<numbersCnt;
        List<List<Integer>> binList = new ArrayList<>();
        for(int i=0; i<arrSize; i++) {

//            if(i==1023)
//                out.println("this is 1023");
            String step1 = Integer.toBinaryString(i); // 1 -> 1, 3 -> 11
//            long step2 = Long.parseLong(step1); // str -> int, 100 0000 0000 를 못받아 ! max 21 ~ ~
//            String step3 = String.format("%0" +numbersCnt+ "s", step1); // 1 -> 01
//            그렇다고 BigInteger는 api가 다양하지 않아.. ㅠ

            int zeroCnt = numbersCnt-step1.length();
            for(int j=0; j< zeroCnt; j++) {  // 앞에 0 붙이기
                step1 = "0"+step1;
            }

            char[] step4 = step1.toCharArray(); // 01 -> {0, 1}

            List<Integer> tempBinOne = new ArrayList<>();
            for (char e : step4) {
                tempBinOne.add(Integer.parseInt(String.valueOf(e)));
            }
            binList.add(tempBinOne);
        }

        */
/*
            [0, 0]
            [0, 1]
            [1, 0]
            [1, 1]
        *//*


        return binList;
    }
}
*/

// String에서 빼올 때.
// bit.charAt() 이렇게 하면 되겠네
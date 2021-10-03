package codingtest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class 소수찾기 {
    public static void main(String[] args) {
        String test;
        test = "17";
        test = "1234";
        
        Solution_소수찾기 sol = new Solution_소수찾기();
        sol.solution(test);
    }
}

class Solution_소수찾기 {
    public int solution(String numbers) {
        int answer = 0;

        List<Integer> numbersList = 정수리스트만들기(numbers);
        List<List<Integer>> 부분집합리스트 = 솎아내기(numbersList);

        out.println("메인에서 출력");

//        부분집합리스트.forEach(out::println);

        for(int i=0; i< 부분집합리스트.size(); i++) {
            재배열하기(부분집합리스트.get(i));
        }


        return answer;
    }

    private List<Integer> 정수리스트만들기(String numbers) {
        List<Integer> 정수리스트 = new ArrayList<>();
        for(char e : numbers.toCharArray()) {
            정수리스트.add(Integer.parseInt(String.valueOf(e)));
        }
        정수리스트.forEach(out::println);
        return 정수리스트;
    }

    private List<List<Integer>> 재배열하기(List<Integer> numbersList) {
        재배열_재귀(numbersList, new ArrayList<>());
        return null;
    }

    private void 재배열_재귀(List<Integer> numbersList, List<Integer> includeList) {

        int size = numbersList.size();

        for(int i=0; i< size; i++) {
            if(includeList.size() == numbersList.size()) {
                includeList.forEach(out::println);
                return;
            }

            if(includeList.size() > 0) {
                for(int j=0; j<includeList.size(); j++) {
                    if(numbersList.get(i) != includeList.get(j)) {
                        includeList.add(numbersList.get(i));
                        재배열_재귀(numbersList, includeList);
                    }
                }
            }
            else {
                includeList.add(numbersList.get(i));
                재배열_재귀(numbersList, includeList);
            }
        }
    }

    private List<List<Integer>> 솎아내기(List<Integer> numbersList) {
        List<List<Integer>> bitList = 비트리스트(numbersList.size());
        List<List<Integer>> 솎아낸_리스트 = new ArrayList<>();
        bitList.forEach(e->{
            e.forEach(out::print);
            out.println();
        });
        for(int i=0; i<bitList.size(); i++) {
            List<Integer> tempList = new ArrayList<>();
            for(int j=0; j< bitList.get(0).size(); j++) {
                if(bitList.get(i).get(j) == 1) {
                    tempList.add(numbersList.get(j));
                }
            }
            솎아낸_리스트.add(tempList);
        }

        솎아낸_리스트.forEach(e->{
            e.forEach(out::print);
            out.println();
        });
        return 솎아낸_리스트;
    }

    /*
    List<Integer>[] 솎아낸리스트;
    int 솎_i;
    private List<List<Integer>> 솎아내기(List<Integer> numbersList) {

        솎아낸리스트 = new ArrayList[numbersList.size() + 1];


        재귀_솎아내기(numbersList, 0, true);
        재귀_솎아내기(numbersList, 0, false);

        return 솎아낸리스트;
    }

    private void 재귀_솎아내기(List<Integer> numberList, int index, boolean getNum) {

        if(index == MAX)
            return;

        if(getNum) { // 뽑겟다
            numberList.get(index);
        } else { // 안뽑겟다.
            솎_i++;
        }

        재귀_솎아내기(numberList, index + 1, true);
        재귀_솎아내기(numberList, index + 1, false);
    }
    */

    private List<List<Integer>> 비트리스트(int 길이) {

        List<List<Integer>> binList = new ArrayList<>();

        for (int i = 0; i < 1 << 길이; i++) {
            String step1 = Integer.toBinaryString(i);
            int zeroCnt = 길이-step1.length();
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
        return binList;
    }
}
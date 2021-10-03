package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class 후보키 {
    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };
        Solution_후보키 sol = new Solution_후보키();
//        solution_후보키.solution(relation);
        sol.do_bitOp();
    }
}

class Solution_후보키 {
    // stream안에서 인덱스를 억지로 만들기 위함
    static List<Integer> toDelete = new ArrayList<>();
    public int solution(String[][] relation_input) {
        // 전치행렬 만들기
        String[][] relation_transposed = do_transpose(relation_input);

        // 이렇게 하면 index로 remove못지워
//        List<String[]> relationList = Arrays.asList(relation_transposed.clone());
        List<String[]> relationList = new ArrayList<>();
        relationList.addAll(Arrays.asList(relation_transposed));

        int cnt = CalcCandidate(relationList);
        out.println("cnt: "+cnt);
        return cnt;
    }

    public static void do_bitOp() {
        final int len = 8;
        int N = 1<<len;
        List<String> strList = new ArrayList<>();
        for(int i=0; i< N; i++) {
            strList.add(Integer.toBinaryString(i));
        }
        strList =
                strList
                .stream()
                .filter(e->e!="00000000")
                .map(e->{
                    while(e.length() < len) {
                        e = "0"+e;
                    }
                    return e;
                })
                .collect(Collectors.toList());

        strList.forEach(out::println);

        List<List<Integer>> subSetList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        strList.stream().forEach(e->{
            int weight = len;
//            tempList = new ArrayList<>();
            for(char c : e.toCharArray()) {
                if(c == '1') {
                    tempList.add(weight);
                }
                weight--;
            }
            subSetList.add(tempList);
        });
        subSetList.stream().forEach(e->{
            out.print("[");
            e.stream().forEach(e2->{
                out.printf("%2d", e2);
            });
            out.printf("] \n\n");
        });
    }

    static int SIZE; // 컬럼의 사이즈
    static List<String[]> st_relationList = new ArrayList<>();
    static int relLen;

    static String[][] do_transpose(String[][] relation_input) {
        String[][] relation_transposed = new String[relation_input[0].length][relation_input.length];
        for (int i = 0; i < relation_input.length; i++) {
            for (int j = 0; j < relation_input[0].length; j++) {
                relation_transposed[j][i] = relation_input[i][j];
            }
        }
        return relation_transposed;
    }

    private int CalcCandidate(List<String[]> relationList) {
        st_relationList = relationList;
        SIZE = st_relationList.size();
        relLen = st_relationList.get(0).length;
        out.println("SIZE: "+SIZE);
        return iterDo(SIZE);
    }

    static int START_NO = 0;
    static int CANDIDATE_CNT = 0;
    static List<Integer> toDeleteList = new ArrayList<>();
    static AtomicInteger indexAtomic = new AtomicInteger();
    static List<String> newStrList = new ArrayList<>();

    public int iterDo(int lastIndex) {
        toDeleteList = new ArrayList<>();
        out.println("START_NO : " + START_NO);
        out.println("size: "+SIZE);
        for(int i= START_NO; i< SIZE - START_NO; i++) {

            for(int k= 0; k< relLen; k++) {
                String newStr = "";
                newStr += st_relationList.get(i)[k];
                newStrList.add(newStr);
            }

            boolean uniqueness = newStrList.stream().distinct().count() == relLen;
            if(uniqueness) {
                CANDIDATE_CNT++;
                toDeleteList.add(indexAtomic.getAndIncrement());
            }
        }

        toDeleteList.stream().forEach(index -> {
            out.println("index : " + index);
            // obj이기에 제거가 안됏던 것이다.
            st_relationList.remove((int)index);
        });

        SIZE = st_relationList.size();
        START_NO++;
        if(SIZE > 0) {
            for(int i= START_NO; i< SIZE - START_NO; i++) {
                iterDo(i);
            }
        }
        return CANDIDATE_CNT;
    }
}
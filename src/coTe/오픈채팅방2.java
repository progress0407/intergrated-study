package coTe;

import static java.lang.System.out;

import java.util.Arrays;

class Solution {
    static int st_i;

    public String[] solution(String[] 활동_내역들) {
        String[] 최종_활동_내역 = null;

        Arrays.stream(최종_활동_내역).filter(e->e==e);

        return 최종_활동_내역;
    }

}


//아이디에 대한 이름 정보
class 아이디_이름 {
    String 아이디;
    String 이름;

    public 아이디_이름(String 아이디, String 이름) {
        this.아이디 = 아이디;
        this.이름 = 이름;
    }

    public String get아이디() {
        return 아이디;
    }

    public String get이름() {
        return 이름;
    }

    @Override
    public String toString() {
        return "아이디_이름 [아이디=" + 아이디 + ", 이름=" + 이름 + "]";
    }
}

public class 오픈채팅방2 {

    public static void main(String[] args) {
        String[] 이력들 = { "Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
        Solution sol = new Solution();
//        sol.solution(이력들);
    } // 메인

} // 클래스
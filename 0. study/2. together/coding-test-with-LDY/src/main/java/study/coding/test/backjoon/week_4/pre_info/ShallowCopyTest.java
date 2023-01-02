package study.coding.test.backjoon.week_4.pre_info;

public class ShallowCopyTest {

    public static void main(String[] args) {
        int a=3;
        int result=0;
        final int fn_result = add(a, result);
        System.out.println("result = " + result);
        System.out.println("fn_result = " + fn_result);
    }

    /**
     * result 는 얕은 복사가 된다
     */
    public static int add(int a, int result) {
        result+=a;
        return result;
    }
}

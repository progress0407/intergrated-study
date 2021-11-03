package codingtest.nadongbin.lec3bdfs;

public class FactorialMain {
    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println("factorial = " + factorial);
    }

    private static int factorial(int n) {
        if(n==1) return 1;
        return n * factorial(n-1);
    }
}

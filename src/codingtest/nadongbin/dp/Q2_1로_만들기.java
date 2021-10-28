package codingtest.nadongbin.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.lang.System.out;

public class Q2_1로_만들기 {
    public static void main(String[] args) {
        int n = 26;
        solve(n);
    }

    private static void solve(int n) {
        int[] d = new int[n + 1];

        // d[i] = n i에 해당하는 수자에 도달하는 최소한의 횟수
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 1;


        for (int i = 6; i <= n; i++) {
            List<Integer> m = new ArrayList<>();
            if (Op.MUL_5.canResolve(i)) {
                m.add(d[i / 5] + 1);
            }
            if (Op.MUL_3.canResolve(i)) {
                m.add(d[i / 3] + 1);
            }
            if (Op.MUL_2.canResolve(i)) {
                m.add(d[i / 2] + 1);
            }
            m.add(d[i - 1] + 1);
            d[i] = getMin(m);
        }

        out.println("Arrays.toString(d) = " + Arrays.toString(d));
    }

    private static int getMin(List<Integer> m) {
        return m.stream()
                .mapToInt(e -> e)
                .min()
                .orElseGet(() -> -1);
    }

    enum Op {
        MUL_5(5, ArithmeticOp.MUL),
        MUL_3(3, ArithmeticOp.MUL),
        MUL_2(2, ArithmeticOp.MUL),
        ADD_1(1, ArithmeticOp.ADD);

        int num;
        ArithmeticOp op;

        Op(int num, ArithmeticOp op) {
            this.num = num;
            this.op = op;
        }

        public boolean canResolve(int n) {
            if (this.op == ArithmeticOp.MUL) {
                return n % num == 0;
            }
            return false;
        }

        public int calc (int n){
            if (this.op == ArithmeticOp.MUL) {
                return n * this.num;
            } else if (this.op == ArithmeticOp.ADD) {
                return n + this.num;
            }
            return -1;
        }
    }

    enum ArithmeticOp {
        MUL, ADD;
    }
}

package test.grammer.collectionzz;

public class ArrMain {
    public static void main(String[] args) {
        int[] val;

        int max = 3;
        val = new int[max];

        for (int i = 0; i < 3; i++) {
            val[i] = i;
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("val[i] = " + val[i]);
        }

        int[][] twoDim =  {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("twoDim[%d][%d] = %d,  ", i, j, twoDim[i][j]);
            }
            System.out.println();
        }

        System.out.println("====== length");

        System.out.println("val.length = " + val.length);
        System.out.println("twoDim.length = " + twoDim.length);
        System.out.println("twoDim[0].length = " + twoDim[0].length);

        for (int[] oneDim : twoDim) {
            System.out.println("oneDim = " + oneDim);
            for (int v : oneDim) {
                System.out.println("val = " + v);
            }
        }

        if(args.length > 0) {
            for (String arg : args) {
                System.out.println("arg = " + arg);
            }
        }
    }
}

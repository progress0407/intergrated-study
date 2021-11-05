package codingtest.dongbinna.lec1implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class Q5_럭키스트레이트 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String inputString = st.nextToken();

        int mid = inputString.length() / 2;

        int[] left = new int[mid];
        int[] right = new int[mid];

        for (int i = 0; i < mid; i++)
            left[i] = (int) (inputString.charAt(i) - '0');

        int leftSum = Arrays.stream(left).sum();

        for (int i = mid; i < inputString.length(); i++)
            right[i - mid] = (int) (inputString.charAt(i) - '0');

        int rightSum = Arrays.stream(right).sum();




        if(leftSum == rightSum) out.println("LUCKY");
        else out.println("READY");
    }
}

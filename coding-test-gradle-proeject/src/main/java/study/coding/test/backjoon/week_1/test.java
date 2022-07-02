package study.coding.test.backjoon.week_1;

import java.io.*;

public class test {

    public static void main(String[] args) throws IOException {
//        Reader reader = new StringReader("apple\norange\nbanana");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String str = br.readLine();
        System.out.println("str = " + str);
    }
}

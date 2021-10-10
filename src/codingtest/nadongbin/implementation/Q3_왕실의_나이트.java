package codingtest.nadongbin.implementation;

import java.util.Scanner;

import static java.lang.System.out;

public class Q3_왕실의_나이트 {

    public static int MAP_SIZE = 8;
    public static String INPUT_STRING = "";

    public static void main(String[] args) {

        out.println("입력: ");

//        INPUT_STRING = "c2";

        Scanner sc = new Scanner(System.in);
        INPUT_STRING = sc.next();

        String[] coord = INPUT_STRING.split("");

        int y = coord[0].toCharArray()[0] - (int)'a' + 1;
        int x = Integer.parseInt(String.valueOf(coord[1].toCharArray()[0]));

        out.printf("y, x = %d, %d \n", y, x);

        Coordinate curPos = new Coordinate(y, x);

        Coordinate[] movePos = {
                  new Coordinate(2,1)
                , new Coordinate(1,2)
                , new Coordinate(-2, 1)
                , new Coordinate(1, -2)
                , new Coordinate(2, -1)
                , new Coordinate(-1, 2)
                , new Coordinate(-2, -1)
                , new Coordinate(-1, -2)
        };

        int cnt = 0;
        for (int i = 0; i < movePos.length; i++) {
            if (checkPositionInMap(curPos, movePos[i])) {
                cnt++;
            }
        }

        out.println("cnt = " + cnt);
    }

    static boolean checkPositionInMap(Coordinate curPos, Coordinate movePos) {

        int toX = curPos.x + movePos.x;
        int toY = curPos.y + movePos.y;

        return !(toX < 1 || toX > MAP_SIZE
              || toY <1 || toY > MAP_SIZE);
    }

    static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

package codingtest.dongbinna.lec1implementation;

import java.util.Scanner;

import static java.lang.System.out;

public class Q3_왕실의_나이트 {

    public static int MAP_SIZE = 8;
    public static String INPUT_STRING = "";

    public static void main(String[] args) {

//        solve();
        review();
    }

    private static void review() {
        Scanner sc = new Scanner(System.in);
        out.print("입력: ");
        char[] split = sc.next().toCharArray();
        int r = split[0] - 'a' + 1;
        int c = split[1] - '0';

        Coord p = new Coord(r, c);

        int cnt = 0;
        for (MoveType d : MoveType.values()) {
            if (p.add(d)) {
                cnt++;
            }
        }

        out.println("cnt = " + cnt);
    }

    static class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean add(MoveType d) {
            int nr = r + d.r;
            int nc = c + d.c;

            if (nr < 1 || nr > MAP_SIZE || nc < 1 || nc > MAP_SIZE) {
                return false;
            }

//            실제로 이 좌표를 더하면 안된다. 보존 되어야 함
            /*nr += d.r;
            nc += d.c;*/

            return true;
        }
    }

    enum MoveType {
        M01(-2, -1), M02(-2, 1), M03(2, -1), M04(2, 1), M05(-1, -2), M06(-1, 2), M07(1, -2), M08(1, 2);

        int r;
        int c;

        MoveType(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }


    private static void solve() {
        out.print("입력: ");

//        INPUT_STRING = "c2";

        Scanner sc = new Scanner(System.in);
        INPUT_STRING = sc.next();

        String[] coord = INPUT_STRING.split("");

//        int y = coord[0].toCharArray()[0] - (int)'a' + 1; // c
//        int x = Integer.parseInt(String.valueOf(coord[1].toCharArray()[0])); // 2

        int y = coord[0].charAt(0) - 'a' + 1;
        int x = coord[1].charAt(0) - '0';

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

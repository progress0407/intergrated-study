
package codingtest.nadongbin.lec1implementation;

import static java.lang.System.out;

public class Q1_상하좌우 {

    public static String INPUT_STRING = "R R R U D D";
    public static final int MAP_SIZE = 5;

    public static void main(String[] args) {

        String[] inputKeys = INPUT_STRING.split(" ");

        int[][] map = new int[MAP_SIZE + 1][MAP_SIZE + 1];

        // 현재 위치
        Coordinate curPos = new Coordinate();
        curPos.init(1, 1);

        // 이동할 위치
        Coordinate destPos = new Coordinate();
        destPos.init(4, 3);

        // 위로 이동할지 아래로 이동할지 결정
//        MoveDirection moveDirX = setDirX(curPos, destPos);
//        MoveDirection moveDirY = setDirY(curPos, destPos);

        printMap(map);

        for (String inputKey : inputKeys) {

            Coordinate dPos = move(inputKey); // 2차원 변화량

            out.println(inputKey);
            out.println("curPos = " + curPos);
            out.println("dPos = " + dPos);

            if (curPos.x + dPos.x < 1 || curPos.x + dPos.x > MAP_SIZE
             || curPos.y + dPos.y < 1 || curPos.y + dPos.y > MAP_SIZE)
            {
                out.println("out of map !! ");
                continue;
            }

            curPos.move(dPos);
        }

        out.println("=========================");
        out.println("curPos = " + curPos);
    }

    private static void printMap(int[][] map) {
        out.println("========== print map");
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                out.printf("%3d", map[i][j]);
            }
            out.println();
        }
    }

    // 이동 구현
    public static Coordinate move(String dir) {

        int dx = 0;
        int dy = 0;

        switch (dir) {
            case "L":
                dy--;
                break;
            case "R":
                dy++;
                break;
            case "U":
                dx--;
                break;
            case "D":
                dx++;
                break;
//            case X_NEUTRAL:
//            case Y_NEUTRAL:
//                break;
        }

        Coordinate posDiff = new Coordinate();
        posDiff.init(dx, dy);
        return posDiff;
    }

    private static MoveDirection setDirX(Coordinate curPos, Coordinate destPos) {

        int curX = curPos.x;
        int destX = destPos.x;

        if (curX < destX) {
            return MoveDirection.DOWN;
        } else if (curX > destX) {
            return MoveDirection.UP;
        } else {
            return MoveDirection.X_NEUTRAL;
        }
    }

    private static MoveDirection setDirY(Coordinate curPos, Coordinate destPos) {

        int curY = curPos.y;
        int destY = destPos.y;

        if (curY < destY) {
            return MoveDirection.RIGHT;
        } else if (curY > destY) {
            return MoveDirection.LEFT;
        } else {
            return MoveDirection.Y_NEUTRAL;
        }
    }

    enum MoveDirection {
        UP, DOWN, X_NEUTRAL, // X축 (행)
        LEFT, RIGHT, Y_NEUTRAL; // Y축 (열)
    }

    static class Coordinate {
        int x;
        int y;

        void init(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move(Coordinate diffCord) {
            this.x += diffCord.x;
            this.y += diffCord.y;
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


package codingtest.nadongbin.lec3bdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class C07_미로탈출_연습 {

    /*public static int[][] map = {
            {1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1}
    };*/

    public static final int[][] map = {
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

    public static int distance = 1;

    public static void main(String[] args) {
        review();
    }

    private static void review() {
        Coord start = new Coord(0, 0);

        Queue<Coord> q = new LinkedList<>();
        q.offer(start);

        MoveTypes[] moveTypes = MoveTypes.values();

        while (!q.isEmpty()) {
            Coord p = q.poll();

            distance++;
            for (MoveTypes d : moveTypes) {
                int nr = p.r + d.r;
                int nc = p.c + d.c;

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) continue;
                if (map[nr][nc] != 1) continue;
                if ((nr == 0 || nc == 0) && distance != 2) continue; // 첫 좌표에는 다시 갈 수 없다}


                    Coord newCoord = new Coord(nr, nc);
                    out.println("newCoord = " + newCoord);
                    map[nr][nc] = distance;
                    q.offer(newCoord);
                }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                out.printf("%3d", map[i][j]);
            }
            out.println();
        }
    }

    static class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }


    enum MoveTypes {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        int r;
        int c;

        MoveTypes(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}

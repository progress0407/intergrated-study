package codingtest.dongbinna.lec3bdfs;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class C07_미로탈출 {

    private static int ROW_MAX = 0;
    private static int COL_MAX = 0;
    private static final int ROUTE = 1;
    private static final int MONSTER = 0;
    private static final int VISITED = 2;

    public static void main(String[] args) {

        int[][] map = {
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

//        int[][] map = {
//                {1, 1, 1, 1, 0, 0},
//                {0, 0, 0, 1, 0, 0},
//                {0, 0, 1, 1, 1, 0},
//                {1, 1, 1, 0, 1, 0},
//                {0, 1, 0, 0, 1, 0},
//                {0, 1, 1, 1, 1, 1}
//        };

        ROW_MAX = map.length;
        COL_MAX = map[0].length;

//        bfs(map);
        bfs2(map);

        printMap(map);
    }

    private static void printMap(int[][] map) {
        out.println("====== printMap");
        for (int y = 0; y < ROW_MAX; y++) {
            for (int x = 0; x < COL_MAX; x++) {
                out.printf("%4d", map[y][x]);
            }
            out.println();
        }
    }

    // 나동빈님 아이디어
    private static void bfs2(int[][] map) {

        ROW_MAX = map.length;
        COL_MAX = map[0].length;

        Queue<Integer[]> queue = new LinkedList<>();


        // 동빈이의 위치
        int y = 0;
        int x = 0;
        int d = 1;

        queue.offer(new Integer[]{y, x, d});

        while (!queue.isEmpty()) {

            Integer[] status = queue.poll();

            y = status[0];
            x = status[1];
            d = status[2];

            // 진행하지 않는다 
            // 1 범위를 초과하거나 
            // 2 몬스터일 경우
            // 3 방문한 장소
            if ((x == -1 || x == COL_MAX || y == -1 || y == ROW_MAX) || map[y][x] == 0 || map[y][x] >= 2) {
                continue;
            }

            if (map[y][x] == 1) {
                map[y][x] = d;
                printMap(map);

                if (x == COL_MAX - 1 && y == ROW_MAX - 1) {
                    break;
                }
            }

            queue.offer(new Integer[]{y - 1, x, d + 1});
            queue.offer(new Integer[]{y + 1, x, d + 1});
            queue.offer(new Integer[]{y, x - 1, d + 1});
            queue.offer(new Integer[]{y, x + 1, d + 1});

        }

    }

    // 내가 순수하게 푼 것
    private static void bfs(int[][] map) {

        Queue<Integer[]> visitList = new LinkedList<>();
        int cnt = 0; // 거쳐간 길의 갯수

        // 동빈이의 현재 위치
        int y = 0;
        int x = 0;
        // 동빈이가 이동한 거리
        int d = 1;

        visitList.offer(new Integer[]{y, x, d});

        while (!visitList.isEmpty()) {

            Integer[] dongbinStatus = visitList.poll();

            y = dongbinStatus[0];
            x = dongbinStatus[1];
            d = dongbinStatus[2];

            map[y][x] = VISITED;
            out.printf("%d: (%d, %d), d= %d \n", ++cnt, y, x, d);

            // 끝에 도달하였거나
            // 경로가 길어진 경우 제외
            if ((y == ROW_MAX - 1 && x == COL_MAX - 1) || d > (ROW_MAX * COL_MAX)/2) {
                // 도착한 모든 루트를 통틀어서 최소를 출력해야 한다.
                out.printf("FINISHED ! %d: (y, x) = (%d, %d), d = %d \n", cnt, y, x, d);
                break;
            }

            if (y - 1 >= 0 && map[y - 1][x] != MONSTER) { // UP
                visitList.offer(new Integer[]{y - 1, x, d + 1});
            }

            if (y + 1 < ROW_MAX && map[y + 1][x] != MONSTER) { // DOWN
                visitList.offer(new Integer[]{y + 1, x, d + 1});
            }

            if (x - 1 >= 0 && map[y][x - 1] != MONSTER) { // LEFT
                visitList.offer(new Integer[]{y, x - 1, d + 1});
            }

            if (x + 1 < COL_MAX && map[y][x + 1] != MONSTER) {
                visitList.offer(new Integer[]{y, x + 1, d + 1});
            }

        } // while
    }
}

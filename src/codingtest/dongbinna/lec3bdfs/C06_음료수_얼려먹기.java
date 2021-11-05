package codingtest.dongbinna.lec3bdfs;

import static java.lang.System.out;

public class C06_음료수_얼려먹기 {

    private static int MAX_ROW = 0;
    private static int MAX_COL = 0;
    private static final int ROUTE = 0;
    private static final int WALL = 1;
    private static final int VISITED = 2;
    private static int groupCnt = 0;

    public static void main(String[] args) {

        int[][] map = {
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        /*
        int[][] map = {
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        */

        MAX_ROW = map.length;
        MAX_COL = map[0].length;

        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                int cell = map[i][j];
                if (cell == ROUTE) { // ROUTE == 0
                        groupCnt++;
                        out.printf("(%d, %d) groupCnt = %d \n", i, j, groupCnt);
                        dfs(map, i, j);
                }
            }
        }

        printMap(map);
    }

    private static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                out.print(ints[j]);
            }
            out.println();
        }
    }

    // lastStatus; // 마지막 방문했었던 현재 장소 상태(벽, 길, 방문함)를 저장하는 플래그 변수
    private static void dfs(int[][] map, int row, int col) {

        // UP과 LEFT는 이동할 필요가 없기 떄문에 조건을 체크하지 않는다
        //if ( !((row >= 0 && row < 4) && (col >= 0 && col < 5)) ) {
//        if (!(row < MAX_ROW && col < 5)) {

        if ( row == -1 || row == MAX_ROW || col == -1 || col == MAX_COL) {
            return;
        }

        int cell = map[row][col];

        /*
        if (cell == WALL || cell == VISITED) {
            return;
        }
        */

        if (cell == ROUTE) { // ROUTE일 때만 순회한다.. 아니라면? 더이상 순회하지 않는다
            map[row][col] = VISITED;
            dfs(map, row - 1, col); // UP
            dfs(map, row, col + 1); // RIGHT
            dfs(map, row + 1, col); // DOWN
            dfs(map, row, col - 1); // LEFT
        }


    }
}

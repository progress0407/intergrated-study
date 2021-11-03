package codingtest.nadongbin.lec3bdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class C04_DFS_연습 {

    public static final int MAX = 9;
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final boolean[] visited = new boolean[MAX];;

    public static void main(String[] args) {

//        initData();
        initDataReview();

//        dfs(1);

        dfsReview(1);

        out.println("graph = " + graph);

        out.println("Arrays.toString(visited) = " + Arrays.toString(visited));
    }

    private static void dfsReview(int x) {

        visited[x] = true;

        List<Integer> list = graph.get(x);

        for (Integer toVisit : list) {
            if(!visited[toVisit]) dfsReview(toVisit);
        }
    }

    private static void initDataReview() {
        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

    }

    private static void dfs(int x) {

        visited[x] = true;
        List<Integer> list = graph.get(x);
        for (Integer toVisit : list) {
            if (!visited[toVisit]) {
                dfs(toVisit);
            }
        }
    }

    private static void initData() {

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);
    }
}

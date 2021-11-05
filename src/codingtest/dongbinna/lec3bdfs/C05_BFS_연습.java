package codingtest.dongbinna.lec3bdfs;

import java.util.*;

import static java.lang.System.out;

public class C05_BFS_연습 {

    public static final int MAX = 9;
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final boolean[] visited = new boolean[MAX];;

    public static void main(String[] args) {
        initData();

//        bfs();
        bfsReview();

        out.println("Arrays.toString(visited) = " + Arrays.toString(visited));
    }

    private static void bfsReview() {

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);

        while (!q.isEmpty()) {
            Integer x = q.poll();
            visited[x] = true;

            List<Integer> list = graph.get(x);
            for (Integer toVisit : list) {
                if (!visited[toVisit]) {
                    q.offer(toVisit);
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);

        while (!q.isEmpty()) {

            Integer x = q.poll();
            visited[x] = true;

            List<Integer> list = graph.get(x);
            for (Integer toVisit : list) {
                if (!visited[toVisit]) {
                    q.offer(toVisit);
                }
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

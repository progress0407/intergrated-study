package codingtest.nadongbin.bdfs;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class C05_BFS {
    public static void main(String[] args) {

        Integer[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        boolean[] visited = new boolean[9];
        int startPosition = 1;

//        bfs(graph, visited, startPosition);
        bfs2(graph, visited, startPosition);

        for (int i = 0; i < visited.length; i++) {
            out.printf("%d: %s \n", i, visited[i]);
        }

    }

    private static void bfs2(Integer[][] graph, boolean[] visited, int startPosition) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPosition);
        visited[startPosition] = true;

        while (!queue.isEmpty()) {

            Integer selectNode = queue.poll();
            out.println("selectNode = " + selectNode);

            Integer[] nodes = graph[selectNode];

            for (Integer node : nodes) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }

        }
    }



    private static void bfs(Integer[][] graph, boolean[] visited, int startPosition) {

        Queue<Integer> queue = new LinkedList<>();

        visited[startPosition] = true;
        queue.offer(startPosition);

        out.println("node = " + startPosition);

        while (!queue.isEmpty()) {

            Integer selectNode = queue.poll();
            Integer[] nodes = graph[selectNode];
//            out.println("node = " + selectNode);

            for (Integer node : nodes) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                    out.println("node = " + node);
                }
            }


        }

    }
}

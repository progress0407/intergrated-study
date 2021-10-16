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

        bfs(graph);
    }

    private static void bfs(Integer[][] graph) {
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(graph[1]);

        while (!queue.isEmpty()) {

        }

    }
}

package study.coding.test.backjoon.week_4.pre_info;

import java.util.LinkedList;
import java.util.Queue;

class BFS {

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

    public static void main(String[] args) {
        final BFS BFS = new BFS();
//        BFS.solve();
        BFS.solve2();
    }

    private void solve2() {
        final Queue<Integer> queue = new LinkedList<>();

        queue.offer(startPosition);
        visited[startPosition] = true;
        System.out.println("startPosition = " + startPosition);

        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();
            final int size = graph[poll].length;

            for (int i = 0; i < size; i++) {
                final Integer nearNode = graph[poll][i];

                if (visited[nearNode] == false) {
                    visited[nearNode] = true;
                    queue.offer(nearNode);
                    System.out.println("nearNode = " + nearNode);
                }
            }
        }
    }

    private void solve() {
        final LinkedList<Integer> queue = new LinkedList<>();

        visited[startPosition] = true;
        System.out.println("startPosition = " + startPosition);
        queue.offer(startPosition);


        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();

            for (int i = 0; i < graph[poll].length; i++) {
                final Integer visitIndex = graph[poll][i];
                if (visited[visitIndex] == false) {
                    visited[visitIndex] = true;
                    System.out.println("visitIndex = " + visitIndex);
                    queue.offer(visitIndex);
                }
            }
        }
    }

}

package codingtest.nadongbin.lec7graph;

import java.util.*;

import static java.lang.System.out;

public class DijkstraMain {

    private static List<List<Node>> graph = new ArrayList<>();
    private static final int MAX = 6;

    private static final int[] d = new int[MAX + 1];

    public static void main(String[] args) {

        initData();

        List<Node> start = graph.get(1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {

            Integer x = q.poll();

            List<Node> nodes = graph.get(x); // 1 -> 2,3,4

            for (Node node : nodes) {
                if (d[node.index] > node.distance + d[x]) {
                    d[node.index] = node.distance + d[x];
                }
            }

            int min = Integer.MAX_VALUE;
            for (Node node : nodes) {
                if (min < d[node.index]) {
                    min = d[node.index];
                }
            }
        }

    }

    private static void initData() {

        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        for (int i = 0; i <= MAX; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 3));
        graph.get(1).add(new Node(4, 1));

        graph.get(2).add(new Node(3, 3));
        graph.get(2).add(new Node(4, 1));

        graph.get(3).add(new Node(2, 3));
        graph.get(3).add(new Node(5, 5));

        graph.get(4).add(new Node(3, 3));
        graph.get(4).add(new Node(5, 1));

        graph.get(5).add(new Node(3, 1));
        graph.get(5).add(new Node(6, 2));

    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", distance=" + distance +
                    '}';
        }
    }
}

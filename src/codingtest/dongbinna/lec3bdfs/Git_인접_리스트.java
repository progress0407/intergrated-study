package codingtest.dongbinna.lec3bdfs;

import java.util.ArrayList;

import static java.lang.System.out;

public class Git_인접_리스트 {

    static class Node {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public void show() {
            out.println("(" + this.index + ", " + this.distance + ")");
        }

    }

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        graph.get(1).add(new Node(0, 7));

        graph.get(2).add(new Node(0, 5));

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
        }


    }
}

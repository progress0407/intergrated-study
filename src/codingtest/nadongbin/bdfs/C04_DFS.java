package codingtest.nadongbin.bdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_DFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>());

//        graph.add(new ArrayList<>(Arrays.asList(2, 3, 8)));
        listAdd(graph, 2, 3, 8);
        listAdd(graph, 1, 7);
        listAdd(graph, 1, 4, 5);
        listAdd(graph, 3, 5);
        listAdd(graph, 3, 4);
        listAdd(graph, 7);
        listAdd(graph, 2, 6, 8);
        listAdd(graph, 1, 7);

        boolean[] visited = new boolean[10];

        System.out.println("graph = " + graph);

        dfs(graph, 1, visited);

    }

    public static void listAdd(List<List<Integer>> graph, Integer... numbers) {

        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        graph.add(list);
    }

    public static void dfs(List<List<Integer>> graph, int startPosition, boolean[] visited) {

        visited[startPosition] = true;

        System.out.println("visit = " + startPosition);

        List<Integer> nearNumberList = graph.get(startPosition);

        for (Integer nearNumber : nearNumberList) {
            if (!visited[nearNumber]) {
                dfs(graph, nearNumber, visited);
            }
        }

    }
}

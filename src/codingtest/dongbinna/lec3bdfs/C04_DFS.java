package codingtest.dongbinna.lec3bdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class C04_DFS {
    public static void main(String[] args) {

        List<List<Integer>> graph = new ArrayList<>();

        // index를 0으로 만들기 위해 초기 빈 리스트 삽입
        graph.add(new ArrayList<>());

//        graph.add(new ArrayList<>(Arrays.asList(2, 3, 8)));
//        listAdd(graph, 2, 3, 8); // graph.add(new ArrayList<>(new int[]{2, 3, 8}));
//        listAdd(graph, 1, 7);
//        listAdd(graph, 1, 4, 5);
//        listAdd(graph, 3, 5);
//        listAdd(graph, 3, 4);
//        listAdd(graph, 7);
//        listAdd(graph, 2, 6, 8);
//        listAdd(graph, 1, 7);



//        solve(graph);
        review(graph);
    }

    private static void review(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];

//        Arrays.fill(visited, false); // 굳이 안해주어도 초기값은 false

        dfs2(graph, visited, 1);

        out.println("Arrays.toString(visited) = " + Arrays.toString(visited));

    }

    private static void dfs2(List<List<Integer>> graph, boolean[] visited, Integer toVisit) {

        if (visited[toVisit]) return;

        visited[toVisit] = true;

        List<Integer> list = graph.get(toVisit);

        for (int i = 0; i < list.size(); i++) {
            Integer toVisit2 = list.get(i);
            out.printf("%s :: %d \n", Arrays.toString(visited), toVisit2);
            dfs2(graph, visited, toVisit2);
        }

    }


    private static void solve(List<List<Integer>> graph) {

        boolean[] visited = new boolean[10];

        out.println("graph = " + graph);

        dfs(graph, 1, visited);
    }

    public static void listAdd(List<List<Integer>> graph, Integer... numbers) {

        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        graph.add(list);
    }

    public static void dfs(List<List<Integer>> graph, int startPosition, boolean[] visited) {

        visited[startPosition] = true;

        out.println("visit = " + startPosition);

        List<Integer> nearNumberList = graph.get(startPosition);

        for (Integer nearNumber : nearNumberList) {
            if (!visited[nearNumber]) {
                dfs(graph, nearNumber, visited);
            }
        }

    }
}

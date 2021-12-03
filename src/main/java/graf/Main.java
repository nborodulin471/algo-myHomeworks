package graf;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Graph graph;
    static int V = 6;

    public static void main(String[] args) {
        graph = new Graph(6);
        graph.add_edge(0, 1);
        graph.add_edge(1, 2);
        graph.add_edge(3, 4);

        // Сколько достижимо городов для каждого города: [2, 2, 2, 1, 1, 0]
        calc_paths(graph);
    }

    public static void calc_paths(Graph graph) {
        int[] marks = new int[graph.size()];
        List<Integer> mark_sizes = new ArrayList<>();

        for (int v = 0; v < graph.size(); v++) {
            if (marks[v] == 0) {
                //int next_mark =  mark_sizes.size();
                int next_mark = mark_sizes.size() + 1;
                int size = dfs(v, next_mark, marks);
                mark_sizes.add(size);
            }
        }

        int[] answer = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            answer[i] = mark_sizes.get(marks[i]) - 1;
        }

//        System.out.println(String.format("Сколько достижимо городов для каждого города: %s",
//                Arrays.toString(mark_sizes.stream().toArray())));
    }

    public static int dfs(int v, int mark, int[] marks) {
        marks[v] = mark;
        int size = 1;

        for (int vv : graph.adjacent(v)) {

            if (marks[vv] == 0) {
                size += dfs(vv, mark, marks);
            }

            //return size;
        }

        return size;
    }
}

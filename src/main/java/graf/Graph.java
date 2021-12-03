package graf;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public List<Integer>[] vertices_info;

    public Graph(int count) {
        this.vertices_info = new LinkedList[count];

        for (int i = 0; i < count; i++) {
            vertices_info[i] = new LinkedList();
        }
    }

    public List<Integer>[] getVertices_info() {
        return vertices_info;
    }

    public void setVertices_info(List<Integer>[] vertices_info) {
        this.vertices_info = vertices_info;
    }

    public void add_edge(int a, int b) {
        vertices_info[a].add(b);
        vertices_info[b].add(a);
    }

    public List<Integer> adjacent(int v) {
        return vertices_info[v];
    }

    public int size() {
        return vertices_info.length;
    }

}

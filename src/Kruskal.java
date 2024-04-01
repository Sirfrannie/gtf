import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    private Graph graph;

    public Kruskal(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Edge> getMST() {
        ArrayList<Edge> result = new ArrayList<>();
        Collections.sort(graph.getEdges(), (e1, e2) -> e1.getWeight() - e2.getWeight());
        DisjointSet ds = new DisjointSet(graph.getVertices().size());

        for (Edge edge : graph.getEdges()) {
            Vertex v1 = edge.getVertices().get(0);
            Vertex v2 = edge.getVertices().get(1);
            if (ds.find(v1.getIndex()) != ds.find(v2.getIndex())) {
                ds.union(v1.getIndex(), v2.getIndex());
                result.add(edge);
            }
        }
        return result;
    }
}

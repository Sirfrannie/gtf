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
            if (ds.find(v1.getIndex(graph.getVertices())) != ds.find(v2.getIndex(graph.getVertices()))) {
                ds.union(v1.getIndex(graph.getVertices()), v2.getIndex(graph.getVertices()));
                result.add(edge);
            }
        }
        return result;
    }
    public static void main(String args[]){
        Graph g = new Graph();
        g.p1();
        Kruskal p = new Kruskal(g);
        int sum = 0;
        System.out.println("Kruskal");
        for (Edge e : p.getMST()){
            System.out.println(e+ " \""+e.getWeight());
            sum += e.getWeight();
        }
        System.out.println(sum);
    }
}

import java.util.PriorityQueue;
import java.util.ArrayList;

public class Prim {
    private Graph graph;

    public Prim(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Edge> getMST() {
        ArrayList<Edge> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertices().size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.getWeight() - e2.getWeight());

        // Start from vertex 0 (assuming graph is 0-indexed and connected)
        visited[0] = true;
        pq.addAll(graph.getVertices().get(0).getEdges());

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            Vertex v = edge.getVertices().get(1);
            if (visited[v.getIndex(graph.getVertices())]) continue;
            visited[v.getIndex(graph.getVertices())] = true;
            result.add(edge);
            for (Edge e : v.getEdges()) {
                if (!visited[e.getVertices().get(1).getIndex(graph.getVertices())]) {
                    pq.add(e);
                }
            }
        }
        return result;
    }
    public static void main(String args[]){
        Graph g = new Graph();
        g.p1();
        Prim p = new Prim(g);
        int sum = 0;
        System.out.println("Prim");
        for (Edge e : p.getMST()){
            System.out.println(e+ " \""+e.getWeight());
            sum += e.getWeight();
        }
        System.out.println(sum);
    }
}

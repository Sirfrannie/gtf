import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public int[] getShortestPathsFrom(Vertex source) {
        int[] distances = new int[graph.getVertices().size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source.getIndex(graph.getVertices())] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> distances[v1.getIndex(graph.getVertices())] - distances[v2.getIndex(graph.getVertices())]);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            for (Edge edge : current.getEdges()) {
                Vertex v = edge.getVertices().get(1);
                int newDist = distances[current.getIndex(graph.getVertices())] + edge.getWeight();
                if (newDist < distances[v.getIndex(graph.getVertices())]) {
                    distances[v.getIndex(graph.getVertices())] = newDist;
                    pq.add(v);
                }
            }
        }

        return distances;
    }
    public static void main(String args[]){
        Graph g = new Graph();
        g.p1();
        Dijkstra d = new Dijkstra(g);
        int sum = 0;
        int[] path = d.getShortestPathsFrom(g.getVertices().get(0));
        for (int i : path){
            sum += i;
            System.out.println(i);
        }
        System.out.print(sum);
    }
}

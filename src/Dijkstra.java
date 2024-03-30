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
        distances[source.getIndex()] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> distances[v1.getIndex()] - distances[v2.getIndex()]);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            for (Edge edge : current.getEdges()) {
                Vertex v = edge.getVertices().get(1);
                int newDist = distances[current.getIndex()] + edge.getWeight();
                if (newDist < distances[v.getIndex()]) {
                    distances[v.getIndex()] = newDist;
                    pq.add(v);
                }
            }
        }

        return distances;
    }
}

import java.util.ArrayList;

public class Vertex {
    private String label; // name of vertex
    private ArrayList<Edge> edges; // edges this vertex connected with
    private int degree = 0; // number of edges
    private ArrayList<Vertex> connection = new ArrayList<>(); // List of vertices that connected with this vertex
    private int index; // Unique index for each vertex

    public Vertex(String label, int index) {
        this.label = label;
        this.edges = new ArrayList<>();
        this.index = index;
    }

    public void addDegree() {
        this.degree += 1;
    }

    public void addEdge(Edge e) {
        this.edges.add(e);
    }

    public void addConnection(ArrayList<Vertex> v, String label) {
        for (Vertex vertex : v) {
            if (vertex.getLabel().equals(label)) {
                this.connection.add(vertex);
            }
        }
    }

    public void addConnection(Vertex v) {
        this.connection.add(v);
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public int getDegree() {
        return this.degree;
    }

    public String getLabel() {
        return this.label;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return this.label;
    }
}

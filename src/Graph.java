import java.util.ArrayList;
public class Graph
{
    private ArrayList<Vertex> vertices; // all vertices in graph
    private ArrayList<Edge> edges; // all edges in graph

    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    public void addVertex(String label){
        vertices.add(new Vertex(label));
    }
    public boolean addEdge(String label, int weight, Vertex v1, Vertex v2){
        // cancel adding the edge if two vertex already have a connection
        if (v1.getConnection().contains(v2)){
            return false;
        }
        edges.add(new Edge(label, weight, v1, v2));
        return true;
    }
    public boolean addEdge(String label, int weight, Vertex v){
        if (v.getConnection().contains(v)) return false;
        edges.add(new Edge(label, weight, v));
        return true;
    }
    public void removeVertex(Vertex v){
        this.vertices.remove(v);
        // remove all edge that involve with this vertex
        for (int i=0; i<edges.size(); ++i){
            if (edges.get(i).getVertices().contains(v)) {
                removeEdge(edges.get(i));
                --i; // after removing ArrayList will resize and shift element
            }
        }
    }
    public void removeEdge(Edge e){
        this.edges.remove(e);
        // remove this edge in each vertex's edge list which contains this edge
        for (Vertex v : this.vertices){
            if (v.getEdges().contains(e)) v.getEdges().remove(e);
        }
    }
    // preset graph
    public void p1(){
        vertices.add(new Vertex("Washington"));
        vertices.add(new Vertex("Montana"));
        vertices.add(new Vertex("Minnesota"));
        vertices.add(new Vertex("California"));
        vertices.add(new Vertex("Oregon"));
        vertices.add(new Vertex("Utah"));
        vertices.add(new Vertex("Arizona"));
        vertices.add(new Vertex("Colorado"));
        vertices.add(new Vertex("New Mexico"));
        vertices.add(new Vertex("Texas"));
        vertices.add(new Vertex("Kansas"));

        edges.add(new Edge("a", 663, vertices, "Washington", "Montana"));
        edges.add(new Edge("b", 1306, vertices, "California", "Montana"));
        edges.add(new Edge("c", 668, vertices, "California", "Oregon"));
        edges.add(new Edge("d", 791, vertices, "California", "Utah"));
        edges.add(new Edge("e", 570, vertices, "Arizona", "Utah"));
        edges.add(new Edge("f", 444, vertices, "Colorado", "Utah"));
        edges.add(new Edge("g", 401, vertices, "Colorado", "New Mexico"));
        edges.add(new Edge("h", 437, vertices, "Arizona", "New Mexico"));
        edges.add(new Edge("i", 401, vertices, "Texas", "New Mexico"));
        edges.add(new Edge("j", 641, vertices, "Texas", "Kansas"));
        edges.add(new Edge("k", 1023, vertices, "Kansas", "Montana"));
        edges.add(new Edge("l", 720, vertices, "Kansas", "Minnesota"));
        edges.add(new Edge("m", 794, vertices, "Montana", "Minnesota"));
    }
    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
    @Override
    public String toString(){
        String o = "";
        for (Vertex v : vertices){
            o += v + "\n";
        }
        o += "-----------------\n";
        for (Edge v : edges){
            o += v + "\n";
        }
        return o;
    }
}

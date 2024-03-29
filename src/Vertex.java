import java.util.ArrayList;

public class Vertex
{
    private String label; // name of vertex
    private ArrayList<Edge> edges; // edges this vertex conected with
    private int degree = 0; // number of edges
    private ArrayList<Vertex> connection = new ArrayList<>(); // List of vertices that connected with this vertex

    public Vertex(String label){
        edges = new ArrayList<>();
        this.label = label;
    }
    public void addDegree(){
        this.degree += 1;
    }
    public void addEdge(Edge e){
        this.edges.add(e);
    }
    public void addConnection(ArrayList<Vertex> v, String label){
        for (int i=0; i<v.size(); ++i){
            if (v.get(i).getLabel().equals(label)){
                this.connection.add(v.get(i));
            }
        }
    }
    public void addConnection(Vertex v){
        this.connection.add(v);
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
    public int getDegree(){
        return this.degree;
    }
    public String getLabel(){
        return this.label;
    }
    public String toString(){
        return this.label;
    }
}

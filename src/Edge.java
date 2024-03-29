import java.util.ArrayList;

public class Edge
{
    private String label; // name of edge
    private int weight; // weight of edge ( value )
    private ArrayList<Vertex> vertices; // vertices which this edge connects

    public Edge(String label){
        vertices = new ArrayList<>();
        this.label = label;
    }
    public Edge(String label, int weight){
        vertices = new ArrayList<>();
        this.label = label;
        this.weight = weight;
    }
    public Edge(String label, int weight, Vertex v1, Vertex v2){
        vertices = new ArrayList<>();
        this.label = label;
        this.weight = weight;
        if (v1 == v2 ){
            this.vertices.add(v1);
            v1.addEdge(this);
        }else {
            this.vertices.add(v1);
            v1.addEdge(this);
            v1.addConnection(v2);
            this.vertices.add(v2);
            v2.addEdge(this);
            v2.addConnection(v1);
        }

    }
    public Edge(String label, int weight, ArrayList<Vertex> v, String v1, String v2){
        vertices = new ArrayList<>();
        this.label = label;
        this.weight = weight;
        for (int i=0; i<v.size(); ++i){
            if (v.get(i).getLabel().equals(v1)){
                this.vertices.add(v.get(i));
                v.get(i).addEdge(this);
                v.get(i).addConnection(v, v2);
            }
            if (v.get(i).getLabel().equals(v2)){
                this.vertices.add(v.get(i));
                v.get(i).addEdge(this);
                v.get(i).addConnection(v, v1);
            }
        }
    }

    // connect vertex with vertex label
    public void connect(ArrayList<Vertex> v, String v1){
        for (int i=0; i<v.size(); ++i){
            if (v.get(i).getLabel().equals(v1)){
                this.vertices.add(v.get(i));
                v.get(i).addEdge(this);
            }
        }
    }
    public void connect(ArrayList<Vertex> v, String v1, String v2){
        for (int i=0; i<v.size(); ++i){
            if (v.get(i).getLabel().equals(v1)){
                this.vertices.add(v.get(i));
                v.get(i).addEdge(this);
                v.get(i).addConnection(v, v2);
            }
            if (v.get(i).getLabel().equals(v2)){
                this.vertices.add(v.get(i));
                v.get(i).addEdge(this);
                v.get(i).addConnection(v, v1);
            }
        }
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getLabel(){
        return this.label;
    }
    @Override
    public String toString(){
        String o = "edges "+this.label+" [";
        for (Vertex v : vertices){
            o += v +" ";
        }
        o += "]";
        return o; 
    }
    
}

import javax.swing.JTable;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Table 
{
    ArrayList<Vertex> vertices;    
    ArrayList<Edge> edges;
    Graph graph;
    public Table(Graph g){
        this.vertices = g.getVertices();
        this.edges = g.getEdges();
        this.graph = g;
    }
    public JTable verticesTable(){
        String columnNames[] = {"Label", "degree", "edges", "connection"}; 
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String arr[] = null;
        for (Vertex v : vertices){
            if ( v.getDegree() == 0 ){
                arr = new String[] {v.getLabel(), ""+v.getDegree()};
                data.add(new ArrayList(Arrays.asList(arr)));
                arr = new String[] {"______________","______________","______________","______________"};
                data.add(new ArrayList(Arrays.asList(arr)));
                continue;
            }
            arr = new String[] {v.getLabel(), ""+v.getDegree(), v.getEdges().get(0).getLabel(), v.getConnection().get(0).getLabel()};
            data.add(new ArrayList(Arrays.asList(arr)));
            for (int i=1; i<v.getDegree(); ++i){
                arr = new String[]{"", "", v.getEdges().get(i).getLabel(), v.getConnection().get(i).getLabel()};
                data.add(new ArrayList(Arrays.asList(arr)));
            }
            arr = new String[]{"______________","______________","______________","______________"};
            data.add(new ArrayList(Arrays.asList(arr)));
        }
        // turn ArrayList<ArrayList<String>> to String[][]
        String[][] newData = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        // create table
        JTable table = new JTable(newData, columnNames);
        table.setModel(new DefaultTableModel(newData, columnNames){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.setShowHorizontalLines(false);

        return table;
    }
    public JTable edgesTable(){
        String columnNames[] = {"Label", "weight", "connected"}; 
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String arr[] = null;
        for (Edge e : edges){
            if (e.getVertices().size() == 2 ){
                arr = new String[]{e.getLabel(), ""+e.getWeight(), e.getVertices().get(0).getLabel()+", "+e.getVertices().get(1).getLabel()};
            }else{
                arr = new String[]{e.getLabel(), ""+e.getWeight(), e.getVertices().get(0).getLabel()+", "+e.getVertices().get(0).getLabel()};
            }
            data.add(new ArrayList(Arrays.asList(arr)));
        }
        // turn ArrayList<ArrayList<String>> to String[][]
        String[][] newData = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        // create table
        JTable table = new JTable(newData, columnNames);
        table.setModel(new DefaultTableModel(newData, columnNames){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);

        return table;
    }
    public JTable primMST(){
        String columnNames[] = {"Vertex", "Edge", "Vertex", "Total weight"};        
        ArrayList<Edge> tree = new Prim(graph).getMST();

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        int sumWeight = 0;
        for (Edge e : tree){
            sumWeight += e.getWeight();
            String arr[] = {e.getVertices().get(0).getLabel(), e.getLabel()+" ("+e.getWeight()+")", e.getVertices().get(1).getLabel(), sumWeight+""};
            data.add(new ArrayList(Arrays.asList(arr)));
        }
        // turn ArrayList<ArrayList<String>> to String[][]
        String[][] newData = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        // create table
        JTable table = new JTable(newData, columnNames);
        table.setModel(new DefaultTableModel(newData, columnNames){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);

        return table;
    }
    public JTable kruskalMST(){
        String columnNames[] = {"Vertex", "Edge", "Vertex", "Total weight"};        
        ArrayList<Edge> tree = new Kruskal(graph).getMST();

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        int sumWeight = 0;
        for (Edge e : tree){
            sumWeight += e.getWeight();
            String arr[] = {e.getVertices().get(0).getLabel(), e.getLabel()+" ("+e.getWeight()+")", e.getVertices().get(1).getLabel(), sumWeight+""};
            data.add(new ArrayList(Arrays.asList(arr)));
        }
        // turn ArrayList<ArrayList<String>> to String[][]
        String[][] newData = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        // create table
        JTable table = new JTable(newData, columnNames);
        table.setModel(new DefaultTableModel(newData, columnNames){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);

        return table;
    }
}

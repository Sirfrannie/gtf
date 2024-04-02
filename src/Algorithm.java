import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
public class Algorithm extends Panel
{
    private Graph graph;
    private int insets;

    // button
    private JButton b_back = new JButton("back");
    private JButton b_menu = new JButton("return to menu");
    private JButton b_kruskal = new JButton("Kruskal's Algorithm");
    private JButton b_prim = new JButton("Prim's Algorithm");
    private JButton b_dijkstra = new JButton("Diskstra's Algorithm");

    // Label
    private JLabel l_vertices = new JLabel("Vertices");
    private JLabel l_edges = new JLabel("Edges");
    private JLabel l_mst = new JLabel("Minimum spanning tree");
    private JLabel l_sp = new JLabel("Shortest path");
    public Algorithm(JFrame frame, Graph graph){
        super();
        this.graph = graph;
        this.insets = height-frame.getInsets().top;
        buildComponents(frame);
    }
    private void buildComponents(JFrame frame){

        b_back.addActionListener((e) ->{
            this.setVisible(false);
            frame.add(new GraphBuilding(frame, graph));
            frame.remove(this);
        });     
        b_back.setBounds(10, insets-70, 80, 30);
        b_back.setVisible(true);

        b_menu.addActionListener((e) ->{
            this.setVisible(false);
            frame.add(new Menu(frame));
            frame.remove(this);
        });     
        b_menu.setBounds(10, insets-35, 125, 30);
        b_menu.setVisible(true);

        b_kruskal.addActionListener((e) ->{
            buildOutput(new Table(graph).kruskalMST());
        });     
        b_kruskal.setBounds(850, 150, 180, 60);
        b_kruskal.setVisible(true);

        b_prim.addActionListener((e) ->{
            buildOutput(new Table(graph).primMST());
        });     
        b_prim.setBounds(850, 220, 180, 60);
        b_prim.setVisible(true);

        b_dijkstra.addActionListener((e) ->{
        });     
        b_dijkstra.setBounds(850, 460, 180, 60);
        b_dijkstra.setVisible(true);

        l_vertices.setBounds(360, 340, 200, 20);
        l_vertices.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        l_vertices.setVisible(true);

        l_edges.setBounds(60, 340, 200, 20);
        l_edges.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        l_edges.setVisible(true);

        l_mst.setBounds(850, 120, 600, 30);
        l_mst.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        l_mst.setVisible(true);

        l_sp.setBounds(850, 430, 600, 30);
        l_sp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        l_sp.setVisible(true);

        // adding components
        this.add(b_back); 
        this.add(b_menu); 
        this.add(b_kruskal); 
        this.add(b_prim); 
        this.add(b_dijkstra); 
        
        this.add(l_vertices); 
        this.add(l_edges); 
        this.add(l_mst); 
        this.add(l_sp); 
        buildTable();
        buildOutput(null);
    }
    JScrollPane vertPane = new JScrollPane();
    JScrollPane edgePane = new JScrollPane();
    private void buildTable(){
        vertPane.setViewportView(new Table(graph).verticesTable());
        vertPane.setBounds(360, 360, 280, 200);
        this.add(vertPane);

        edgePane.setViewportView(new Table(graph).edgesTable());
        edgePane.setBounds(60, 360, 290, 200);
        this.add(edgePane);
    }
    JScrollPane outputPane = new JScrollPane();
    private void buildOutput(JTable table){
        if (table != null){
            outputPane.setViewportView(table);
        }
        outputPane.setBounds(60, 30, 580, 300);
        this.add(outputPane);
    } 

}

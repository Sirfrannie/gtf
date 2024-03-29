import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import java.lang.Exception;
import java.util.ArrayList;

public class GraphBuilding extends Panel
{
    private JButton e = new JButton("exit");
    private JButton c = new JButton("continue");
    // graph
    private Graph graph;
    private JButton b_addVertex = new JButton("+v");
    private JButton b_removeVertex = new JButton("-");
    private JButton b_addEdge = new JButton("+e");
    private JButton b_removeEdge = new JButton("-");
    private JButton b_addVertexByNum = new JButton("+vn");
    private JButton b_addEdgeByNum = new JButton("+en");
    // table 
    public GraphBuilding(JFrame frame){
        super();
        graph = new Graph();
        graph.p1();
        e.addActionListener((e) -> {
            this.setVisible(false);
            frame.add(new Menu(frame));
            frame.remove(this);
        });
        e.setBounds(10, (int)(height-frame.getInsets().top-35), 60, 30);
        e.setVisible(true);
        c.addActionListener((e) -> {
            System.out.println(graph);
        });
        c.setBounds(10, (int)(height-frame.getInsets().top-100), 60, 30);
        c.setVisible(true);


        // graph button
        // add single vertex
        b_addVertex.addActionListener((e) -> addVertex());
        b_addVertex.setBounds(10, 10, 60, 30);
        b_addVertex.setVisible(true);

        // add mutiple vertices
        b_addVertexByNum.addActionListener((e) -> {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog(this, "input number of vertex you need to add", "Add Vertex", -1));
                System.out.println(num); 
                for (int i=1; i<= num; ++i){
                    addVertex(i);
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Please Input only number", "error", 2);
            }
        });
        b_addVertexByNum.setBounds(100, 10, 60, 30);
        b_addVertexByNum.setVisible(true);

        // add single edge
        b_addEdge.addActionListener((e) -> addEdge());
        b_addEdge.setBounds(10, 50, 60, 30);
        b_addEdge.setVisible(true);

        // add mutiple edges
        b_addEdgeByNum.addActionListener((e) -> {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog(this, "input number of edge you need to add", "Add Edge", -1));
                System.out.println(num); 
                for (int i=1; i<= num; ++i){
                    addEdge(i);
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Please Input only number", "error", 2);
            }
        });
        b_addEdgeByNum.setBounds(100, 50, 60, 30);
        b_addEdgeByNum.setVisible(true);

        // add button to panel
        this.add(e);
        this.add(b_addVertex);
        this.add(c);
        this.add(b_addVertexByNum);
        this.add(b_addEdge);
        this.add(b_addEdgeByNum);
    }
    public void addEdge(){
        JTextField label = new JTextField();
        JTextField weight = new JTextField();
        JComboBox vertexList = new JComboBox(graph.getVertices().toArray());
        JComboBox vertexList2 = new JComboBox(graph.getVertices().toArray());
        vertexList.insertItemAt("---select vertex---", 0);
        vertexList2.insertItemAt("---select vertex---", 0);
        vertexList.setSelectedIndex(0);
        vertexList2.setSelectedIndex(0);
        Object message[] = {
            "New Edge Label", label,
            "Edge weight (integer only)", weight,
            "Connection",
            vertexList, vertexList2
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", -1, -1);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if (vertexList.getSelectedIndex() == 0 || vertexList2.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(this, "Please select connection", "error", 2);
                    return;
                }
                int w = Integer.parseInt(weight.getText().trim());
                graph.addEdge(label.getText().trim(), w, (Vertex)vertexList.getSelectedItem(), (Vertex)vertexList2.getSelectedItem());
                System.out.println("added");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong", "error", 2);
            }
        } else {
            System.out.println("operation cancelled");
        }
    }
    public void addEdge(int n){
        JTextField label = new JTextField();
        JTextField weight = new JTextField();
        JComboBox vertexList = new JComboBox(graph.getVertices().toArray());
        JComboBox vertexList2 = new JComboBox(graph.getVertices().toArray());
        vertexList.insertItemAt("---select vertex---", 0);
        vertexList2.insertItemAt("---select vertex---", 0);
        vertexList.setSelectedIndex(0);
        vertexList2.setSelectedIndex(0);
        Object message[] = {
            "New Edge Number "+n+" Label", label,
            "Edge weight (integer only)", weight,
            "Connection",
            vertexList, vertexList2
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", -1, -1);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if (vertexList.getSelectedIndex() == 0 || vertexList2.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(this, "Please select connection", "error", 2);
                    return;
                }
                int w = Integer.parseInt(weight.getText().trim());
                graph.addEdge(label.getText().trim(), w, (Vertex)vertexList.getSelectedItem(), (Vertex)vertexList2.getSelectedItem());
                System.out.println("added");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong", "error", 2);
            }
        } else {
            System.out.println("operation cancelled");
        }
    }
    public void addVertex(){
        JTextField label = new JTextField();
        Object message[] = { 
            "New Vertex Label", label 
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", -1, -1);
        if (option == JOptionPane.OK_OPTION) {
            graph.addVertex(label.getText().trim());
            System.out.println("vertex added");
        } else {
            System.out.println("operation cancelled");
        }
    }
    public void addVertex(int n){
        JTextField label = new JTextField();
        Object message[] = { 
             "Vertex number "+n+" Label", 
             label
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", -1, -1);
        if (option == JOptionPane.OK_OPTION) {
            graph.addVertex(label.getText().trim());
            System.out.println("vertex added");
        } else {
            System.out.println("operation cancelled");
        }
    }
}

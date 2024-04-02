import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import java.lang.Exception;
import java.util.ArrayList;

public class GraphBuilding extends Panel
{
    private JButton e = new JButton("exit");
    private JButton c = new JButton("continue");
    // window title bar
    private int insets;
    // graph
    private Graph graph;
    private JButton b_addVertex = new JButton("+");
    private JButton b_removeVertex = new JButton("-");
    private JButton b_addEdge = new JButton("+");
    private JButton b_removeEdge = new JButton("-");
    private JButton b_addVertexByNum = new JButton("add by number");
    private JButton b_addEdgeByNum = new JButton("add by number");
    private JButton b_preset = new JButton("Preset graph");
    private JButton b_clear = new JButton("Clear");
    // Label 
    private JLabel l_vertices = new JLabel("Vertices");
    private JLabel l_edges = new JLabel("Edges");
    private JLabel l_vertices2 = new JLabel("add or remove vertices");
    private JLabel l_edges2 = new JLabel("add or remove edges");

    public GraphBuilding(JFrame frame){
        super();
        graph = new Graph();
        this.insets = height-frame.getInsets().top;
        buildComponents(frame);
    }
    public GraphBuilding(JFrame frame, Graph graph){
        super();
        this.graph = graph;
        this.insets = height-frame.getInsets().top;
        buildComponents(frame);
    }
    // button and Label are handling here
    private void buildComponents(JFrame frame){
        e.addActionListener((e) -> {
            this.setVisible(false);
            frame.add(new Menu(frame));
            frame.remove(this);
        });
        e.setBounds(10, insets-35, 60, 30);
        e.setVisible(true);
        c.addActionListener((e) -> {
            this.setVisible(false);
            frame.add(new Algorithm(frame, graph));
            frame.remove(this);
        });
        c.setBounds(1150, insets-35, 120, 30);
        c.setVisible(true);


        // graph button
        // add single vertex
        b_addVertex.addActionListener((e) -> addVertex());
        b_addVertex.setBounds(900, 80, 50, 30);
        b_addVertex.setVisible(true);

        // remove vertex
        b_removeVertex.addActionListener((e) -> removeVertex());
        b_removeVertex.setBounds(960, 80, 50, 30);
        b_removeVertex.setVisible(true);

        // add mutiple vertices
        b_addVertexByNum.addActionListener((e) -> {
            try {
                JTextField numField = new JTextField();
                Object message[] = {
                    "input number of vertex you need to add",
                    numField
                };
                int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", 2, -1);
                if (option == JOptionPane.OK_OPTION){ 
                    int num = Integer.parseInt(numField.getText());
                    for (int i=1; i<= num; ++i){
                        addVertex(i);
                    }
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Please Input only number", "error", 2);
            }
        });
        b_addVertexByNum.setBounds(1020, 80, 130, 30);
        b_addVertexByNum.setVisible(true);

        // add single edge
        b_addEdge.addActionListener((e) -> addEdge());
        b_addEdge.setBounds(900, 220, 50, 30);
        b_addEdge.setVisible(true);

        // remove edge
        b_removeEdge.addActionListener((e) -> removeEdge());
        b_removeEdge.setBounds(960, 220, 50, 30);
        b_removeEdge.setVisible(true);

        // add mutiple edges
        b_addEdgeByNum.addActionListener((e) -> {
            try {
                JTextField numField = new JTextField();
                Object message[] = {
                    "input number of edge you need to add",
                    numField
                };
                int option = JOptionPane.showConfirmDialog(this, message, "Add Edge", 2, -1);
                if (option == JOptionPane.OK_OPTION){ 
                    int num = Integer.parseInt(numField.getText());
                    for (int i=1; i<= num; ++i){
                        addEdge(i);
                    }
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Please Input only number", "error", 2);
            }
        });
        b_addEdgeByNum.setBounds(1020, 220, 130, 30);
        b_addEdgeByNum.setVisible(true);

        // preset button
        b_preset.addActionListener((e) -> {
            graph.p1();
            verticesPane();
            edgesPane();
        });
        b_preset.setBounds(609, 580, 130, 30);
        b_preset.setVisible(true);

        // clear button 
        b_clear.addActionListener((e) -> {
            graph.getVertices().clear();
            graph.getEdges().clear();
            verticesPane();
            edgesPane();
        });
        b_clear.setBounds(519, 580, 80, 30);
        b_clear.setVisible(true);

        // set Label
        l_vertices.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        l_vertices.setBounds(59, 10, 200, 25);

        l_edges.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        l_edges.setBounds(59, 295, 200, 30);

        l_vertices2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        l_vertices2.setBounds(900, 55, 300, 25);

        l_edges2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        l_edges2.setBounds(900, 195, 300, 30);
        // add button to panel
        this.add(e);
        this.add(b_addVertex);
        this.add(c);
        this.add(b_addVertexByNum);
        this.add(b_addEdge);
        this.add(b_addEdgeByNum);
        this.add(b_removeVertex);
        this.add(b_removeEdge);
        this.add(l_vertices);
        this.add(l_edges);
        this.add(l_vertices2);
        this.add(l_edges2);
        this.add(b_preset);
        this.add(b_clear);
        verticesPane();
        edgesPane();
    }
    @SuppressWarnings("unchecked")
    private void addEdge(){
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
        int option = JOptionPane.showConfirmDialog(this, message, "Add Edge", 2, -1);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if (vertexList.getSelectedIndex() == 0 || vertexList2.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(this, "Please select connection", "error", 2);
                    return;
                }
                int w = Integer.parseInt(weight.getText().trim());
                Vertex v1 = (Vertex)vertexList.getSelectedItem();
                Vertex v2 = (Vertex)vertexList2.getSelectedItem();
                String strLabel = label.getText().trim();
                // in case of conect to itself
                if (v1 == v2){
                    System.out.println(strLabel);
                    if (!graph.addEdge(strLabel, w, v1)){
                        JOptionPane.showMessageDialog(this, v1+" is already connected to itself", "failed", 2); 
                    }
                    verticesPane();
                    edgesPane();
                    return;
                }
                if (!graph.addEdge(strLabel, w, v1, v2)){
                    JOptionPane.showMessageDialog(this, v1+" and "+v2+" are already connected", "failed", 2); 
                }
                System.out.println("added");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong", "error", 2);
            }
        } else {
            System.out.println("operation cancelled");
        }
        verticesPane();
        edgesPane();
    }
    @SuppressWarnings("unchecked")
    private void addEdge(int n){
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
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", 2, -1);
        if (option == JOptionPane.OK_OPTION) {
            try {
                if (vertexList.getSelectedIndex() == 0 || vertexList2.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(this, "Please select connection", "error", 2);
                    return;
                }
                int w = Integer.parseInt(weight.getText().trim());
                Vertex v1 = (Vertex)vertexList.getSelectedItem();
                Vertex v2 = (Vertex)vertexList2.getSelectedItem();
                String strLabel = label.getText().trim();
                // in case of conect to itself
                if (v1 == v2){
                    if (!graph.addEdge(strLabel, w, v1)){
                        JOptionPane.showMessageDialog(this, v1+" is already connected to itself", "failed", 2); 
                    }
                    verticesPane();
                    edgesPane();
                    return;
                }
                if (!graph.addEdge(strLabel, w, v1, v2)){
                    JOptionPane.showMessageDialog(this, v1+" and "+v2+" are already connected", "failed", 2); 
                }
                System.out.println("added");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong", "error", 2);
            }
        } else {
            System.out.println("operation cancelled");
        }
        verticesPane();
        edgesPane();
    }
    private void addVertex(){
        JTextField label = new JTextField();
        Object message[] = { 
            "New Vertex Label", label 
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", 2, -1);
        if (option == JOptionPane.OK_OPTION) {
            graph.addVertex(label.getText().trim());
            System.out.println("vertex added");
        } else {
            System.out.println("operation cancelled");
        }
        verticesPane();
        edgesPane();
    }
    private void addVertex(int n){
        JTextField label = new JTextField();
        Object message[] = { 
             "Vertex number "+n+" Label", 
             label
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add Vertex", 2, -1);
        if (option == JOptionPane.OK_OPTION) {
            graph.addVertex(label.getText().trim());
            System.out.println("vertex added");
        } else {
            System.out.println("operation cancelled");
        }
        verticesPane();
        edgesPane();
    }
    @SuppressWarnings("unchecked")
    private void removeVertex(){
        JComboBox vertexList = new JComboBox(graph.getVertices().toArray());
        vertexList.insertItemAt("---select vertex---", 0);
        vertexList.setSelectedIndex(0);
        Object message[] = {
            "Select vertex to remove",
            vertexList
        };
        int option = JOptionPane.showConfirmDialog(this, message, "remove vertex", 2, -1);
        if (option == JOptionPane.OK_OPTION){
            if (vertexList.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, "Please select vertex to remove", "error", 2);
                return;
            }
            graph.removeVertex((Vertex)vertexList.getSelectedItem()); 
            System.out.println("remove "+vertexList.getSelectedItem());
        }else if (option == JOptionPane.CANCEL_OPTION){
            System.out.println();
        }
        verticesPane();
        edgesPane();
    }
    @SuppressWarnings("unchecked")
    private void removeEdge(){
        JComboBox edgeList = new JComboBox(graph.getEdges().toArray());
        edgeList.insertItemAt("---select edge---", 0);
        edgeList.setSelectedIndex(0);
        Object message[] = {
            "Select egde to remove",
            edgeList 
        };
        int option = JOptionPane.showConfirmDialog(this, message, "remove vertex", 2, -1);
        if (option == JOptionPane.OK_OPTION){
            if (edgeList.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, "Please select edge to remove", "error", 2);
                return;
            }
            graph.removeEdge((Edge)edgeList.getSelectedItem());
            System.out.println("remove "+edgeList.getSelectedItem());
        }else if (option == JOptionPane.CANCEL_OPTION){
            System.out.println();
        }
        verticesPane();
        edgesPane();
    }

    JScrollPane sp = new JScrollPane();
    JScrollPane ssp = new JScrollPane();
    private void verticesPane(){
        sp.setViewportView((Component)new Table(graph).verticesTable());
        sp.setBounds(59, 40, 680, 250);
        this.add(sp);
    }
    private void edgesPane(){
        ssp.setViewportView((Component)new Table(graph).edgesTable());
        ssp.setBounds(59, 325, 680, 250);
        this.add(ssp);
    }
    
}

import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
// public class Test
// {
// public static void main(String args[]){
// new MainFrame();
// }
// }

public class Test{
    public static void main(String args[]){
        JFrame frame = new JFrame();

        // String[] columnNames = {"Name", "Age", "Student"};
// 
        // String[][] data = {
            // {"Ken", "m\nnm", "new Boolean(false)"},
            // {"", "mm", "new Boolean(false)"},
            // {"_____","_____","_____"},
            // {"Tom", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"_____","_____","_____"},
            // {"Tom", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"_____","_____","_____"},
            // {"Tom", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"_____","_____","_____"},
            // {"Tom", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
            // {"", "new Integer(3)", "new Boolean(true)"},
        // };
        Graph g = new Graph();
        g.p1();
        ArrayList<Vertex> vertices;    
        ArrayList<Edge> edges;
        vertices = g.getVertices();
        edges = g.getEdges();
        Object columnName[] = {"Label", "degree", "edges", "connection"}; 
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        String arr[] = null;
        for (Vertex v : vertices){
            if ( v.getDegree() == 0 ){
                arr = new String[] {v.getLabel(), ""+v.getDegree()};
                data.add(new ArrayList(Arrays.asList(arr)));
                arr = new String[] {"_______","_______","_______","_______"};
                data.add(new ArrayList(Arrays.asList(arr)));
                continue;
            }
            arr = new String[] {v.getLabel(), ""+v.getDegree(), v.getEdges().get(0).getLabel(), v.getConnection().get(0).getLabel()};
            data.add(new ArrayList(Arrays.asList(arr)));
            for (int i=1; i<v.getDegree(); ++i){
                arr = new String[]{"", "", v.getEdges().get(i).getLabel(), v.getConnection().get(i).getLabel()};
                data.add(new ArrayList(Arrays.asList(arr)));
            }
            arr = new String[]{"_______","_______","_______","_______"};
            data.add(new ArrayList(Arrays.asList(arr)));
        }
        String[][] newData = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        // String[] ars = (String[])data.toArray();
        for (String[] a : newData){
            System.out.println(Arrays.toString(a));
        }
        JTable table = new JTable(newData, columnName);
        table.setModel(new DefaultTableModel(newData, columnName){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.setShowHorizontalLines(false);

        JScrollPane panel = new JScrollPane(table); 
        panel.setBounds(0, 0, 400, 400);
        panel.setAutoscrolls(false);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
    }
}

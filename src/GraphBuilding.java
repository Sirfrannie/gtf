import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class GraphBuilding extends Panel
{
    private JButton e = new JButton("exit");
    private Graph graph;
    public GraphBuilding(JFrame frame){
        super();
        e.addActionListener((e) -> {
            this.setVisible(false);
            frame.add(new Menu(frame));
            frame.remove(this);
        });
        e.setBounds(10, (int)(height-frame.getInsets().top-35), 60, 30);
        e.setVisible(true);
        this.add(e);
    }
    private void addVertex(){

    }
}

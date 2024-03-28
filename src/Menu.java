import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Dimension;
public class Menu extends Panel 
{
    public JButton g = new JButton("Graph");
    public JButton f = new JButton("Finite-State Automata");
    public JButton e = new JButton("exit");
    public Menu(JFrame frame){
        super();
        // graph button
        g.addActionListener((e)-> {
            this.setVisible(false);
            frame.add(new GraphBuilding(frame));
            frame.remove(this);
        }); 
        g.setBounds((int)(width/2)-125, (int)(height/2)-70, 250, 60);
        g.setVisible(true);

        // finite-stage button
        f.addActionListener((e)-> {
            this.setVisible(false);
            frame.add(new FinitePanel(frame));
            frame.remove(this);
        }); 
        f.setBounds((int)(width/2)-125, (int)(height/2)+10, 250, 60);
        f.setVisible(true);

        // exit button
        e.addActionListener((e) -> {
            frame.dispose();
        });
        e.setBounds(10, (int)(height-frame.getInsets().top-35), 60, 30);
        e.setVisible(true);

        // addButton to panel
        this.add(e);
        this.add(g);
        this.add(f);

    }
}

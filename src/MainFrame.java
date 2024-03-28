import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
public class MainFrame extends JFrame
{
    public JButton b = new JButton("hello");
    public MainFrame(){
        this.setTitle("My lovely App");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1280, 720));
        this.setLayout(new GridLayout(1, 1, 0, 0));
        this.setResizable(false);

        this.add(new Menu(this));
        

        this.setVisible(true);
    }
}

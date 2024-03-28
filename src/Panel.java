import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.Dimension;
public class Panel extends JPanel
{
    protected int height = 720;
    protected int width = 1280;
    public Panel(){
        this.setBounds(0, 0, width, height);
        this.setLayout(null);
    }
}

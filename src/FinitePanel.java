import javax.swing.JFrame;
import javax.swing.JButton;
public class FinitePanel extends Panel
{
    private JButton e = new JButton("exit");
    public FinitePanel(JFrame frame){
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
}

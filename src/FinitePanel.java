import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Exception;
public class FinitePanel extends Panel
{
    private JButton e = new JButton("exit");
    private JButton b_submit = new JButton("submit");
    private JTextField inputField = new JTextField();

    private JLabel l_input = new JLabel("input binary (ex. 001100101)");
    private JLabel imageLabel;
    private BufferedImage image;
    public FinitePanel(JFrame frame){
        super();
        e.addActionListener((e) -> {
            this.setVisible(false);
            frame.add(new Menu(frame));
            frame.remove(this);
        });
        e.setBounds(10, (int)(height-frame.getInsets().top-35), 60, 30);
        e.setVisible(true);

        inputField.setBounds((int)(width/2)-200, 400, 400, 35);
        inputField.setVisible(true);

        l_input.setBounds((int)(width/2)-200, 360, 400, 50);
        l_input.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        b_submit.addActionListener((e)->{
            String input = inputField.getText().trim();
            boolean enable = true;
            // checking input content
            for (int i=0; i<input.length(); ++i){
                if (input.charAt(i) == '0' || input.charAt(i) == '1'){
                } else {
                    JOptionPane.showConfirmDialog(this, "invalid input" , "error", 2, -1); 
                    enable = false;
                    break;
                }
            }
            if (enable){
                boolean result = new FiniteAutomata().isAccepted(input);
                if (result){
                    String[] message = {
                        "input: "+input,
                        "result: Accepted"
                    };
                    JOptionPane.showMessageDialog(this, message);
                }else{
                    String[] message = {
                        "input: "+input,
                        "result: Accepted"
                    };
                    JOptionPane.showMessageDialog(this, message);
                }
            }

        });
        b_submit.setBounds((int)(width/2)-40, 440, 80, 30);
        b_submit.setVisible(true);

        try{
            image = ImageIO.read(new File("image/state.jpg"));
            image = ImageResizer.resize(image, 600, 300);
        }catch (Exception e){
        }
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(340, 20, 600, 300);
        imageLabel.setVisible(true);


        this.add(inputField);
        this.add(b_submit);
        this.add(l_input);
        this.add(e);
        this.add(imageLabel);
    }
}

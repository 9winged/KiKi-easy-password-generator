import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.GridLayout;

public class GUI
{

    public GUI()
    {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createBevelBorder(30, Color.CYAN, Color.BLACK));
        panel.setBorder((Border) new GridLayout(1, 2));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("KEY KEY");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        new GUI();
    }
}

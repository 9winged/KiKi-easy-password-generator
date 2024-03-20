import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.Accessible;

public class GUI implements ActionListener {

    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;

    public GUI()
    {

        frame = new JFrame();

        JButton button = new JButton("Start");
        label = new JLabel("Number of clicks: 0");
        button.addActionListener(this);


        panel = new JPanel();
        panel.setBorder(BorderFactory.createBevelBorder(30, Color.CYAN, Color.BLACK));
        panel.setLayout(new GridLayout(1, 2));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("KiKi");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        count++;
        label.setText("Number of clicks:" + count);
    }



}

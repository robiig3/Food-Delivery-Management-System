package presentation;

import javax.swing.*;
import java.awt.*;

public class FailureWindow {

    public JFrame frame;

    public FailureWindow(){

        frame = new JFrame();
        frame.setTitle("Failure Window");

        frame.setSize(400,250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JLabel label = new JLabel("The operation was a failure! :)");
        label.setBounds(100, 75, 300, 50);
        panel.add(label);

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}

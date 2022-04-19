package presentation.employee;

import presentation.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeView {

    public JFrame frame;

    public EmployeeView(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EMPLOYEE LOGIN");

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JLabel label1 = new JLabel("Username: ");
        label1.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        label1.setBounds(200, 150, 120, 30);
        JTextField tf1 = new JTextField(30);
        tf1.setBounds(320, 150, 300, 30);
        JLabel label2 = new JLabel("Password: ");
        label2.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        label2.setBounds(200, 250, 120, 30);
        JTextField tf2 = new JTextField(30);
        tf2.setBounds(320, 250, 300, 30);
        JButton butt = new JButton("Login");
        butt.setBounds(250, 350, 100, 50);
        JButton buttBack = new JButton("Back");
        buttBack.setBounds(450, 350, 100, 50);

        panel.add(label1);
        panel.add(tf1);
        panel.add(label2);
        panel.add(tf2);
        panel.add(butt);
        panel.add(buttBack);

        buttBack.addActionListener(e -> {
            frame.setVisible(false);
            View view = new View();
            view.frame.setVisible(true);
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

}

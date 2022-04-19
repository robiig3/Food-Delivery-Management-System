package presentation;

import presentation.admin.AdministratorView;
import presentation.client.ClientView;
import presentation.employee.EmployeeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends Panel {

    public JFrame frame;

    public View() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        ImageIcon icon = new ImageIcon("src/presentation/delivery.jpg");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(600, 350, Image.SCALE_SMOOTH);
        icon.setImage(newImg);

        JLabel label = new JLabel(icon);
        label.setBounds(100, 0, 600, 350);
        panel.add(label);

        JButton buttAdm = new JButton("Admin");
        JButton buttClient = new JButton("Client");
        JButton buttEmployee = new JButton("Employee");
        buttAdm.setBounds(200, 350, 100, 50);
        buttClient.setBounds(350, 350, 100, 50);
        buttEmployee.setBounds(500, 350, 100, 50);
        panel.add(buttAdm);
        panel.add(buttClient);
        panel.add(buttEmployee);

        buttAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AdministratorView view = new AdministratorView();
                view.frame.setVisible(true);
            }
        });

        buttClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ClientView view = new ClientView();
                view.frame.setVisible(true);
            }
        });

        buttEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                EmployeeView view = new EmployeeView();
                view.frame.setVisible(true);
            }
        });



        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

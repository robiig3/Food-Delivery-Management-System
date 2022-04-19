package presentation.client;

import business.DeliveryService;
import data.Serializator;
import model.Account;
import presentation.FailureWindow;
import presentation.View;
import presentation.admin.AdministratorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientView {

    public JFrame frame;
    List<Account> clientList;

    public ClientView(){

        clientList = Serializator.ClientListDeserialization("src/data/clientsData.csv");
        for(Account account : clientList) System.out.println(account.toString());

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CLIENT LOGIN");

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton AlreadyRegistered = new JButton("ALREADY REGISTERED?");
        AlreadyRegistered.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        AlreadyRegistered.setBounds(175, 50, 200, 50);
        JButton createAnAccount = new JButton("CREATE AN ACCOUNT");
        createAnAccount.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        createAnAccount.setBounds(475, 50, 200, 50);
        JButton buttBack = new JButton("Back");
        buttBack.setBounds(650, 400, 100, 50);

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
        JButton buttLOGIN = new JButton("Login");
        buttLOGIN.setBounds(350, 350, 100, 50);
        JButton buttREGISTER = new JButton("Register");
        buttREGISTER.setBounds(350, 350, 100, 50);

        panel.add(label1);
        panel.add(tf1);
        panel.add(label2);
        panel.add(tf2);
        panel.add(AlreadyRegistered);
        panel.add(createAnAccount);
        panel.add(buttBack);
        panel.add(buttREGISTER);
        panel.add(buttLOGIN);
        label1.setVisible(false);
        tf1.setVisible(false);
        label2.setVisible(false);
        tf2.setVisible(false);
        buttREGISTER.setVisible(false);
        buttLOGIN.setVisible(false);

        createAnAccount.addActionListener(e -> {

            label1.setVisible(true);
            tf1.setVisible(true);
            label2.setVisible(true);
            tf2.setVisible(true);
            buttREGISTER.setVisible(true);
            buttLOGIN.setVisible(false);
            frame.setContentPane(panel);
        });

        buttREGISTER.addActionListener(e -> {

            Account acc = new Account(tf1.getText(), tf2.getText());
            clientList.add(acc);
            Serializator.ClientListSerialization(clientList, "src/data/clientsData.csv");

        });

        AlreadyRegistered.addActionListener(e -> {

            label1.setVisible(true);
            tf1.setVisible(true);
            label2.setVisible(true);
            tf2.setVisible(true);
            buttLOGIN.setVisible(true);
            buttREGISTER.setVisible(false);
            frame.setContentPane(panel);
        });

        buttLOGIN.addActionListener(e -> {

            //cand n-am chef sa introduc date
//            frame.setVisible(false);
//            ClientOperations view = new ClientOperations();
//            view.frame.setVisible(true);

            boolean ok = false;

            clientList = Serializator.ClientListDeserialization("src/data/clientsData.csv");
            Account clientToLogin = null;
            if(!clientList.isEmpty())
                for(Account a : clientList) {
                    if(a.getUsername().equals(tf1.getText()) && a.getPassword().equals(tf2.getText())){
                        ok = true;
                        clientToLogin = a;
                        break;
                    }
                }

            if(!ok){
                FailureWindow view = new FailureWindow();
                view.frame.setVisible(true);
            }else{
                frame.setVisible(false);
                ClientOperations view = new ClientOperations(clientToLogin);
                view.frame.setVisible(true);
            }

        });

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

package presentation.admin;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import data.Serializator;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class GenerateReports {

    public JFrame frame;

    public GenerateReports(DeliveryService ds){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GENERATE REPORTS");

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton buttBack = new JButton("Back");
        buttBack.setBounds(650, 400, 100, 50);
        panel.add(buttBack);

        JButton generateButt = new JButton("Click here to GENERATE");
        generateButt.setBounds(300, 400, 200, 50);
        panel.add(generateButt);

        JLabel l1 = new JLabel("Start hour: ");
        l1.setBounds(250, 10, 300, 30);
        JTextField tf1 = new JTextField(300);
        tf1.setBounds(250, 40, 300, 30);
        JLabel l2 = new JLabel("End hour: ");
        l2.setBounds(250, 70, 300, 30);
        JTextField tf2 = new JTextField(300);
        tf2.setBounds(250, 100, 300, 30);
        JLabel l3 = new JLabel("Number for products report: ");
        l3.setBounds(250, 130, 300, 30);
        JTextField tf3 = new JTextField(300);
        tf3.setBounds(250, 160, 300, 30);
        JLabel l4 = new JLabel("Number for clients report: ");
        l4.setBounds(250, 190, 300, 30);
        JTextField tf4 = new JTextField(300);
        tf4.setBounds(250, 220, 300, 30);
        JLabel l5 = new JLabel("Minim value of the order: ");
        l5.setBounds(250, 250, 300, 30);
        JTextField tf5 = new JTextField(300);
        tf5.setBounds(250, 280, 300, 30);
        JLabel l6 = new JLabel("The day for the products report: ");
        l6.setBounds(250, 310, 300, 30);
        JTextField tf6 = new JTextField(300);
        tf6.setBounds(250, 340, 300, 30);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(tf1);
        panel.add(tf2);
        panel.add(tf3);
        panel.add(tf4);
        panel.add(tf5);
        panel.add(tf6);

        generateButt.addActionListener(e -> {

            FileWriter fileWriter;

            try {
                fileWriter = new FileWriter("src/data/generatedReport.txt");

                fileWriter.write("GENERATED REPORTS\n");

                fileWriter.write("-> The orders performed between given start hour " + tf1.getText() + " and given end hour " + tf2.getText() + " : ");
                StringBuilder stringBuilder = new StringBuilder();

                List<Order> orderList = new ArrayList<>();
                ds.ordersInformations = Serializator.OrderDeserialization("src/data/orders.csv");
                ds.ordersInformations.forEach((key, value) -> orderList.add(key));
                orderList.stream().filter(order -> order.getDate().getHour() >= Integer.parseInt(tf1.getText()) && order.getDate().getHour() <= Integer.parseInt(tf2.getText())).forEach(order -> stringBuilder.append(order.getOrderId()).append(", "));

                fileWriter.write(stringBuilder.toString());


                fileWriter.write("\n-> The products ordered more than " + tf3.getText() + " times so far : ");
                StringBuilder stringBuilder2 = new StringBuilder();

                List<MenuItem> menuItemsFromOrders = new ArrayList<>();
                ds.ordersInformations.forEach((key, value) -> menuItemsFromOrders.addAll(value));
                menuItemsFromOrders.forEach(MenuItem::setOrderedTimes);
                menuItemsFromOrders.stream().filter(menuItem -> menuItem.getOrderedTimes() >= Integer.parseInt(tf3.getText())).forEach(menuItem -> stringBuilder2.append(menuItem.getTitle()).append(", "));
                fileWriter.write(stringBuilder2.toString());


                fileWriter.write("\n-> The clients that have ordered more than " + tf4.getText() + " times and the value of the order was higher than " + tf5.getText() + " : ");
                StringBuilder stringBuilder3 = new StringBuilder();

                List<Account> accountsList = Serializator.ClientListDeserialization("src/data/clientsData.csv");
                accountsList.stream().filter(account -> account.getOrdersNumber() > Integer.parseInt(tf4.getText())).forEach(account -> stringBuilder3.append(account.getUsername()).append(", "));
                fileWriter.write(stringBuilder3.toString());

                fileWriter.write("\n-> The products ordered within " + tf6.getText() + " : ");
                StringBuilder stringBuilder4 = new StringBuilder();

                menuItemsFromOrders.clear();

                for (Map.Entry<Order, List<MenuItem>> entry : ds.ordersInformations.entrySet()) {
                   if(entry.getKey().getDate().getDayOfWeek().toString().equals(tf1.getText().toUpperCase(Locale.ROOT))){
                       menuItemsFromOrders.add((MenuItem) entry.getValue());
                   }
                }

                menuItemsFromOrders.stream().distinct().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getTitle))), ArrayList::new)).forEach(menuItem -> stringBuilder4.append(menuItem.getTitle()).append(", "));
                fileWriter.write(stringBuilder4.toString());

                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });

        buttBack.addActionListener(e -> {
            frame.setVisible(false);
            AdministratorOperations view = new AdministratorOperations();
            view.frame.setVisible(true);
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

}

package presentation.client;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import data.Serializator;
import model.Account;
import presentation.ProductsTable;
import presentation.SuccesWindow;
import presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientOperations {

    public JFrame frame;

    ClientOperations(Account client){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CLIENT OPERATIONS");

        frame.setSize(1000,700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton buttBack = new JButton("Back");
        buttBack.setBounds(850, 600, 100, 50);
        panel.add(buttBack);

        JLabel label = new JLabel("Here you can select the base products you want:");
        label.setBounds(5, 5, 500, 30);
        panel.add(label);

        List<MenuItem> menu = Serializator.MenuDeserialization("src/data/menu.csv");

        ProductsTable table = new ProductsTable(menu);

        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(5,40,600,245);
        panel.add(scrollPane);

        JLabel label1 = new JLabel("Filter after title:");
        JTextField tf1 = new JTextField(100);
        label1.setBounds(625, 40, 150, 30);
        tf1.setBounds(775, 40, 200, 30);
        JLabel label2 = new JLabel("Filter after rating:");
        JTextField tf2 = new JTextField(100);
        label2.setBounds(625, 75, 150, 30);
        tf2.setBounds(775, 75, 200, 30);
        JLabel label3 = new JLabel("Filter after calories:");
        JTextField tf3 = new JTextField(100);
        label3.setBounds(625, 105, 150, 30);
        tf3.setBounds(775, 105, 200, 30);
        JLabel label4 = new JLabel("Filter after protein:");
        JTextField tf4 = new JTextField(100);
        label4.setBounds(625, 140, 150, 30);
        tf4.setBounds(775, 140, 200, 30);
        JLabel label5 = new JLabel("Filter after fat:");
        JTextField tf5 = new JTextField(100);
        label5.setBounds(625, 175, 150, 30);
        tf5.setBounds(775, 175, 200, 30);
        JLabel label6 = new JLabel("Filter after sodium:");
        JTextField tf6 = new JTextField(100);
        label6.setBounds(625, 210, 150, 30);
        tf6.setBounds(775, 210, 200, 30);
        JLabel label7 = new JLabel("Filter after price:");
        JTextField tf7 = new JTextField(100);
        label7.setBounds(625, 245, 150, 30);
        tf7.setBounds(775, 245, 200, 30);

        panel.add(label1);
        panel.add(tf1);
        panel.add(label2);
        panel.add(tf2);
        panel.add(label3);
        panel.add(tf3);
        panel.add(label4);
        panel.add(tf4);
        panel.add(label5);
        panel.add(tf5);
        panel.add(label6);
        panel.add(tf6);
        panel.add(label7);
        panel.add(tf7);

        tf1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //table.newMenuFilter(table.sorter, tf1.getText(), 0);
                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 0);
                table.refreshTable(menuItemListWithFilter);
                table.productsTable.revalidate();
                table.productsTable.updateUI();
                scrollPane.setViewportView(table.productsTable);
                scrollPane.revalidate();
                scrollPane.updateUI();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf2.getText(), 1);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 1);
//                table.refreshTable(menuItemListWithFilter);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf3.getText(), 2);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 2);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf4.getText(), 3);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 3);
//                table.refreshTable(menuItemListWithFilter);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf5.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf5.getText(), 4);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 4);
//                table.refreshTable(menuItemListWithFilter);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf6.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf6.getText(), 5);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 5);
//                table.refreshTable(menuItemListWithFilter);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tf7.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                table.newMenuFilter(table.sorter, tf7.getText(), 6);
//                List<MenuItem> menuItemListWithFilter = ProductsTable.newMenuFilter2(menu, tf1.getText(), 6);
//                table.refreshTable(menuItemListWithFilter);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JLabel label0 = new JLabel("Here you can select the daily menus you want:");
        label0.setBounds(5, 290, 500, 30);
        panel.add(label0);

        List<MenuItem> dailyMenu = Serializator.MenuDeserialization("src/data/dailyMenu.csv");

        ProductsTable dailyMenuTable = new ProductsTable(dailyMenu);

        dailyMenuTable.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane2 = new JScrollPane(dailyMenuTable.productsTable);
        scrollPane2.setBounds(5,325,600,200);
        panel.add(scrollPane2);


        final int[] rowBaseProducts = new int[1];

        table.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowBaseProducts[0] = table.productsTable.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        final int[] rowDailyMenu = new int[1];

        dailyMenuTable.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowDailyMenu[0] = dailyMenuTable.productsTable.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton addBaseProduct = new JButton("Add base product to your basket");
        addBaseProduct.setBounds(625, 325, 300, 50);
        panel.add(addBaseProduct);
        JButton addDailyMenu = new JButton("Add daily menu to your basket");
        addDailyMenu.setBounds(625, 380, 300, 50);
        panel.add(addDailyMenu);
        JButton basketButton = new JButton("Click here to see your basket");
        basketButton.setBounds(625, 435, 300, 50);
        panel.add(basketButton);
        JButton placeTheOrder = new JButton("Click here to the order");
        placeTheOrder.setBounds(625, 500, 300, 50);
        panel.add(placeTheOrder);

        List<MenuItem> basketList = new ArrayList<>();

        addBaseProduct.addActionListener(e -> {

            String baseProductTitle = (String) table.productsTable.getValueAt(rowBaseProducts[0], 0);
            for(MenuItem m : menu){
                if(m.getTitle().equals(baseProductTitle)){
                    basketList.add(m);
                    break;
                }
            }
            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);
        });

        addDailyMenu.addActionListener(e -> {

            String dailyMenuTitle = (String) dailyMenuTable.productsTable.getValueAt(rowDailyMenu[0], 0);
            for(MenuItem m : dailyMenu){
                if(m.getTitle().equals(dailyMenuTitle)){
                    basketList.add(m);
                    break;
                }
            }
            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);
        });

        basketButton.addActionListener(e -> {
            Basket basketView = new Basket(basketList);
            basketView.frame.setVisible(true);
        });

        placeTheOrder.addActionListener(e -> {

            DeliveryService ds = new DeliveryService();
            int totalPrice = 0;
            for(MenuItem m : basketList) totalPrice += m.computePrice();

            Order order = new Order(client.getAccountId(), totalPrice);
            ds.ordersInformations.put(order,basketList);
            System.out.println(ds.ordersInformations);
            System.out.println("-----\n ORDER ID : " + order.getOrderId() + " -> " +  ds.ordersInformations.get(order));

            Serializator.OrderSerialization(ds.ordersInformations, "src/data/orders.csv");
            Serializator.DeliveryServiceSerialization(ds, "src/data/deliveryService.csv");

            try {
                FileWriter fileWriter = new FileWriter("src/data/bill.txt");
                fileWriter.write("----- BILL -----\n");
                fileWriter.write("> Client username: " + client.getUsername() + "\n\n");
                fileWriter.write("> PRODUCTS: \n");
                for(MenuItem m : basketList) fileWriter.write(m.getTitle() + "\n");
                fileWriter.write("\n> Total price : " + totalPrice + "\n");
                fileWriter.write("\n> Date: " + order.getDate().toString() + "\n");
                fileWriter.write("\n    have a nice day! :) ");

                fileWriter.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);
        });

        buttBack.addActionListener(e -> {
            frame.setVisible(false);
            ClientView view = new ClientView();
            view.frame.setVisible(true);
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

}
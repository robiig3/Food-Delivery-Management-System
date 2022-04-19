package presentation.admin;

import business.DeliveryService;
import business.MenuItem;
import data.Serializator;
import presentation.SuccesWindow;
import presentation.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdministratorOperations {

    public JFrame frame;

    AdministratorOperations(){

        DeliveryService ds = Serializator.DeliveryServiceDeserialization("src/data/deliveryService.csv");

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ADMINISTRATOR OPERATIONS");

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton buttBack = new JButton("Back");
        buttBack.setBounds(650, 400, 100, 50);
        panel.add(buttBack);

        JButton importProducts = new JButton("Import Products");
        importProducts.setBounds(250, 50, 300, 50);
        JButton dailyMenu = new JButton("Daily Menu Operations");
        dailyMenu.setBounds(250, 150, 300, 50);
        JButton generateReports = new JButton("Generate Reports");
        generateReports.setBounds(250, 250, 300, 50);
        JButton productsOperations = new JButton("Products Oprations");
        productsOperations.setBounds(250, 350, 300, 50);

        panel.add(importProducts);
        panel.add(dailyMenu);
        panel.add(generateReports);
        panel.add(productsOperations);

        productsOperations.addActionListener(e ->{
            frame.setVisible(false);
            ProductsOperations view = new ProductsOperations();
            view.frame.setVisible(true);
        });

        importProducts.addActionListener(e -> {
            ds.menu = ds.ImportProducts();

            Serializator.MenuSerialization(ds.menu, "src/data/menu.csv");

            SuccesWindow succ = new SuccesWindow();
            succ.frame.setVisible(true);
        });

        dailyMenu.addActionListener(e -> {
            frame.setVisible(false);
            DailyMenuOperations view = new DailyMenuOperations(ds);
            view.frame.setVisible(true);

        });

        generateReports.addActionListener(e -> {
            frame.setVisible(false);
            GenerateReports view = new GenerateReports(ds);
            view.frame.setVisible(true);
        });

        buttBack.addActionListener(e -> {
            frame.setVisible(false);
            AdministratorView view = new AdministratorView();
            view.frame.setVisible(true);
        });

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}

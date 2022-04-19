package presentation.client;

import business.MenuItem;
import presentation.ProductsTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    public JFrame frame;
    public List<MenuItem> basket;
    public ProductsTable table;

    public Basket(List<MenuItem> basketList){

        basket = basketList;

        frame = new JFrame();
        frame.setTitle("YOUR BASKET ♡ ");

        frame.setSize(610,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        table = new ProductsTable(basket);

        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(5,5,600,245);
        panel.add(scrollPane);

        int totalPrice = 0;
        for(MenuItem m : basket) totalPrice += m.computePrice();

        JLabel totalPriceLabel = new JLabel("Total price: " + totalPrice);
        totalPriceLabel.setBounds(5, 260, 600, 30);
        panel.add(totalPriceLabel);

        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

    public static void printBasket(List<MenuItem> basketList){
        for(MenuItem m : basketList) System.out.println(m.getTitle());
    }

}

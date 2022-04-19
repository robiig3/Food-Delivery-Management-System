package presentation.admin;

import business.BaseProduct;
import business.DeliveryService;
import business.MenuItem;
import data.Serializator;
import presentation.ProductsTable;
import presentation.SuccesWindow;
import presentation.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.List;

public class ProductsOperations extends DeliveryService {

    public JFrame frame;

    public ProductsOperations(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PRODUCTS OPERATIONS");

        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton buttBack = new JButton("Back");
        buttBack.setBounds(650, 500, 100, 50);
        panel.add(buttBack);

        List<MenuItem> menu = Serializator.MenuDeserialization("src/data/menu.csv");

        ProductsTable table = new ProductsTable(menu);

        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(50,5,700,200);
        panel.add(scrollPane);

        JLabel label = new JLabel("Select the product you want to make operations on.");
        label.setBounds(50, 225, 700, 20);
        panel.add(label);

        JButton addProducts = new JButton("Add Product");
        addProducts.setBounds(50, 265, 200, 30);
        JButton deleteProducts = new JButton("Delete Product");
        deleteProducts.setBounds(300, 265, 200, 30);
        JButton modifyProducts = new JButton("Modify Product");
        modifyProducts.setBounds(550, 265, 200, 30);

        panel.add(addProducts);
        panel.add(deleteProducts);
        panel.add(modifyProducts);

        JLabel label2 = new JLabel("Here you can ADD the data for the new product / MODIFY the data for the product you selected to modify.");
        label2.setBounds(50, 320, 700, 20);
        panel.add(label2);

        JLabel l1 = new JLabel("Title");
        JLabel l2 = new JLabel("Rating");
        JLabel l3 = new JLabel("Calories");
        JLabel l4 = new JLabel("Protein");
        JLabel l5 = new JLabel("Fat");
        JLabel l6 = new JLabel("Sodium");
        JLabel l7 = new JLabel("Price");
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();
        JTextField tf6 = new JTextField();
        JTextField tf7 = new JTextField();
        l1.setBounds(50, 350, 100, 20);
        tf1.setBounds(150, 350, 400, 20);
        l2.setBounds(50, 380, 100, 20);
        tf2.setBounds(150, 380, 200, 20);
        l3.setBounds(450, 380, 100, 20);
        tf3.setBounds(550, 380, 200, 20);

        l4.setBounds(50, 410, 100, 20);
        tf4.setBounds(150, 410, 200, 20);
        l5.setBounds(450, 410, 100, 20);
        tf5.setBounds(550, 410, 200, 20);

        l6.setBounds(50, 440, 100, 20);
        tf6.setBounds(150, 440, 200, 20);
        l7.setBounds(450, 440, 100, 20);
        tf7.setBounds(550, 440, 200, 20);

        panel.add(tf1);
        panel.add(l1);
        panel.add(tf2);
        panel.add(l2);
        panel.add(tf3);
        panel.add(l3);
        panel.add(tf4);
        panel.add(l4);
        panel.add(tf5);
        panel.add(l5);
        panel.add(tf6);
        panel.add(l6);
        panel.add(tf7);
        panel.add(l7);

        final int[] row = new int[1];

        table.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                row[0] = table.productsTable.getSelectedRow();
                tf1.setText((String) table.productsTable.getValueAt(row[0], 0));
                tf2.setText((String) table.productsTable.getValueAt(row[0], 1));
                tf3.setText((String) table.productsTable.getValueAt(row[0], 2));
                tf4.setText((String) table.productsTable.getValueAt(row[0], 3));
                tf5.setText((String) table.productsTable.getValueAt(row[0], 4));
                tf6.setText((String) table.productsTable.getValueAt(row[0], 5));
                tf7.setText((String) table.productsTable.getValueAt(row[0], 6));
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

        addProducts.addActionListener(e -> {

            BaseProduct newProduct = new BaseProduct(tf1.getText(), Float.parseFloat(tf2.getText()), Integer.parseInt(tf3.getText()), Integer.parseInt(tf4.getText()), Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText()), Integer.parseInt(tf7.getText()));

            menu.add(newProduct);
            menu.sort(Comparator.comparing(MenuItem::getTitle));

            Serializator.MenuSerialization(menu, "src/data/menu.csv");

            table.refreshTable(menu);
            ((DefaultTableModel)table.productsTable.getModel()).fireTableDataChanged();

            for(int i=0; i<table.productsTable.getRowCount(); i++)
                System.out.println(table.productsTable.getValueAt(i, 0));


            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);
        });

        deleteProducts.addActionListener(e -> {

            menu.remove(row[0]);
            Serializator.MenuSerialization(menu, "src/data/menu.csv");
            ((DefaultTableModel)table.productsTable.getModel()).removeRow(row[0]);

            for(int i=0; i<table.productsTable.getRowCount(); i++)
                System.out.println(table.productsTable.getValueAt(i, 0));

            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);
        });

        modifyProducts.addActionListener(e -> {

            int row2 = table.productsTable.getSelectedRow();
            MenuItem selectedProduct = menu.get(row2);
            BaseProduct newProduct = new BaseProduct(tf1.getText(), Float.parseFloat(tf2.getText()), Integer.parseInt(tf3.getText()), Integer.parseInt(tf4.getText()), Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText()), Integer.parseInt(tf7.getText()));

            for(MenuItem a : menu){
                if(a.equals(selectedProduct)){
                    a.setTitle(newProduct.getTitle());
                    a.setRating(newProduct.getRating());
                    a.setCalories(newProduct.getCalories());
                    a.setProtein(newProduct.getProtein());
                    a.setFat(newProduct.getFat());
                    a.setSodium(newProduct.getSodium());
                    a.setPrice(newProduct.computePrice());
                }
            }

            menu.sort(Comparator.comparing(MenuItem::getTitle));
            Serializator.MenuSerialization(menu, "src/data/menu.csv");

            for(int i=0; i<table.productsTable.getRowCount(); i++)
                System.out.println(table.productsTable.getValueAt(i, 0));

            table.refreshTable(menu);
            ((DefaultTableModel)table.productsTable.getModel()).fireTableDataChanged();

            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);

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

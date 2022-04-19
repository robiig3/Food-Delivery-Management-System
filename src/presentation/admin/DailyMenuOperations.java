package presentation.admin;

import business.BaseProduct;
import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;
import data.Serializator;
import presentation.ProductsTable;
import presentation.SuccesWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class DailyMenuOperations {

    public JFrame frame;

    public DailyMenuOperations(DeliveryService ds){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DAILY MENU OPERATIONS");

        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(247,240,222));

        JButton buttBack = new JButton("Back");
        buttBack.setBounds(650, 500, 100, 50);
        panel.add(buttBack);

        List<MenuItem> dailyMenu = Serializator.MenuDeserialization("src/data/dailyMenu.csv");

        ProductsTable dailyMenuTable = new ProductsTable(dailyMenu);

        dailyMenuTable.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(dailyMenuTable.productsTable);
        scrollPane.setBounds(50,5,700,200);
        panel.add(scrollPane);

        List<MenuItem> menu = Serializator.MenuDeserialization("src/data/menu.csv");

        JLabel l1 = new JLabel("Select the first product");
        JLabel l2 = new JLabel("Select the second product");
        JLabel l3 = new JLabel("Select the third product");
        JLabel l4 = new JLabel("Select the fourth product");
        JComboBox cb1 = createMenuComboBox(menu);
        JComboBox cb2 = createMenuComboBox(menu);
        JComboBox cb3 = createMenuComboBox(menu);
        JComboBox cb4 = createMenuComboBox(menu);

        l1.setBounds(50, 225, 300, 30);
        cb1.setBounds(350, 225, 300, 30);
        l2.setBounds(50, 265, 300, 30);
        cb2.setBounds(350, 265, 300, 30);
        l3.setBounds(50, 305, 300, 30);
        cb3.setBounds(350, 305, 300, 30);
        l4.setBounds(50, 345, 300, 30);
        cb4.setBounds(350, 345, 300, 30);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(cb1);
        panel.add(cb2);
        panel.add(cb3);
        panel.add(cb4);

        JButton createDailyMenu = new JButton("Create Daily Menu");
        createDailyMenu.setBounds(150, 420, 200, 50);
        panel.add(createDailyMenu);

        JButton deleteProducts = new JButton("Delete Product");
        deleteProducts.setBounds(450, 420, 200, 50);
        panel.add(deleteProducts);

        final int[] row = new int[1];

        dailyMenuTable.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                row[0] = dailyMenuTable.productsTable.getSelectedRow();
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

        createDailyMenu.addActionListener(e -> {

            CompositeProduct cp = new CompositeProduct();

            String productName1 = (String) cb1.getSelectedItem();
            String productName2 = (String) cb2.getSelectedItem();
            String productName3 = (String) cb3.getSelectedItem();
            String productName4 = (String) cb4.getSelectedItem();

            ds.CreateDailyMenu(productName1, productName2, productName3, productName4);

            for (MenuItem m : menu){
                if(m.getTitle().equals(productName1)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getTitle().equals(productName2)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getTitle().equals(productName3)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getTitle().equals(productName4)){
                    cp.addProduct((BaseProduct) m);
                }
            }

            cp.printDailyMenuProducts();
            dailyMenu.add(cp);
            dailyMenu.sort(Comparator.comparing(MenuItem::getTitle));
            Serializator.MenuSerialization(dailyMenu, "src/data/dailyMenu.csv");

            SuccesWindow view = new SuccesWindow();
            view.frame.setVisible(true);

        });

        deleteProducts.addActionListener(e -> {

            dailyMenu.remove(row[0]);
            Serializator.MenuSerialization(dailyMenu, "src/data/dailyMenu.csv");
            ((DefaultTableModel)dailyMenuTable.productsTable.getModel()).removeRow(row[0]);

            for(int i=0; i<dailyMenuTable.productsTable.getRowCount(); i++)
                System.out.println(dailyMenuTable.productsTable.getValueAt(i, 0));

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

    public JComboBox createMenuComboBox(List<MenuItem> menu){
        JComboBox<String> combo = new JComboBox<>();
        if(menu == null || menu.size() == 0){
            combo.addItem("None");
        }
        else{
            combo.addItem("None");
            for (MenuItem m : menu) {
                combo.addItem(m.getTitle());
            }
        }
        return combo;
    }

}

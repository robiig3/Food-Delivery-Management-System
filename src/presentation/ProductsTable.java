package presentation;

import business.MenuItem;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class ProductsTable {

    public JTable productsTable;
    public TableRowSorter<TableModel> sorter;

    public ProductsTable(List<MenuItem> menu){
        productsTable = createMenuTable(menu);
        sorter = new TableRowSorter<>(productsTable.getModel());
        productsTable.setRowSorter(sorter);
    }

    public void refreshTable(List<MenuItem> menu) {
        this.productsTable = createMenuTable(menu);
    }

    public static JTable createMenuTable(List<MenuItem> menu){
        String[] columnNames = {"TITLE",
                "RATING",
                "CALORIES",
                "PROTEIN",
                "FAT",
                "SODIUM",
                "PRICE"};
        String[][] data = new String[menu.size()][7];
        int i = 0;
        try{
            for (MenuItem m : menu) {
                data[i][0] = m.getTitle();
                data[i][1] = Float.toString(m.getRating());
                data[i][2] = Integer.toString(m.getCalories());
                data[i][3] = Integer.toString(m.getProtein());
                data[i][4] = Integer.toString(m.getFat());
                data[i][5] = Integer.toString(m.getSodium());
                data[i][6] = Integer.toString(m.computePrice());
                i++;
            }
            DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
            JTable table = new JTable(tableModel);
            table.setPreferredScrollableViewportSize(new Dimension(700, 300));
            table.setRowSelectionAllowed(true);
            return table;
        }
        catch (Exception ex){
            data[i][2] = data[i][3] = data[i][4] = data[i][5] = " ";
            return null;
        }
    }

    public static void newMenuFilter(TableRowSorter<TableModel> sorter, String filterString, int indice){
        RowFilter<TableModel, Object> filter;
        try{
            //filter = RowFilter.numberFilter(RowFilter.ComparisonType.valueOf(filterString), Integer.parseInt(filterString), indice);
            filter = RowFilter.regexFilter("(?i)" + filterString, indice);
        }catch(PatternSyntaxException e){
            return;
        }
        sorter.setRowFilter(filter);
    }

    public static List<MenuItem> newMenuFilter2(List<MenuItem> menuItems, String filterString, int indice){

        List<MenuItem> menuItemsListWithFilter = null;

        switch (indice){
            case 0: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getTitle().startsWith(filterString)).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getTitle))), ArrayList::new));
                break;
            case 1: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getRating() < Float.parseFloat(filterString)).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getRating))), ArrayList::new));
                break;
            case 2: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getCalories() < Integer.parseInt((filterString))).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getCalories))), ArrayList::new));
                break;
            case 3: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getProtein() < Integer.parseInt((filterString))).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getProtein))), ArrayList::new));
                break;
            case 4: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getFat() < Integer.parseInt((filterString))).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getFat))), ArrayList::new));
                break;
            case 5: menuItemsListWithFilter = menuItems.stream().filter(i -> i.getSodium() < Integer.parseInt((filterString))).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getSodium))), ArrayList::new));
                break;
            case 6: menuItemsListWithFilter = menuItems.stream().filter(i -> i.computePrice() < Integer.parseInt((filterString))).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getProtein))), ArrayList::new));
                break;

        }

        return menuItemsListWithFilter;
    }

}

package business;

import data.Serializator;
import presentation.View;

import java.io.*;
import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable{

    public List<MenuItem> menu;
    public List<MenuItem> dailyMenu;
    public Map<Order, List<MenuItem>> ordersInformations;

    public DeliveryService() {
        this.menu = null;
        this.dailyMenu = null;
        this.ordersInformations = new Hashtable<>();;
    }

    public boolean WellFormed(){
        if(menu == null)
            return false;
        if(dailyMenu == null)
            return false;
        if(ordersInformations == null)
            return false;
        return true;
    }

    public static Function<String, MenuItem> mapToBaseProduct = (line) -> {
        String[] p = line.split(",");
        return new BaseProduct(p[0], Float.parseFloat(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]));
    };

    /**
     *   @post menu.size() >0
     */

    @Override
    public List<MenuItem> ImportProducts() {

        try {
            assert WellFormed();

            InputStream is = new FileInputStream("src/business/products.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            /* EXAMPLE for duplicate baseProduct:
            * Zita's Salmon with Herb Sauce ,3.75,795,42,59,259,67
            * Zita's Salmon with Herb Sauce ,4.375,795,22,55,290,13
            * */
            List<MenuItem> menuItems = br.lines().skip(1).map(mapToBaseProduct).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getTitle))),
                    ArrayList::new));

            assert menuItems != null;
            return menuItems;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   @pre product != null
     *   @pre product.price > 0
     */
    @Override
    public void AddProduct(MenuItem product) {

    }

    /**
     *   @pre product != null
     *   @pre product.price > 0
     *   @post menu.size() = @pre menu.size() - 1
     */

    @Override
    public void DeleteProduct(MenuItem product) {

    }
    /**
     *   @pre product != null
     *   @pre product.price > 0
     */

    @Override
    public void ModifyProduct(MenuItem product) {

    }

    /**
     *   @pre productName1 != null
     *   @pre productName2 != null
     *   @pre productName3 != null
     *   @pre productName4 != null
     */
    @Override
    public void CreateDailyMenu(String productName1, String productName2, String productName3, String productName4) {

    }

    @Override
    public void GenerateReports() {

    }

    /**
     *   @pre order != null
     *   @pre order.id > 0
     */
    @Override
    public void CreateNewOrder(Order order) {

    }

}

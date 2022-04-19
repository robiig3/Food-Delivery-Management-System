package business;

import java.util.List;

public interface IDeliveryServiceProcessing {

    // ADMIN OPERATIONS
    List<MenuItem> ImportProducts();
    void AddProduct(MenuItem product);
    void DeleteProduct(MenuItem product);
    void ModifyProduct(MenuItem product);
    void CreateDailyMenu(String productName1, String productName2, String productName3, String productName4);
    void GenerateReports();

    // CLIENT OPERATIONS
    void CreateNewOrder(Order order);

}

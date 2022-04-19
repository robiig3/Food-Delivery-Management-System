package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    int orderId;
    static int orderIdStatic = 1;
    int clientId;
    LocalDateTime date;
    int totalPrice;

    public Order(int clientId, int totalPrice){
        this.clientId = clientId;
        this.orderId = orderIdStatic++;
        this.date = LocalDateTime.now();
        this.totalPrice = totalPrice;
        System.out.println(date);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static int getOrderIdStatic() {
        return orderIdStatic;
    }

    public static void setOrderIdStatic(int orderIdStatic) {
        Order.orderIdStatic = orderIdStatic;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && totalPrice == order.totalPrice && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, date, totalPrice);
    }
}

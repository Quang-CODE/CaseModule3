package Model;

import java.util.Date;

public class Order {
    private int id;
    private int CustomerId;
    private int OrderNumber;

    public Order(int id, int customerId, int orderNumber) {
        this.id = id;
        CustomerId = customerId;
        OrderNumber = orderNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        OrderNumber = orderNumber;
    }

}

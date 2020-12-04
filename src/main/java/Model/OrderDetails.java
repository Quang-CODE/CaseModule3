package Model;

public class OrderDetails {
    private int Id;
    private int OrderId;
    private int ProductId;
    private int orderNumber;
    private int price;
    private int Quantity;
    private String shipAddress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public OrderDetails(int id, int orderId, int productId, int orderNumber, int price, int quantity, String shipAddress) {
        Id = id;
        OrderId = orderId;
        ProductId = productId;
        this.orderNumber = orderNumber;
        this.price = price;
        Quantity = quantity;
        this.shipAddress = shipAddress;

    }
}

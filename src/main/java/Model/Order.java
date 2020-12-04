package Model;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private int total;

    public Order(int id, int userId, int total) {
        this.id = id;
        this.userId = userId;
        this.total = total;
    }

    public Order(int userId, int total) {
        this.userId = userId;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

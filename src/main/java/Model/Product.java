package Model;

public class Product {
    private int id;
    private String productName;
    private String productDescription;
    private int category;
    private int quantity;
    private String image;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String productName, String productDescription, int category, int quantity, String image, int price) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
    }

    public Product(int id,String productName, String productDescription, int category, int quantity, String image, int price) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
    }
}



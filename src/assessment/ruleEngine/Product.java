package assessment.ruleEngine;

// Product Class (Encapsulation)
public class Product {
    private int productId;
    private String category;
    private int quantity;

    public Product(int productId, String category, int quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}

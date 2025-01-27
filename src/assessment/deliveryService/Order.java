package assessment.deliveryService;

import java.util.Map;

public class Order {
    private Map<Product, Integer> products; // Map of Product to quantity

    public Order(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}

package assessment.ruleEngine;

import java.util.ArrayList;
import java.util.List;

// Cart Class (Encapsulation of the Shopping Cart, holding multiple products)
public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

package assessment.ruleEngine;

import java.util.*;

public class RestrictionEngine {

    public static void main(String[] args) {
        // Create Restriction Rules (Encapsulation)
        RestrictionRule restrictionRule = new RestrictionRule(10, 5);  // 10 for any product, 5 for Paracetamol category

        // Create CartValidator instance with the defined rules
        CartValidator cartValidator = new CartValidator(restrictionRule);

        // Create Shopping Cart and add products
        Cart cart = new Cart();
        cart.addProduct(new Product(1, "Paracetamol", 3));
        cart.addProduct(new Product(2, "Analgesic", 3));
        cart.addProduct(new Product(3, "Chocolate", 8));
        cart.addProduct(new Product(4, "Paracetamol", 2));

        // Validate the shopping cart
        String status = cartValidator.validateCart(cart.getProducts());
        System.out.println("Restriction status: " + status);  // Should print "MET"
    }
}
package assessment.ruleEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CartValidator Class (Main logic class that applies rules to shopping cart)
public class CartValidator {
    private RestrictionRule restrictionRule;

    public CartValidator(RestrictionRule restrictionRule) {
        this.restrictionRule = restrictionRule;
    }

    public String validateCart(List<Product> shoppingCart) {
        Map<String, Integer> categoryQuantityMap = new HashMap<>();

        // Check each product in the cart
        for (Product product : shoppingCart) {
            // Check if the product's quantity exceeds the general bulk buy limit
            if (product.getQuantity() > restrictionRule.getBulkBuyLimit()) {
                return "BREACHED";
            }

            // Track quantity by category for category-specific restrictions
            categoryQuantityMap.put(product.getCategory(), categoryQuantityMap.getOrDefault(product.getCategory(), 0) + product.getQuantity());

            // Check if any restricted category exceeds its limit
            if (restrictionRule.getRestrictedCategories().contains(product.getCategory()) &&
                    categoryQuantityMap.get(product.getCategory()) > restrictionRule.getBulkBuyLimitCategory()) {
                return "BREACHED";
            }
        }

        return "MET";  // All rules are satisfied
    }
}

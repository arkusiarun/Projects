package assessment.ruleEngine;

import java.util.HashSet;
import java.util.Set;

// RestrictionRule Class (Encapsulation for each individual restriction)
public class RestrictionRule {
    private int bulkBuyLimit;
    private int bulkBuyLimitCategory;
    private Set<String> restrictedCategories;

    public RestrictionRule(int bulkBuyLimit, int bulkBuyLimitCategory) {
        this.bulkBuyLimit = bulkBuyLimit;
        this.bulkBuyLimitCategory = bulkBuyLimitCategory;
        this.restrictedCategories = new HashSet<>();
        this.restrictedCategories.add("Paracetamol");
    }

    public int getBulkBuyLimit() {
        return bulkBuyLimit;
    }

    public int getBulkBuyLimitCategory() {
        return bulkBuyLimitCategory;
    }

    public Set<String> getRestrictedCategories() {
        return restrictedCategories;
    }
}

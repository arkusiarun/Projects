package assessment.deliveryService;

import java.util.Map;

public class Container {
    private int id;
    private int length, breadth, height, volume;

    public Container(int id, int length, int breadth, int height) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.volume = length * breadth * height;
    }

    public int getId() {
        return id;
    }

    public boolean canFitProduct(Product product) {
        return product.getLength() <= length &&
                product.getBreadth() <= breadth &&
                product.getHeight() <= height;
    }

    public boolean canFitOrder(Order order) {
        int totalVolume = 0;

        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (!canFitProduct(product)) {
                return false;
            }

            totalVolume += product.getVolume() * quantity;

            if (totalVolume > volume) {
                return false;
            }
        }

        return true;
    }
}

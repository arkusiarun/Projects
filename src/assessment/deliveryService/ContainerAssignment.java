package assessment.deliveryService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ContainerAssignment {
    public static void main(String[] args) {
        // Create Containers
        List<Container> containers = Arrays.asList(
                new Container(1, 10, 20, 30),
                new Container(2, 50, 60, 70),
                new Container(3, 100, 200, 300)
        );

        // Create Products
        Product product1 = new Product(1, 2, 4, 10);
        Product product2 = new Product(2, 10, 30, 4);
        Product product3 = new Product(3, 5, 6, 7);

        // Create Orders
        List<Order> orders = Arrays.asList(
                new Order(Map.of(product1, 3, product3, 7)),  // Order 1
                new Order(Map.of(product2, 2, product3, 5)),  // Order 2
                new Order(Map.of(product1, 1, product3, 2))   // Order 3
        );

        // Create Delivery Service
        DeliveryService deliveryService = new DeliveryService(containers, orders);

        // Check which containers can fit the first order
        deliveryService.findFittingContainersForOrder(orders.get(0));

        // Calculate the maximum number of orders each container can hold
        deliveryService.calculateMaxOrdersPerContainer();
    }
}

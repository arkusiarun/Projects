package assessment.deliveryService;

import java.util.List;

public class DeliveryService {
    private List<Container> containers;
    private List<Order> orders;

    public DeliveryService(List<Container> containers, List<Order> orders) {
        this.containers = containers;
        this.orders = orders;
    }

    public void findFittingContainersForOrder(Order order) {
        System.out.println("Checking which containers fit the given order:");
        for (Container container : containers) {
            if (container.canFitOrder(order)) {
                System.out.println("Order fits in container ID: " + container.getId());
            }
        }
    }

    public void calculateMaxOrdersPerContainer() {
        System.out.println("\nCalculating the maximum number of orders each container can hold:");
        for (Container container : containers) {
            int count = 0;
            for (Order order : orders) {
                if (container.canFitOrder(order)) {
                    count++;
                }
            }
            System.out.println("Container ID " + container.getId() + " can hold " + count + " orders.");
        }
    }
}

package assessment.deliveryService;

import java.util.*;

public class Product {
    private int id;
    private int length, breadth, height, volume;

    public Product(int id, int length, int breadth, int height) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.volume = length * breadth * height;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public int getHeight() {
        return height;
    }

    public int getVolume() {
        return volume;
    }
}


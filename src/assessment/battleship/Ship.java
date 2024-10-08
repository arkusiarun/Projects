package assessment.battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    String type;
    int size;
    int hitCount;
    List<Coordinate> coordinates;

    public Ship(String type, int size) {
        this.type = type;
        this.size = size;
        this.coordinates = new ArrayList<>();
        this.hitCount = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    public boolean isHit(Coordinate coordinate) {
        if(coordinates.contains(coordinate)) {
            hitCount++;
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        return hitCount >= size;
    }
}

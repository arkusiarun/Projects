package practise.battleship;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int gridSize = 10;
    List<Ship> ships;
    private boolean[][] hits;

    public Board() {
        ships = new ArrayList<>();
        hits = new boolean[gridSize][gridSize];
    }

    public int getGridSize() {
        return gridSize;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean[][] getHits() {
        return hits;
    }

    public void setHits(boolean[][] hits) {
        this.hits = hits;
    }

    public boolean placeShip(Ship ship, Coordinate start, boolean horizontal) {
        if (isValidPlacement(ship, start, horizontal)) {
            if (horizontal) {
                for (int i = 0; i < ship.getSize(); i++) {
                    ship.addCoordinate(new Coordinate(start.getX(), start.getY() + i));
                }
            } else {
                for (int i = 0; i < ship.getSize(); i++) {
                    ship.addCoordinate(new Coordinate(start.getX() + i, start.getY()));
                }
            }
            ships.add(ship);
            return true;
        }
        return false;
    }

    private boolean isValidPlacement(Ship ship, Coordinate start, boolean horizontal) {
        int endX = horizontal ? start.getX() : start.getX() + ship.getSize() - 1;
        int endY = horizontal ? start.getY() + ship.getSize() - 1 : start.getY();

        if (endX >= gridSize || endY >= gridSize) return false;
        for (Ship s : ships) {
            for (Coordinate coord : s.getCoordinates()) {
                if (horizontal) {
                    for (int i = 0; i < ship.getSize(); i++) {
                        if (coord.equals(new Coordinate(start.getX(), start.getY() + i))) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 0; i < ship.getSize(); i++) {
                        if (coord.equals(new Coordinate(start.getX() + i, start.getY()))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public String attack(Coordinate coordinate) {
        hits[coordinate.getX()][coordinate.getY()] = true;
        for (Ship ship : ships) {
            if (ship.isHit(coordinate)) {
                if (ship.isSunk()) {
                    return "You sank a " + ship.getType() + "!";
                }
                return "Hit!";
            }
        }
        return "Miss!";
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}

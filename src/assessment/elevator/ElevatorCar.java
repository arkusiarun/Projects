package assessment.elevator;

import java.util.Set;
import java.util.TreeSet;

public class ElevatorCar {

    private int id;
    private int currentFloor;
    private Directions direction;
    Set<Integer> requests;
    private int maxFloors;

    public ElevatorCar(int id, int maxFloors) {
        this.id = id;
        this.maxFloors = maxFloors;
        this.currentFloor = 0;
        this.direction = Directions.IDLE;
        this.requests = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Set<Integer> getRequests() {
        return requests;
    }

    public void setRequests(Set<Integer> requests) {
        this.requests = requests;
    }

    public int getMaxFloors() {
        return maxFloors;
    }

    public void setMaxFloors(int maxFloors) {
        this.maxFloors = maxFloors;
    }

    public void addRequest(int floor) {
        requests.add(floor);
        if(Directions.IDLE.equals(direction)) {
            if(floor > currentFloor) {
                direction = Directions.UP;
            } else if(floor < currentFloor){
                direction = Directions.DOWN;
            }
        }
    }

    public void move() {
        if(!requests.isEmpty()) {
            if(direction.equals(Directions.UP)) {
                currentFloor++;
            } else if(direction.equals(Directions.DOWN)) {
                currentFloor--;
            }
            System.out.println("Elevator : " + id + " is at Floor : "+ currentFloor);
            if(requests.contains(currentFloor)) {
                System.out.println("Elevator " + id + " stops at floor " + currentFloor);
                requests.remove(currentFloor);
            }
            if(requests.isEmpty()) {
                direction = Directions.IDLE;
            } else {
                updateDirection();
            }
        } else {
            direction = Directions.IDLE;
        }
    }

    private void updateDirection() {
        if (requests.isEmpty()) {
            direction = Directions.IDLE;
        } else if (direction == Directions.UP && requests.stream().allMatch(floor -> floor < currentFloor)) {
            direction = Directions.DOWN;
        } else if (direction == Directions.DOWN && requests.stream().allMatch(floor -> floor > currentFloor)) {
            direction = Directions.UP;
        }
    }

    public boolean canTakeRequest(Request request) {
        if (direction == Directions.IDLE) {
            return true;
        } else if (direction == request.getDirection()) {
            if (direction == Directions.UP && request.getFloor() > currentFloor) {
                return true;
            } else if (direction == Directions.DOWN && request.getFloor() < currentFloor) {
                return true;
            }
        }
        return false;
    }
}

package practise.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<ElevatorCar> elevator;
    private int maxFloors;

    public ElevatorController(int noOfElevators, int maxFloors) {
        this.elevator = new ArrayList<>();
        this.maxFloors = maxFloors;

        for (int i = 1; i <= noOfElevators; i++) {
            elevator.add(new ElevatorCar(i, maxFloors));
        }
    }

    public List<ElevatorCar> getElevator() {
        return elevator;
    }

    public void setElevator(List<ElevatorCar> elevator) {
        this.elevator = elevator;
    }

    public int getMaxFloors() {
        return maxFloors;
    }

    public void setMaxFloors(int maxFloors) {
        this.maxFloors = maxFloors;
    }

    public void callElevator(Request request) {
        ElevatorCar matchedElevator = null;
        for (ElevatorCar elevatorCar : elevator) {
            if (elevatorCar.canTakeRequest(request)) {
                matchedElevator = elevatorCar;
                break;
            }
        }
        if (matchedElevator != null) {
            matchedElevator.addRequest(request.getFloor());
            System.out.println("Elevator : " + matchedElevator.getId() + " is coming to floor : " + request.getFloor());
        } else {
            System.out.println("All elevators are busy, please wait.");
        }
    }

    public void step() {
        for (ElevatorCar elevator : elevator) {
            elevator.move();
        }
    }
}
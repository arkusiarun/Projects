package assessment.elevator;

public class Request {
    private int floor;
    private Directions direction;

    public Request(int floor, Directions direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Directions getDirection() {
        return direction;
    }
}

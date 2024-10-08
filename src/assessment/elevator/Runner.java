package assessment.elevator;

public class Runner {

    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3, 10);

        controller.callElevator(new Request(5, Directions.UP));
        controller.callElevator(new Request(7, Directions.DOWN));
        controller.callElevator(new Request(3, Directions.UP));

        for (int i = 0; i < 10; i++) {
            controller.step();
        }
    }
}

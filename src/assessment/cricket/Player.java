package assessment.cricket;

// Player Class
public class Player {
    private final String name;
    private int runs;
    private int ballsFaced;
    private int wicketsTaken;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.wicketsTaken = 0;
    }

    public String getName() {
        return name;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void incrementBallsFaced() {
        this.ballsFaced++;
    }

    public void incrementWickets() {
        this.wicketsTaken++;
    }

    @Override
    public String toString() {
        return name + " | Runs: " + runs + ", Balls: " + ballsFaced + ", Wickets: " + wicketsTaken;
    }
}

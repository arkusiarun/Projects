package assessment.cricket;

import java.util.ArrayList;
import java.util.List;

// Scoreboard Class
public class Scoreboard {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private int totalRuns;
    private int totalWickets;
    private int totalBalls;
    private final List<String> commentary;

    public Scoreboard(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.totalRuns = 0;
        this.totalWickets = 0;
        this.totalBalls = 0;
        this.commentary = new ArrayList<>();
    }

    public void addRun(int runs) {
        totalRuns += runs;
    }

    public void incrementWickets() {
        totalWickets++;
    }

    public void incrementBalls() {
        totalBalls++;
    }

    public void addCommentary(String message) {
        commentary.add(message);
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }

    public List<String> getCommentary() {
        return commentary;
    }

    public void displayScore() {
        System.out.println("Batting Team: " + battingTeam.getName());
        System.out.println("Score: " + totalRuns + "/" + totalWickets + " in " + totalBalls + " balls");
        System.out.println("Commentary:");
        for (String comment : commentary) {
            System.out.println(comment);
        }
    }
}

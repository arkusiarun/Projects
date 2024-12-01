package assessment.cricket;

import java.util.Arrays;
import java.util.List;

// Main Class
public class CricketMatchSystem {
    public static void main(String[] args) {
        // Players for Team 1
        List<Player> team1Players = Arrays.asList(
                new Player("Player A"), new Player("Player B"), new Player("Player C"),
                new Player("Player D"), new Player("Player E")
        );

        // Players for Team 2
        List<Player> team2Players = Arrays.asList(
                new Player("Player F"), new Player("Player G"), new Player("Player H"),
                new Player("Player I"), new Player("Player J")
        );

        // Teams
        Team team1 = new Team("Team Alpha", team1Players);
        Team team2 = new Team("Team Beta", team2Players);

        // Match (5 overs)
        Match match = new Match(team1, team2, 5);
        match.startMatch();
    }
}

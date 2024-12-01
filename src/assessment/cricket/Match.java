package assessment.cricket;

import java.util.*;

public class Match {
    private final Team team1;
    private final Team team2;
    private final int overs;
    private Scoreboard scoreboard;

    public Match(Team team1, Team team2, int overs) {
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
    }

    public void startMatch() {
        // Team1 bats first
        scoreboard = new Scoreboard(team1, team2);
        playInnings(team1, team2);
        scoreboard.displayScore();

        // Team2 bats second
        scoreboard = new Scoreboard(team2, team1);
        playInnings(team2, team1);
        scoreboard.displayScore();
    }

    private void playInnings(Team battingTeam, Team bowlingTeam) {
        Random random = new Random();
        List<Player> batsmen = battingTeam.getPlayers();
        int batsmanIndex = 0;

        for (int i = 0; i < overs * 6; i++) {
            if (batsmanIndex >= batsmen.size() || scoreboard.getTotalWickets() >= batsmen.size() - 1) {
                break; // End innings if all players are out
            }

            Player striker = batsmen.get(batsmanIndex);
            BallOutcome outcome = BallOutcome.values()[random.nextInt(BallOutcome.values().length)];
            scoreboard.incrementBalls();

            switch (outcome) {
                case DOT_BALL -> scoreboard.addCommentary("Dot ball.");
                case SINGLE -> {
                    striker.addRuns(1);
                    scoreboard.addRun(1);
                    scoreboard.addCommentary(striker.getName() + " scores 1 run.");
                }
                case DOUBLE -> {
                    striker.addRuns(2);
                    scoreboard.addRun(2);
                    scoreboard.addCommentary(striker.getName() + " scores 2 runs.");
                }
                case TRIPLE -> {
                    striker.addRuns(3);
                    scoreboard.addRun(3);
                    scoreboard.addCommentary(striker.getName() + " scores 3 runs.");
                }
                case FOUR -> {
                    striker.addRuns(4);
                    scoreboard.addRun(4);
                    scoreboard.addCommentary(striker.getName() + " hits a FOUR!");
                }
                case SIX -> {
                    striker.addRuns(6);
                    scoreboard.addRun(6);
                    scoreboard.addCommentary(striker.getName() + " hits a SIX!");
                }
                case WICKET -> {
                    scoreboard.incrementWickets();
                    scoreboard.addCommentary("Wicket! " + striker.getName() + " is out.");
                    batsmanIndex++; // Next batsman
                }
                case NO_BALL -> {
                    scoreboard.addRun(1);
                    scoreboard.addCommentary("No ball! 1 run added.");
                }
                case WIDE_BALL -> {
                    scoreboard.addRun(1);
                    scoreboard.addCommentary("Wide ball! 1 run added.");
                }
            }
        }
    }
}


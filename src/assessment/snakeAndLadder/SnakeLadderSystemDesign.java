package assessment.snakeAndLadder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeLadderSystemDesign {
    public static void main(String[] args) {
        List<Snake> snakes = Arrays.asList(
                new Snake(99, 54),
                new Snake(70, 55),
                new Snake(52, 42),
                new Snake(25, 2),
                new Snake(95, 72)
        );

        List<Ladder> ladders = Arrays.asList(
                new Ladder(6, 25),
                new Ladder(11, 40),
                new Ladder(60, 85),
                new Ladder(46, 90),
                new Ladder(17, 69)
        );

        Board board = new Board(100, snakes, ladders);
        Dice dice = new Dice();

        Queue<Player> players = new LinkedList<>();
        players.offer(new Player("Player 1"));
        players.offer(new Player("Player 2"));

        Game game = new Game(board, dice, players);
        game.start();
    }
}
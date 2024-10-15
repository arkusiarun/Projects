package assessment.snakeAndLadder;

import java.util.Queue;

class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;

    public Game(Board board, Dice dice, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public void start() {
        boolean gameWon = false;
        while (!gameWon) {
            Player currentPlayer = players.poll(); // Get the next player in line
            int diceRoll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            int newPosition = currentPlayer.getPosition() + diceRoll;

            if (newPosition > board.getSize()) {
                System.out.println(currentPlayer.getName() + " cannot move, needs an exact roll to win.");
                players.offer(currentPlayer);  // Place the player at the end of the queue
                continue;
            }

            newPosition = board.checkSnakeOrLadder(newPosition);  // Check if the player encounters snake or ladder
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " is now at position " + newPosition);

            if (newPosition == board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                gameWon = true;
            } else {
                players.offer(currentPlayer);  // Place the player at the end of the queue
            }
        }
    }
}
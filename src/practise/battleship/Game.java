package practise.battleship;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player opponent;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        currentPlayer = player1;
        opponent = player2;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        setupShips(player1);
        setupShips(player2);

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn.");
            System.out.print("Enter coordinates (x,y) to attack: ");
            String[] input = scanner.nextLine().split(",");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            String result = opponent.getBoard().attack(new Coordinate(x, y));
            System.out.println(result);

            if (opponent.getBoard().allShipsSunk()) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
        scanner.close();
    }

    private void setupShips(Player player) {
        player.getBoard().placeShip(new Ship("Carrier", 5), new Coordinate(0, 0), true);
        player.getBoard().placeShip(new Ship("Battleship", 4), new Coordinate(2, 2), false);
        player.getBoard().placeShip(new Ship("Cruiser", 3), new Coordinate(4, 4), true);
        player.getBoard().placeShip(new Ship("Submarine", 3), new Coordinate(6, 6), false);
        player.getBoard().placeShip(new Ship("Destroyer", 2), new Coordinate(8, 8), true);
    }
}
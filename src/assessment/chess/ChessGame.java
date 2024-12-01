package assessment.chess;

// Main class
public class ChessGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.displayBoard();
        System.out.println("White moves Pawn from (6, 0) to (5, 0): " + game.playMove(new Position(6, 0), new Position(5, 0)));
        game.displayBoard();
    }
}

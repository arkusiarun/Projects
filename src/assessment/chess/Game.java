package assessment.chess;

// Game class
public class Game {
    private ChessBoard board;
    private PieceColor currentTurn;

    public Game() {
        board = new ChessBoard();
        currentTurn = PieceColor.WHITE;
    }

    public boolean playMove(Position start, Position end) {
        ChessPiece piece = board.getPiece(start);
        if (piece == null || piece.getColor() != currentTurn) {
            System.out.println("Invalid move: Not your turn or no piece at the starting position.");
            return false;
        }

        if (piece.isValidMove(board, start, end)) {
            board.movePiece(start, end);
            currentTurn = (currentTurn == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
            return true;
        } else {
            System.out.println("Invalid move for the piece.");
            return false;
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.getPiece(new Position(i, j));
                System.out.print((piece == null ? "--" : piece.getClass().getSimpleName().charAt(0)) + " ");
            }
            System.out.println();
        }
    }
}

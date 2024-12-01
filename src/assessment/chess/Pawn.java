package assessment.chess;

// Specific Pieces
public class Pawn extends ChessPiece {
    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int direction = (color == PieceColor.WHITE) ? -1 : 1;
        int rowDiff = end.row - start.row;
        int colDiff = Math.abs(end.col - start.col);

        if (colDiff == 0 && rowDiff == direction && board.getPiece(end) == null) {
            return true; // Move forward
        } else if (colDiff == 1 && rowDiff == direction && board.getPiece(end) != null) {
            return true; // Diagonal capture
        }
        return false;
    }
}

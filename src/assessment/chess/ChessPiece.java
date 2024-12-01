package assessment.chess;

// Abstract ChessPiece class
abstract public class ChessPiece {
    protected PieceColor color;

    public ChessPiece(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    // Abstract method to check if a move is valid
    public abstract boolean isValidMove(ChessBoard board, Position start, Position end);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" + color + ")";
    }
}

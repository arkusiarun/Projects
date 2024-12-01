package assessment.chess;

public class King extends ChessPiece {
    public King(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int rowDiff = Math.abs(start.row - end.row);
        int colDiff = Math.abs(start.col - end.col);
        return rowDiff <= 1 && colDiff <= 1;
    }
}

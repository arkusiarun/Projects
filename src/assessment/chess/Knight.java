package assessment.chess;

public class Knight extends ChessPiece {
    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int rowDiff = Math.abs(start.row - end.row);
        int colDiff = Math.abs(start.col - end.col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}

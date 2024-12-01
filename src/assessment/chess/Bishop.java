package assessment.chess;

public class Bishop extends ChessPiece {
    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int rowDiff = Math.abs(start.row - end.row);
        int colDiff = Math.abs(start.col - end.col);
        return rowDiff == colDiff && board.isPathClear(start, end);
    }
}

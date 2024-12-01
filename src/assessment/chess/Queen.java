package assessment.chess;

public class Queen extends ChessPiece {
    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int rowDiff = Math.abs(start.row - end.row);
        int colDiff = Math.abs(start.col - end.col);
        return (rowDiff == colDiff || start.row == end.row || start.col == end.col) && board.isPathClear(start, end);
    }
}

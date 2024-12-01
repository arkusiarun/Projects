package assessment.chess;

import java.util.*;

public class Rook extends ChessPiece {
    public Rook(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        if (start.row != end.row && start.col != end.col) return false;
        return board.isPathClear(start, end);
    }
}


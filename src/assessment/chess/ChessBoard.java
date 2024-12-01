package assessment.chess;

// ChessBoard class
public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        setupBoard();
    }

    // Initialize the board with pieces
    private void setupBoard() {
        // Add Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(PieceColor.BLACK);
            board[6][i] = new Pawn(PieceColor.WHITE);
        }

        // Add Rooks
        board[0][0] = new Rook(PieceColor.BLACK);
        board[0][7] = new Rook(PieceColor.BLACK);
        board[7][0] = new Rook(PieceColor.WHITE);
        board[7][7] = new Rook(PieceColor.WHITE);

        // Add Knights
        board[0][1] = new Knight(PieceColor.BLACK);
        board[0][6] = new Knight(PieceColor.BLACK);
        board[7][1] = new Knight(PieceColor.WHITE);
        board[7][6] = new Knight(PieceColor.WHITE);

        // Add Bishops
        board[0][2] = new Bishop(PieceColor.BLACK);
        board[0][5] = new Bishop(PieceColor.BLACK);
        board[7][2] = new Bishop(PieceColor.WHITE);
        board[7][5] = new Bishop(PieceColor.WHITE);

        // Add Queens
        board[0][3] = new Queen(PieceColor.BLACK);
        board[7][3] = new Queen(PieceColor.WHITE);

        // Add Kings
        board[0][4] = new King(PieceColor.BLACK);
        board[7][4] = new King(PieceColor.WHITE);
    }

    public ChessPiece getPiece(Position position) {
        return board[position.row][position.col];
    }

    public void movePiece(Position start, Position end) {
        ChessPiece piece = getPiece(start);
        board[end.row][end.col] = piece;
        board[start.row][start.col] = null;
    }

    public boolean isPathClear(Position start, Position end) {
        if (start.row == end.row) {
            int colMin = Math.min(start.col, end.col);
            int colMax = Math.max(start.col, end.col);
            for (int i = colMin + 1; i < colMax; i++) {
                if (board[start.row][i] != null) return false;
            }
        } else if (start.col == end.col) {
            int rowMin = Math.min(start.row, end.row);
            int rowMax = Math.max(start.row, end.row);
            for (int i = rowMin + 1; i < rowMax; i++) {
                if (board[i][start.col] != null) return false;
            }
        } else {
            int rowStep = (end.row > start.row) ? 1 : -1;
            int colStep = (end.col > start.col) ? 1 : -1;
            int row = start.row + rowStep;
            int col = start.col + colStep;
            while (row != end.row && col != end.col) {
                if (board[row][col] != null) return false;
                row += rowStep;
                col += colStep;
            }
        }
        return true;
    }
}

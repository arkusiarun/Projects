package assessment.sudoku;

public class SudokuBoard {
    private static final int SIZE = 9; // Board size is always 9x9 for Sudoku
    private int[][] board;

    public SudokuBoard() {
        board = new int[SIZE][SIZE];
    }

    public void loadBoard(int[][] initialBoard) {
        if (initialBoard.length != SIZE || initialBoard[0].length != SIZE) {
            throw new IllegalArgumentException("Invalid board size. Must be 9x9.");
        }
        this.board = initialBoard;
    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public void setCellValue(int row, int col, int value) {
        board[row][col] = value;
    }
}

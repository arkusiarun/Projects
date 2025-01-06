package assessment.sudoku;

public class SudokuGame {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();
        SudokuSolver solver = new SudokuSolver();

        int[][] initialBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Load the board
        board.loadBoard(initialBoard);

        System.out.println("Initial Sudoku Puzzle:");
        board.printBoard();

        // Solve the Sudoku
        if (solver.solve(board)) {
            System.out.println("\nSolved Sudoku Puzzle:");
            board.printBoard();
        } else {
            System.out.println("\nNo solution exists for the given Sudoku puzzle.");
        }
    }
}

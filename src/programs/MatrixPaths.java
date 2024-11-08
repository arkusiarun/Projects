package programs;

import java.util.ArrayList;
import java.util.List;

public class MatrixPaths {

    // Recursive function to find all paths from (0, 0) to (n-1, n-1)
    public static void findPaths(int n, int row, int col, String path, List<String> paths) {
        // If we've reached the bottom-right corner, add the path to the list
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        // Move Right if within bounds
        if (col + 1 < n) {
            findPaths(n, row, col + 1, path + "R", paths);
        }

        // Move Down if within bounds
        if (row + 1 < n) {
            findPaths(n, row + 1, col, path + "D", paths);
        }
    }

    // Function to print all paths
    public static void printPaths(int n) {
        List<String> paths = new ArrayList<>();
        findPaths(n, 0, 0, "", paths);

        // Print all paths
        for (String path : paths) {
            System.out.println(path);
        }
    }

    public static void main(String[] args) {
        int n = 4; // Example for a 2x2 matrix
        printPaths(n);
    }
}
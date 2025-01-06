package programs;

import java.util.Arrays;

public class MatrixMedian {
    public static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Find the global minimum and maximum in the matrix
        for (int i = 0; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int desiredCount = (rows * cols + 1) / 2; // Median position in 1-indexed array

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Count how many elements are <= mid
            int count = 0;
            for (int i = 0; i < rows; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            // Adjust search range based on count
            if (count < desiredCount) {
                low = mid + 1; // Median is in the higher half
            } else {
                high = mid; // Median is in the lower half or equal to mid
            }
        }

        return low; // Low converges to the median
    }

    // Helper function to count elements <= target in a sorted array
    private static int countLessEqual(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        System.out.println("Median of the matrix is: " + findMedian(matrix));
    }
}
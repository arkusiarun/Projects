package programs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Perform DFS for all cells adjacent to the Pacific and Atlantic oceans
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0); // Pacific left column
            dfs(heights, atlantic, i, cols - 1); // Atlantic right column
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j); // Pacific top row
            dfs(heights, atlantic, rows - 1, j); // Atlantic bottom row
        }

        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    !visited[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        System.out.println("Cells where water can flow to both oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}

package programs;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    findAll(grid, i,j);
                }
            }
        }
        return count;
    }

    static void findAll(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>= grid[i].length || grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        findAll(grid, i+1, j);
        findAll(grid, i-1, j);
        findAll(grid, i, j+1);
        findAll(grid, i, j-1);
    }

    public static void main(String[] args) {
       char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                                  {'1', '1', '0', '1', '0'},
                                  {'1', '1', '0', '0', '0'},
                                  {'0', '0', '0', '0', '0'}};
       System.out.println(numIslands(grid));
    }
}

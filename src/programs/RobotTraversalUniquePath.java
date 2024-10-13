package programs;

import java.util.Arrays;

public class RobotTraversalUniquePath {
    static int uniquePathsRecursion(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n - 1);
    }

    static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsRecursion(3, 7));
        System.out.println(uniquePathsRecursion(3, 2));

        System.out.println(uniquePathsDP(3, 7));
        System.out.println(uniquePathsDP(3, 2));
    }
}

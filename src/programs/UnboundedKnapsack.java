package programs;


/*
Given two arrays, first representing the value of coins, and the second representing their weight. Given that you can carry a maximum weight W, find the maximum possible value of coins.

        values = [1, 2, 3], weights = [4, 5, 1], W = 4
Output: 12

Values = [10, 40, 30, 50], weights = [5, 4, 6, 3], W = 10
Output: 150

Values = [1,2], Weights = [1, 25], W= 100
Output = 100
*/

public class UnboundedKnapsack {

    static int knapsack(int[] weights, int[] values, int maxCapacity) {
        int n = weights.length;
        int dp[] = new int[maxCapacity + 1];
        for (int i = 0; i <= maxCapacity; i++) {
            for (int j = 0; j < n; j++) {
                if (weights[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }
        return dp[maxCapacity];
    }

    public static void main(String[] args) {
        System.out.println("Output : " + knapsack(new int[]{4, 5, 1}, new int[]{1, 2, 3}, 4));
        System.out.println("Output : " + knapsack(new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50}, 10));
        System.out.println("Output : " + knapsack(new int[]{1, 110}, new int[]{1, 2}, 100));
    }
}
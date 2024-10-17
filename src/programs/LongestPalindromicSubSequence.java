package programs;

public class LongestPalindromicSubSequence {

    static int longestPalindromicSubSequence(String s) {
        int l = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int l1 = rev.length();
        int dp[][] = new int[l + 1][l1 + 1];
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < l1 + 1; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l][l1];
    }

    public static void main(String[] args) {
        String s = "abcdba";
        int result = longestPalindromicSubSequence(s);
        System.out.println("Minimum deletions to make the string a palindrome: " + result);
    }
}

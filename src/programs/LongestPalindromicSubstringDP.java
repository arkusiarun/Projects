package programs;

public class LongestPalindromicSubstringDP {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0, maxLength = 1;

        // Base case: Single character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: Two consecutive characters
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Fill the DP table for substrings longer than 2
        for (int len = 3; len <= n; len++) { // Length of the substring
            for (int i = 0; i < n - len + 1; i++) { // Starting index
                int j = i + len - 1; // Ending index

                // Check if s[i...j] is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s1)); // Output: "bab" or "aba"

        String s2 = "cbbd";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s2)); // Output: "bb"

        String s3 = "a";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s3)); // Output: "a"

        String s4 = "ac";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s4)); // Output: "a" or "c"
    }
}
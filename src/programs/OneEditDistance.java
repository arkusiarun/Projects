package programs;

public class OneEditDistance {

    static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (m == 0 && n == 1) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return m + 1 == n;
    }

    static boolean isOneEditDistanceDP(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) return false;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n] == 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("fog", "foo")); //Done
        System.out.println(isOneEditDistance("grab", "grab")); //Done
        System.out.println(isOneEditDistance("grab", "brag")); //Done
        System.out.println(isOneEditDistance("listen", "listez"));
        System.out.println(isOneEditDistance("listen", "lisnen"));
        System.out.println(isOneEditDistance("listen", "silent"));
        System.out.println(isOneEditDistance("a", "a"));
        System.out.println(isOneEditDistance("ab", "b"));
        System.out.println(isOneEditDistance("ab", "bab"));
        System.out.println(isOneEditDistance("", "b")); //
        System.out.println(isOneEditDistance("", ""));
        System.out.println(isOneEditDistance("bab", "ab"));
        System.out.println(isOneEditDistance("abcd", "abcde"));
        System.out.println(isOneEditDistance("abc", "abdc"));
    }
}

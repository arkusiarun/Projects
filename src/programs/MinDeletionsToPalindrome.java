package programs;

public class MinDeletionsToPalindrome {
    public static int minDeletions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int index = j + i - 1;
                if (i == 1) {
                    dp[j][index] = 0;
                } else if (i == 2) {
                    dp[j][index] = (s.charAt(j) == s.charAt(index)) ? 0 : 1;
                } else {
                    if (s.charAt(j) == s.charAt(index)) {
                        dp[j][index] = dp[j + 1][index - 1];
                    } else {
                        dp[j][index] = 1 + Math.min(dp[j + 1][index], dp[j][index - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    static int approach2(String s) {
        int l=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        int l1=rev.length();
        int dp[][]=new int[l+1][l1+1];
        for(int i=1;i<l+1;i++)
        {
            for(int j=1;j<l1+1;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return l-dp[l][l1];
    }

    public static void main(String[] args) {
        String s = "abcdba";
        int result = approach2(s);
        System.out.println("Minimum deletions to make the string a palindrome: " + result);
    }
}

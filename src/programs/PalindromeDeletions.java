package programs;

public class PalindromeDeletions {

    public static int countValidDeletions(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isRemainingPalindrome(s, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isRemainingPalindrome(String s, int index) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (left == index) {
                left++;
            } else if (right == index) {
                right--;
            } else if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abccba";
        int result = countValidDeletions(s);
        System.out.println("Maximum number of valid deletions: " + result);
    }
}

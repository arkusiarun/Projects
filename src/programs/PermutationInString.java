package programs;

import java.util.Arrays;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // If s1 is longer than s2, no permutation is possible
        if (len1 > len2) return false;

        // Frequency arrays for s1 and current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Count frequencies of characters in s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Sliding window approach
        for (int i = 0; i < len2; i++) {
            // Add the current character to the window
            windowFreq[s2.charAt(i) - 'a']++;

            // Remove the character that's no longer in the window
            if (i >= len1) {
                windowFreq[s2.charAt(i - len1) - 'a']--;
            }

            // Check if the current window matches the frequency of s1
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "hdeuudba";

        boolean result = checkInclusion(s1, s2);
        System.out.println("Does any permutation of \"" + s1 + "\" exist in \"" + s2 + "\"? " + result);
    }
}
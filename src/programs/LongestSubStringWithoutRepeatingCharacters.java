package programs;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println("Length : " + longestSubString(str1));
        System.out.println("Length : " + longestSubString(str2));
        System.out.println("Length : " + longestSubString(str3));
    }

    static int longestSubString(String str) {
        System.out.println("Input String : "+  str);
        Set<Character> set = new HashSet<>();
        int i = 0, maxLength = 0;
        String result = "";
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            while (set.contains(c)) {
                set.remove(str.charAt(i));
                i++;
            }
            set.add(c);
            if (j - i + 1 > maxLength) {
                maxLength = j - i + 1;
                result = str.substring(i, i + maxLength);
            }
        }
        System.out.println("Result String :" + result);
        return maxLength;
    }
}

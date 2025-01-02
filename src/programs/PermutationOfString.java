package programs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationOfString {

    public static List<String> getPermutations(String str) {
        if (str == null || str.isEmpty()) {
            return List.of("");
        }

        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(i -> {
                    char currentChar = str.charAt(i);
                    String remaining = str.substring(0, i) + str.substring(i + 1);
                    return getPermutations(remaining).stream().map(permutation -> currentChar + permutation);
                })
                .collect(Collectors.toList());
    }

    static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        }
        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end);
            str = swap(str, start, i);
        }
    }

    static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String str = "ROSPUG";
        //permute(str, 0, str.length() - 1);
        List<String> result = getPermutations(str);
        for(String s: result) {
            System.out.println(s);
        }
    }
}

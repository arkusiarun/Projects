package programs;

public class StringCompression {

    public static String compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (ch == chars[i]) {
                count++;
            } else {
                sb.append(ch);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
                ch = chars[i];
            }
        }
        sb.append(ch);
        if (count > 1) {
            sb.append(count);
        }
        String compressedStr = sb.toString();
        char[] compressedChars = compressedStr.toCharArray();
        for (int i = 0; i < compressedChars.length; i++) {
            chars[i] = compressedChars[i];
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        char[] ch1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] ch2 = new char[]{'a'};
        char[] ch3 = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(ch1));
        System.out.println(compress(ch2));
        System.out.println(compress(ch3));
    }
}

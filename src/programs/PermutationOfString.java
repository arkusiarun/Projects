package programs;

public class PermutationOfString {

    static void permute(String str, int start, int end) {
        if(start == end) {
            System.out.println(str);
        }
        for(int i=start;i<=end;i++) {
            str = swap(str, start, i);
            permute(str, start+1, end);
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
        String str = "abc";
        permute(str, 0, str.length()-1);
    }
}

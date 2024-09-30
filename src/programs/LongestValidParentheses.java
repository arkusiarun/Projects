package programs;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String input1 = "(()";
        String input2 = ")()())";
        String input3 = "";
        System.out.println("Input : " + input1 + " Length is : " + longestValidParentheses(input1));
        System.out.println("Input : " + input2 + " Length is : " + longestValidParentheses(input2));
        System.out.println("Input : " + input3 + " Length is : " + longestValidParentheses(input3));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
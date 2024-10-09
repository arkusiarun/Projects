package programs;

import java.util.Stack;

public class ValidParenthesis {

    static boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>();
        for(Character c: s.toCharArray()) {
            if(pushAllowed(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(getCounterPart(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean pushAllowed(char ch) {
        if(ch == '(' || ch == '{' || ch == '[') {
            return true;
        }
        return false;
    }

    static Character getCounterPart(char ch) {
        if(ch == ')' ) {
            return '(';
        }
        if(ch == '}' ) {
            return '{';
        }
        if(ch == ']' ) {
            return '[';
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }
}

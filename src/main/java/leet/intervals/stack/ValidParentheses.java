package leet.intervals.stack;

import java.util.Stack;
//20
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        //String s="[{()[]}()]";
        String s = "()";
        System.out.println(vp.isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> paranthesis = new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '(')
                paranthesis.push(')');
            else if(s.charAt(i) == '{')
                paranthesis.push('}');
            else if(s.charAt(i) == '[')
                paranthesis.push(']');
            else if(paranthesis.isEmpty() || paranthesis.pop() !=s.charAt(i))
                return false;
        }

        return paranthesis.isEmpty();
    }
}

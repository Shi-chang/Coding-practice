import java.util.Stack;

public class LC20ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character curPair = stack.pop();
                if (curChar == ')' && curPair != '(') {
                    return false;
                }
                if (curChar == '}' && curPair != '{') {
                    return false;
                }
                if (curChar == ']' && curPair != '[') {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}

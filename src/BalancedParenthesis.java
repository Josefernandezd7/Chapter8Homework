import java.util.Stack;

public class BalancedParenthesis {
    public static boolean isBalanced2(String parentheses) {
        Stack<Character> stack = new Stack<>();

        for (char c : parentheses.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
             } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
               } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
             } else {
                return false;
              }
         }
        return stack.isEmpty();
    }

         public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced2("{([])}")); // Output: true
        System.out.println(isBalanced2("()[]{}")); // Output: true
        System.out.println(isBalanced2("(]")); // Output: false
        System.out.println(isBalanced2("[(])")); // Output: false
      }
}


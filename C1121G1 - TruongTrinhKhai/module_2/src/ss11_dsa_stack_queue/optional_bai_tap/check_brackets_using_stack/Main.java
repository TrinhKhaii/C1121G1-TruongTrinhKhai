package ss11_dsa_stack_queue.optional_bai_tap.check_brackets_using_stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String myStr = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        Stack<Character> myStack = new Stack<>();
        boolean check = true;
        for (int i = 0; i < myStr.length(); i++) {
            if (myStr.charAt(i) == '(') {
                myStack.push('(');
            }
            if (myStr.charAt((i)) == ')') {
                if (myStack.isEmpty()) {
                    check = false;
                    break;
                }
                myStack.pop();
            }
        }
        if (!myStack.isEmpty()) {
            check = false;
        }

        System.out.println("Result: " + check);

    }
}

package ss11_dsa_stack_queue.optional_bai_tap.checking_palindrome_strings_using_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String myStr = "able was I ere I saw elba";
        Stack<Character> myStack = new Stack<>();
        Queue<Character> myQueue = new LinkedList<>();
        for (int i = 0; i < myStr.length(); i++) {
            myStack.push(myStr.charAt(i));
            myQueue.add(myStr.charAt(i));
        }
        System.out.println("String: " + myStr);
        boolean result = true;
        while (!myStack.isEmpty()) {
            if (myStack.pop() != myQueue.remove()) {
                result = false;
                break;
            }
        }
        System.out.println("Result: " + result);
    }
}

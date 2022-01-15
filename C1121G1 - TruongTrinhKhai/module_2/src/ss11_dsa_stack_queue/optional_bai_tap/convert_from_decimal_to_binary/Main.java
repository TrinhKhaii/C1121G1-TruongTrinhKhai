package ss11_dsa_stack_queue.optional_bai_tap.convert_from_decimal_to_binary;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int num = 30;
        Stack<Integer> myStack = new Stack<>();
        while (num != 0) {
            myStack.push(num % 2);
            num /= 2;
        }
        System.out.println("My number: " + num);
        System.out.print("Result: ");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop());
        }
    }
}

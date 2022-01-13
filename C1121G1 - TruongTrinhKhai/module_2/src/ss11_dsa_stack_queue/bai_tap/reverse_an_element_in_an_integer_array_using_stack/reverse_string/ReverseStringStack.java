package ss11_dsa_stack_queue.bai_tap.reverse_an_element_in_an_integer_array_using_stack.reverse_string;

import java.util.Stack;

public class ReverseStringStack {
    public static void main(String[] args) {
        Stack<Character> stringStack = new Stack<>();
        String str = "Khai";
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(str.charAt(i));
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += stringStack.pop();
        }
        System.out.println("Result: " + result);
    }
}

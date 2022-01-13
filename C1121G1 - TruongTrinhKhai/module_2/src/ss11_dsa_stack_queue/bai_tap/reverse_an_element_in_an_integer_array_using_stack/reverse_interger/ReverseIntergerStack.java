package ss11_dsa_stack_queue.bai_tap.reverse_an_element_in_an_integer_array_using_stack.reverse_interger;

import java.util.Stack;

public class ReverseIntergerStack {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int[] arrays = {1, 2, 3, 4};
        for (int i = 0; i < arrays.length; i++) {
            integerStack.push(arrays[i]);
        }
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = integerStack.pop();
        }
        System.out.println("st: " + integerStack);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + ", ");
        }
    }

}

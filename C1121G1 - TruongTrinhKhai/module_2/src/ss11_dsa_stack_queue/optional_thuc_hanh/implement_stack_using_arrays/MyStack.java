package ss11_dsa_stack_queue.optional_thuc_hanh.implement_stack_using_arrays;

public class MyStack {
    private int[] arr;
    private int size;
    private int index;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index++] = element;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is full");
        }
        return arr[--index];
    }

    public int size() {
        return size;
    }
}

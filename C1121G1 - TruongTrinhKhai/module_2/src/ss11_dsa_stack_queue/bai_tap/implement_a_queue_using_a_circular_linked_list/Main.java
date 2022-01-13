package ss11_dsa_stack_queue.bai_tap.implement_a_queue_using_a_circular_linked_list;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(14);
        q.enQueue(15);
        q.enQueue(16);
        q.enQueue(17);
        q.displayQueue();
        q.deQueue();
        q.displayQueue();
    }

}

package ss11_dsa_stack_queue.bai_tap.implement_a_queue_using_a_circular_linked_list;


public class Queue {
    private class Node {
        private int data;
        private Node link;
    }

    private Node front;
    private Node rear;

    public Queue() {
    }

    public void enQueue(int value) {
        Node temp = new Node();
        temp.data = value;
        if (this.front == null) {
            this.front = temp;
        } else {
            this.rear.link = temp;
        }
        this.rear = temp;
        this.rear.link = this.front;
    }

    public int deQueue() {
        if (this.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (this.front == this.rear) {
            value = this.front.data;
            this.front = null;
            this.rear = null;
        } else {
            Node temp = this.front;
            value = temp.data;
            this.front = this.front.link;
            this.rear.link = this.front;
        }
        return value;
    }

    public void displayQueue() {
        Node temp = this.front;
        System.out.print("Elements in Circular Queue are: ");
        while (temp.link != this.front) {
            System.out.print(temp.data + ", ");
            temp = temp.link;
        }
        System.out.println(temp.data);
    }
}


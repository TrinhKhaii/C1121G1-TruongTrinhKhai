package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_linked_list;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public MyLinkedList(E data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E data) {
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        numNodes++;
    }

    public E remove(int index) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = holder.next;
        holder.next = null;
        return (E) holder;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp= temp.next;
        }
    }
}

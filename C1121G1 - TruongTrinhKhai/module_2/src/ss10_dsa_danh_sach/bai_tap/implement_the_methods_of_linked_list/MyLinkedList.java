package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_linked_list;

import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.animal.Animal;

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
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Error index: " + index);
        }
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
        if(index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        Node temp = head;
        Node holder;
        if (index == 0) {
            holder = head;
            head = head.next;
            holder.next = null;
            return (E) (temp.data);
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = holder.next;
        holder.next = null;
        numNodes--;
        return (E) (holder.data);
    }

    public boolean remove(E e) {
        if (head.data.equals(e)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while(temp.next != null) {
                if (temp.next.data.equals(e)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp= temp.next;
            }
            return false;
        }
    }

    public MyLinkedList<E> clone() {
        if (numNodes == 0) {
            throw new NullPointerException("LinkedList null");
        }
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnLinkedList.addLast((E)temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean contain(E o) {
        Node temp = head;
        while (temp!= null) {
            if(temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean add(E o) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(o);
        temp.next = newNode;
        newNode.next = null;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if(i == index) {
                return (E) (temp.data);
            }
            temp = temp.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    public E getFirst() {
        return (E) (head.data);
    }

    public E getLast() {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return (E) (temp.data);
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp= temp.next;
        }
    }

    public void clear() {
        head = null;
    }
}

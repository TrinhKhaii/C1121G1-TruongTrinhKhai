package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addFirst(14);
        ll.addFirst(15);

        ll.add(2, 9);
        ll.add(3, 9);
        ll.addFirst(16);
        ll.addLast(10);

        ll.printList();
        Integer e = new Integer(160);
        int i = 1;
        System.out.println();
        System.out.println("Remove: " + ll.remove(i));
        System.out.println("Contain: " + ll.contain(15));
        System.out.println("Index: " + ll.indexOf(14));
        System.out.println("Index 2: " + ll.get(7));
        System.out.println("First: " + ll.getFirst());
        System.out.println("Last: " + ll.getLast());
        ll.printList();
        System.out.println();
        System.out.println("New Linked List: ");
        MyLinkedList<Integer> cloneLinkedList = ll.clone();
        cloneLinkedList.printList();
        System.out.println();
        System.out.println("Clear: ");
        ll.clear();
        ll.printList();
    }
}

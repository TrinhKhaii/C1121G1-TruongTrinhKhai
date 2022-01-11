package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
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
        ll.remove(5);
        System.out.println();
        ll.printList();
    }
}

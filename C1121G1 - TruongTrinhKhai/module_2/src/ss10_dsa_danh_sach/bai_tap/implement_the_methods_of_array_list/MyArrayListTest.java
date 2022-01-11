package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_array_list;



public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> listInteger = new MyArrayList<Integer>();
        listInteger.add(0, 1);
        listInteger.add(1, 2);
        listInteger.add(2, 3);
        listInteger.add(3, 4);
        listInteger.add(4, 5);
        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
        System.out.println("Check: " + listInteger.contains(9));
        System.out.println("Index: " + listInteger.indexOf(10));
        listInteger.clear();
        System.out.println("element 4: "+listInteger.get(0));
    }
}

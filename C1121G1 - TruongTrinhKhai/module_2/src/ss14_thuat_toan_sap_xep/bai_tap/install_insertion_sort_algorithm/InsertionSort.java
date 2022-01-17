package ss14_thuat_toan_sap_xep.bai_tap.install_insertion_sort_algorithm;

public class InsertionSort {
    static int[] list = {1, 2, 2, 3, 3, 5, 6, 12, 14, -2};

    public static void insertionSort(int[] list) {
        int pos;
        int x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("Before: ");
        for (int i : list) {
            System.out.print(i + ", ");
        }
        insertionSort(list);
        System.out.println();
        System.out.println("After: ");
        for (int i : list) {
            System.out.print(i + ", ");
        }
    }
}

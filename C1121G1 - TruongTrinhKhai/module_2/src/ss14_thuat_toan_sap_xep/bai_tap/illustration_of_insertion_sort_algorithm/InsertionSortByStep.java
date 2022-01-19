package ss14_thuat_toan_sap_xep.bai_tap.illustration_of_insertion_sort_algorithm;

public class InsertionSortByStep {
    static int[] list = {3, 2, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        int pos;
        int x;
        boolean flag;
        for (int i = 1; i < list.length; i++) {
            flag = false;
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                System.out.println("Swap " + list[pos] + " of index " + pos + " with " + list[pos - 1] + " of index " + (pos - 1));
                list[pos] = list[pos - 1];
                pos--;
                flag = true;
            }
            if (flag) {
                System.out.println("Ater that swap " + x + " of index " + i + " with " + list[pos]+ " of index " + pos);
            } else {
                System.out.println("Nothing happen!");
            }
            list[pos] = x;

            System.out.print("List after the  " + i + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }
}

package ss15_xu_li_ngoai_le_va_debug.thuc_hanh.use_array_index_out_of_bounds_exception;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List elements of arr: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + ", ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the random index of element: ");
        int x = sc.nextInt();
        try {
            System.out.println("Value of element with index " + x + " is " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds exception.");
        }
    }
}

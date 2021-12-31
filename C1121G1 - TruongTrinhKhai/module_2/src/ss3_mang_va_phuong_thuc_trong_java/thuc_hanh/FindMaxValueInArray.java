package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindMaxValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20.");
            }
        } while (size > 20);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value of element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("My array: ");
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            System.out.print(i + "\t");
        }
        System.out.println("\nMax value: " + max);

    }
}

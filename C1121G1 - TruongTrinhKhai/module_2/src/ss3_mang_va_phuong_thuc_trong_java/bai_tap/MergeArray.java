package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 11};
        int[] arr2 = {7, 9, 8, 10};
        System.out.println("My first array: " + Arrays.toString(arr1));
        System.out.println("My second array: " + Arrays.toString(arr2));
        int[] newArray = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            newArray[i + arr1.length] = arr2[i];
        }
        System.out.println("My new array: " + Arrays.toString(newArray));

    }
}

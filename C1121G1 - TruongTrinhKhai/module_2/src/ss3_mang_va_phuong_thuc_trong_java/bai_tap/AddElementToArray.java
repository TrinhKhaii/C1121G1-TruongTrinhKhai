package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("My array: " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.print("Add new element at index: ");
        int newElementIndex = sc.nextInt();
        System.out.print("Element value: ");
        int newElementValue = sc.nextInt();
        if (newElementIndex < arr.length) {
            int[] newArr = new int[arr.length + 1];
            for (int i = 0, j = 0; i < arr.length; i++, j++) {
                if (i == newElementIndex) {
                    j++;
                }
                newArr[j] = arr[i];
            }
            newArr[newElementIndex] = newElementValue;
            System.out.println("My new array: " + Arrays.toString(newArr));
        } else {
            System.out.println("Your new index is greater than or less than current array!");
//            int[] newArr2 = new int[newElementIndex + 1];
//            for (int i = 0; i < arr.length; i++) {
//                newArr2[i] =  arr[i];
//            }
//            newArr2[newElementIndex] = newElementValue;
//            System.out.println("My new array: " + Arrays.toString(newArr2));
        }


    }
}

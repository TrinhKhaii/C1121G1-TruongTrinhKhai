package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class CountStudentsPassingTheExam {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        int count = 0;
        System.out.println("List of mark: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
            if (array[i] >= 5 && array[i] <= 10) {
                count++;
            }
        }
        System.out.print("\nThe number of students passing the exam is " + count);
    }
}

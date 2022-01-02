package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfSpecifiedColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size of matrix: ");
            size = sc.nextInt();
            if (size > 10) {
                System.out.println("Size does not exceed 10");
            }
        } while (size > 10);
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print("Enter value of element arr[" + row + "][" + col + "]: ");
                matrix[row][col] = sc.nextInt();
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + ", ");
            }
            System.out.println();
        }
        int index;
        do {
            System.out.print("Enter the column you want to sum: ");
            index = sc.nextInt();
            if (index < 0 && index > size) {
                System.out.println("Size does not exceed 10");
            }
        } while (index > size);
        int sum = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            sum += matrix[index][i];
        }
        System.out.print("Sum of the column " + index + " is: " + sum);
    }
}

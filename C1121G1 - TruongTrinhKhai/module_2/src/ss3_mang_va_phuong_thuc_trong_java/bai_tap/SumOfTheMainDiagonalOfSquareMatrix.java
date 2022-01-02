package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfTheMainDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter the size of matrix: ");
        size = sc.nextInt();
        int[][] squareMatrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print("Enter the value of matrix[" + row + "][" + col + "]: ");
                squareMatrix[row][col] = sc.nextInt();
            }
        }
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    sum += squareMatrix[row][col];
                }
                System.out.print(squareMatrix[row][col] + ", ");
            }
            System.out.println();
        }
        System.out.println("Sum of the main diagonal: " + sum);
    }
}

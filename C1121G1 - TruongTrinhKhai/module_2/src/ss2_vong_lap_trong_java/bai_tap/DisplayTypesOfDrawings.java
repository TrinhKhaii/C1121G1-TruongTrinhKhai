package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayTypesOfDrawings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu:\n 1.Print the rectangle.\n 2.Draw the square.\n" +
                " 3.Print isosceles triangle.\n 4.Exit.\nEnter your choice: ");

        while (true) {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    int width = 5;
                    int heightRec = 15;
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < heightRec; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < 5; i++) {
                        for (int k = 4 - i; k > 0; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < 5; i++) {
                        for (int k = 0; k < i; k++) {
                            System.out.print(" ");
                        }
                        for (int j = 5 - i; j > 0; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int heightTriangle = 5;
                    for (int i = 1; i < heightTriangle + 1; i++) {
                        for (int j = 5 - i; j > 0; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < ((i * 2) - 1); k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}

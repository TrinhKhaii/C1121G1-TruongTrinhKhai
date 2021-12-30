package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class DesignMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu:\n 1.Draw the triangle.\n 2.Draw the square.\n" +
                " 3.Draw the rectangle.\n 4.Exit.\nEnter your choice: ");

        while (true) {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("*  ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 15; j++) {
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

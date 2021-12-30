package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class Display20FirstPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();;

        int count = 0;
        int i = 2;
        while (count <= input) {

            boolean check = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                if (count == 20) {
                    System.exit(0);
                }
                count++;
                System.out.print(i + ", ");
            }
            i++;
        }
    }
}

package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        boolean check = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.print(num + " is a prime number!");
        } else {
            System.out.print(num + " is not a prime number!");
        }
    }
}

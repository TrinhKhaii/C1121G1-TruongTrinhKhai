package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class TinhTienLaiChoVay {
    public static void main(String[] args) {
        double money;
        int month;
        double interest_rate;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        money = sc.nextDouble();
        System.out.print("Enter number of months: ");
        month = sc.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        interest_rate = sc.nextDouble();
        double total_interest = 0;
        for (int i = 0; i < month; i++) {
            total_interest = money + (interest_rate / 100 / 12) * 3;
        }
        System.out.println("Total of interest: " + total_interest);
    }
}

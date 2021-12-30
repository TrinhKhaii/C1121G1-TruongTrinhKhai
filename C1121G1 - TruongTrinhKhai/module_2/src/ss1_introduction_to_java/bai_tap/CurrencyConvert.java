package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConvert {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USD money: ");
        usd = scanner.nextDouble();
        double result = usd * vnd;
        System.out.print("VND: " + result);
    }
}

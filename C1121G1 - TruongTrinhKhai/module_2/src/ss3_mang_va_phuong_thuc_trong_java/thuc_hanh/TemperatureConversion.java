package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        System.out.println("Menu\n1. Fahrenheit to Celsius\n" +
                "2. Celsius to Fahrenheit\n" +
                "0. Exit ");
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int input;
        double celsius;
        double fahrenheit;
        do {
            System.out.print("Your choice is: ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.print("Enter fahrenheit value: ");
                    fahrenheit = sc.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter celsius value: ");
                    celsius = sc.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    check = false;
            }
        } while (check);
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
}

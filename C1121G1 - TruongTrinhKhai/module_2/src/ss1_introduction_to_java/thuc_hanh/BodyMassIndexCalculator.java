package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndexCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight: ");
        double weight = scanner.nextFloat();
        System.out.print("Enter your height: ");

        double height = scanner.nextFloat();
        double bmi = weight / Math.pow(height, 2);

        if (bmi < 18.5) {
            System.out.print("Underweight");
        } else if (bmi < 25.0) {
            System.out.print("Normal");
        } else if (bmi < 30) {
            System.out.print("Overweight");
        } else {
            System.out.print("Obese");
        }
    }
}

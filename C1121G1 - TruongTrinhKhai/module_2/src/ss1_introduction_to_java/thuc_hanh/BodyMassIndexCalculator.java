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
//
//        if (bmi < 18.5) {
//            System.out.print("Underweight");
//        } else if (bmi < 25.0) {
//            System.out.print("Normal");
//        } else if (bmi < 30) {
//            System.out.print("Overweight");
//        } else {
//            System.out.print("Obese");
//        }

        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}

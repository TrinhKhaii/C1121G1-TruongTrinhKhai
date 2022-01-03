package ss4_lop_va_doi_tuong_trong_java.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Equation ax^2 + bx + c = 0: ");
        System.out.print("Enter number a: ");
        double a = sc.nextDouble();
        System.out.print("Enter number b: ");
        double b = sc.nextDouble();
        System.out.print("Enter number c: ");
        double c = sc.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        if (equation.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("The equation has 1 root only: " + equation.getOneRootOnly());
        } else {
            System.out.println("The equation has 2 roots: \n" + "Root 1: " + equation.getRoot1() +
                    "\nRoot 2: " + equation.getRoot2());
        }
    }
}

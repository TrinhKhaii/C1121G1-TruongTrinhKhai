package ss15_xu_li_ngoai_le_va_debug.bai_tap.use_illegal_triangle_exception_class;

import java.util.Scanner;

public class TriangleExample {
    public static void createTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 > side3 && side1 + side3 > side3 && side2 + side3 > side1 && side1 > 0 && side2 > 0 && side3 > 0) {
            System.out.println("New triangle created with side 1 = " + side1 + ", side 2 = " + side2 + ", side 3 = " + side3 + ".");
        } else {
            throw new IllegalTriangleException(side1, side2, side3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter side 1: ");
            double side1 = Double.parseDouble(sc.nextLine());
            System.out.print("Enter side 2: ");
            double side2 = Double.parseDouble(sc.nextLine());
            System.out.print("Enter side 3: ");
            double side3 = Double.parseDouble(sc.nextLine());
            createTriangle(side1, side2, side3);
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        }
    }
}

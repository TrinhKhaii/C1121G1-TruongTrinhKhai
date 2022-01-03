package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = sc.nextDouble();
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();
        Rectangle rec = new Rectangle(width, height);
        System.out.println("Your rectangle: \n" + rec.display());
        System.out.println("Perimeter of rectangle: " + rec.getPerimeter());
        System.out.println("Area of rectangle: " + rec.getArea());

    }
}

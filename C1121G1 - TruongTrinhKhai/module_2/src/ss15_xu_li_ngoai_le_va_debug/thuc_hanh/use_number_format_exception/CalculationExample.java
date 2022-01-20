package ss15_xu_li_ngoai_le_va_debug.thuc_hanh.use_number_format_exception;

import java.util.Scanner;

public class CalculationExample {
    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Sum of x + y = " + a);
            System.out.println("Difference of x - y = " + b);
            System.out.println("Product of x * y = " + c);
            System.out.println("Quotient of x / y = " + d);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Enter y: ");
        int y = Integer.parseInt(sc.nextLine());
        CalculationExample calc = new CalculationExample();
        calc.calculate(x, y);
    }
}

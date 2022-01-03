package ss4_lop_va_doi_tuong_trong_java.bai_tap.quadratic_equation;

public class QuadraticEquation {

    // ax^2 + bx +c = 0
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getOneRootOnly() {
        return -(this.b) / (2 * this.a);
    }

    public double getRoot1() {
        return (-(this.b) + Math.pow(getDiscriminant(), 0.5)) / 2 * this.a;
    }

    public double getRoot2() {
        return (-(this.b) - Math.pow(getDiscriminant(), 0.5)) / 2 * this.a;
    }
}





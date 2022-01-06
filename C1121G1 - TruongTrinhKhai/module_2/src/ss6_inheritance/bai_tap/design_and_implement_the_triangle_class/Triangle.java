package ss6_inheritance.bai_tap.design_and_implement_the_triangle_class;

import ss6_inheritance.thuc_hanh.geometric_objects.Shape;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(float side1, float side2, float side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public double getArea() {
        return Math.sqrt(getPerimeter() * (getPerimeter() - getSide1()) *
                (getPerimeter() - getSide2()) * (getPerimeter() - getSide3()));
    }

    @Override
    public String toString() {
        return "A Triangle with Perimeter=" + getPerimeter() +
                ", Area=" + getArea() + ", color=" + getColor();
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        System.out.println(t1);

        Triangle t2 = new Triangle(3, 4, 5);
        t2.setColor("red");
        System.out.println(t2);
    }
}

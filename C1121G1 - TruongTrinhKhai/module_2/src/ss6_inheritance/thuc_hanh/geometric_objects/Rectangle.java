package ss6_inheritance.thuc_hanh.geometric_objects;

import ss7_abstract_class_and_interface.bai_tap.interface_resizeable.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double length;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return this.width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getLength() {
        return this.length;
    }

    public double getArea() {
        return this.getWidth() * this.getLength();
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + this.getWidth() +
                " and length=" + this.getLength() + ", which is a subclass of " +
                super.toString();
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() * percent);
        setLength(getLength() * percent);
    }
}

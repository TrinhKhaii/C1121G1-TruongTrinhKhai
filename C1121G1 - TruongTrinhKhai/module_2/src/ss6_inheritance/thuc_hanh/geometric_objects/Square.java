package ss6_inheritance.thuc_hanh.geometric_objects;

import ss7_abstract_class_and_interface.bai_tap.interface_colorable.Colorable;
import ss7_abstract_class_and_interface.bai_tap.interface_resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {}
    public Square(double side) {
        super(side, side);
    }
    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public double getSide() {
        return getLength();
    }

    @Override
    public String toString() {
        return "A Square with side=" + this.getSide() + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() * percent);
    }

    @Override
    public void howToColor() {
        System.out.println("A Squar color is " + getColor() + " all four sides..");
    }
//    public static void main(String[] args) {
//        Square s = new Square();
//        System.out.println(s);
//
//        Square s2 = new Square("hihi", true, 10);
//        System.out.println(s2);
//    }
}

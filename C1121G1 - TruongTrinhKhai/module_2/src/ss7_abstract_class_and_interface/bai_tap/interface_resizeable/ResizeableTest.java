package ss7_abstract_class_and_interface.bai_tap.interface_resizeable;

import ss6_inheritance.thuc_hanh.geometric_objects.Circle;
import ss6_inheritance.thuc_hanh.geometric_objects.Rectangle;
import ss6_inheritance.thuc_hanh.geometric_objects.Shape;
import ss6_inheritance.thuc_hanh.geometric_objects.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1.0);
        shapes[1] = new Rectangle(2,3);
        shapes[2] = new Square(4);

        System.out.println("Pre-Resize: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        for(Shape shape : shapes) {
            ((Resizeable) shape).resize(0.5);
        }

        System.out.println("After-Resized: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}

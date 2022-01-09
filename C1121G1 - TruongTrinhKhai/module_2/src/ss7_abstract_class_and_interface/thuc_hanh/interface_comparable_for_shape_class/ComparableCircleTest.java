package ss7_abstract_class_and_interface.thuc_hanh.interface_comparable_for_shape_class;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("indigo", false, 3.5);
        System.out.println("Pre-sort: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}

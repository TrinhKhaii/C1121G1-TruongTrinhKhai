package ss5_access_modifier_static_method_static_property.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.2);
        System.out.println("color: " + c1.getColor());
        System.out.println("radius: " + c1.getRadius());
    }
}

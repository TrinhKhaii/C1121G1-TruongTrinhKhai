package ss6_inheritance.bai_tap.circle_class_and_cylinder_class;

public class Cylinder extends Circle{
    private double height;
    public Cylinder() {
        this.height = 1.0;
    }
    public Cylinder(double height) {
        this.height = height;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * this.getRadius() * (this.getRadius() + this.getHeight());
    }

    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * getHeight();
    }

    @Override
    public String toString() {
        return "A Cylinder with height=" + this.getHeight() + ", which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);

        Circle circle2 = new Circle(5.0, "red");
        System.out.println(circle2);

        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);

        Cylinder cylinder2 = new Cylinder(5.0, "green", 10.0);
        System.out.println(cylinder2);
        System.out.println("Area of cylinder2: " + cylinder2.getArea());
        System.out.println("Volume of cylinder2: " + cylinder2.getVolume());
    }
}

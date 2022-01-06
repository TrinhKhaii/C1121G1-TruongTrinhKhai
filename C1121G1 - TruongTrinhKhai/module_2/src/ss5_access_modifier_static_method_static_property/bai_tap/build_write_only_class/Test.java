package ss5_access_modifier_static_method_static_property.bai_tap.build_write_only_class;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Class: " + s1.getClassName());
        System.out.println("Name: " + s1.getName());
        s1.setName("Khai");
        s1.setClassName("C1121G1");
        System.out.println("Class: " + s1.getClassName());
        System.out.println("Name: " + s1.getName());
    }
}

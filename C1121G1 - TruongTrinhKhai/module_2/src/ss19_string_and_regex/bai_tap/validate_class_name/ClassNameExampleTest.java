package ss19_string_and_regex.bai_tap.validate_class_name;

public class ClassNameExampleTest {
    private static ClassNameExample classNameExample;
    public static final String[] validName = new String[] {"C0318G", "A8374M"};
    public static final String[] invalidName = new String[] {"M0318G", "P0323A", "l9999G", "C11221G"};

    public static void main(String[] args) {
        classNameExample = new ClassNameExample();
        for (String className: validName) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class name is " + className + " is valid: " + isValid);
        }
        for (String className: invalidName) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class name is " + className + " is valid: " + isValid);
        }
    }
}

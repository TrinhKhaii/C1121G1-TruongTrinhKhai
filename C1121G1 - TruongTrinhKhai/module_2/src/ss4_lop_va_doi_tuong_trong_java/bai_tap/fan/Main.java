package ss4_lop_va_doi_tuong_trong_java.bai_tap.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Fan fan1 = new Fan(3, "on", 10, "yellow");
        Fan fan2 = new Fan(2, "off", 5, "blue");
        System.out.println(fan);
        System.out.println(fan1);
        System.out.println(fan2);
    }
}

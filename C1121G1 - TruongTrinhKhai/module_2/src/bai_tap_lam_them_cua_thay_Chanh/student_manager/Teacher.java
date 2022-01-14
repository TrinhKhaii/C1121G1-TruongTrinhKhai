package bai_tap_lam_them_cua_thay_Chanh.student_manager;

public class Teacher extends Person {
    private String position;
    private double salary;
    static private int countTeacher = 0;

    public Teacher() {
    }

    public Teacher(int id, String name, String address, String birthday, String position, double salary) {
        super(id, name, address, birthday);
        this.position = position;
        this.salary = salary;
        countTeacher++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getCountTeacher() {
        return countTeacher;
    }

    public static void decreaseCountTeacher() {
        countTeacher--;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

package bai_tap_lam_them_cua_thay_Chanh.student_manager;

public class Student extends Person {

    private String className;
    private String school;
    private int point = 10;
    static private int countStudent = 0;

    public Student() {
        countStudent++;
    }

    public Student(int id, String name, String address, String birthday, String className, String school) {
        super(id, name, address, birthday);
        this.className = className;
        this.school = school;
        countStudent++;
    }

    public Student(int id, String name, String address, String birthday, String className, String school, int point) {
        this(id, name, address, birthday, className, school);
        this.point = point;
        countStudent++;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public static int getCountStudent() {
        return countStudent;
    }


    public static void decreaseCountStudent() {
        countStudent--;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", className='" + className + '\'' +
                ", school='" + school + '\'' +
//                ", point=" + point +
                '}';
    }
}

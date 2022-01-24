package ss17_io_binary_file_and_serialization.thuc_hanh.read_and_write_list_of_students_to_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> students) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        writeToFile("src/ss17_io_binary_file_and_serialization/thuc_hanh/read_and_write_list_of_students_to_binary_file/Students.txt", students);
        List<Student> studentsDataFromFile = readDataFromFile("src/ss17_io_binary_file_and_serialization/thuc_hanh/read_and_write_list_of_students_to_binary_file/Students.txt");
        for (Student student: studentsDataFromFile) {
            System.out.println(student);
        }
    }
}

package bai_tap_lam_them_cua_thay_Chanh.student_manager;

import java.util.Scanner;

public class StudentManager {
    Scanner sc = new Scanner(System.in);
    Student[] studentList = new Student[100];

    public void add() {
        System.out.println("Enter student information: ");
        System.out.print("Id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Date of birth: ");
        String birthday = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Class name: ");
        String className = sc.nextLine();

        System.out.print("School name: ");
        String school = sc.nextLine();

        Student student = new Student(id, name, address, birthday, className, school);
        studentList[Student.getCountStudent() - 1] = student;
    }

    public void display() {
        if (Student.getCountStudent() == 0) {
            System.out.println("Empty List.");
        } else {
            for (int i = 0; i < Student.getCountStudent(); i++) {
                System.out.println(studentList[i]);
            }
        }
    }

    public void edit(int id) {
        if (Student.getCountStudent() == 0) {
            System.out.println("List empty!");
        }
        for (int i = 0; i < Student.getCountStudent(); i++) {
            if (studentList[i].getId() == id) {
                System.out.println(studentList[i]);
                System.out.println("Edit student information: ");
                System.out.println("Current Id: " + studentList[i].getId());
                System.out.print("New id: ");
                int newId = Integer.parseInt(sc.nextLine());
                studentList[i].setId(newId);

                System.out.println("Current Name: " + studentList[i].getName());
                System.out.print("New Name: ");
                String newName = sc.nextLine();
                studentList[i].setName(newName);

                System.out.println("Current Date of birth: " + studentList[i].getBirthday());
                System.out.print("New Birthday: ");
                String newBirthday = sc.nextLine();
                studentList[i].setBirthday(newBirthday);

                System.out.println("Current Address: " + studentList[i].getAddress());
                System.out.print("New Address: ");
                String newAddress = sc.nextLine();
                studentList[i].setAddress(newAddress);

                System.out.println("Current Class name: " + studentList[i].getClassName());
                System.out.print("New Class name: ");
                String newClassName = sc.nextLine();
                studentList[i].setClassName(newClassName);

                System.out.println("Current School: " + studentList[i].getSchool());
                System.out.print("New School: ");
                String newSchool = sc.nextLine();
                studentList[i].setSchool(newSchool);

                System.out.println();
                System.out.println("After edit: " + studentList[i]);
            } else {
                System.out.println("student List dont have Student Id " + id);
            }
        }
    }

    public void delete(int id) {
        int count = 0;
        if (Student.getCountStudent() == 0) {
            System.out.println("Empty List.");
        } else {
            for (int i = 0; i < Student.getCountStudent(); i++) {
                if (studentList[i].getId() == id) {
                    count++;
                    System.out.println("Student you want to delete: " + studentList[i]);

                    for (int j = i; j < Student.getCountStudent() - i - 1; j++) {
                        if (j < Student.getCountStudent() - 1 - i) {
                            studentList[j] = studentList[j + 1];
                        } else {
                            studentList[j] = null;
                        }
                    }
                    i--;
                }
            }
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    Student.decreaseCountStudent();
                }
            }
        }
    }

    public void search(int id) {
        boolean flag = false;
        for (int i = 0; i < Student.getCountStudent(); i++) {
            if (studentList[i].getId() == id) {
                System.out.println("Student with id=" + (i + 1) + ": " + studentList[i]);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Student list dont have student with id=" + id);
        }
    }
}

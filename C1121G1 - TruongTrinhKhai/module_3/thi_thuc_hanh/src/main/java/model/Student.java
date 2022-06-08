package model;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:26
*/

public class Student {
    private Integer studentId;
    private String studentName;
    private String studentClassName;

    public Student() {}

    public Student(Integer studentId, String studentName, String studentClassName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClassName = studentClassName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }
}

package model;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 18:58
*/

public class LibraryCardDTO {
    private String libraryCardId;
    private String bookName;
    private String bookAuthor;
    private String studentName;
    private String studentClassName;
    private String startDate;
    private String endDate;

    public LibraryCardDTO() {}

    public LibraryCardDTO(String libraryCardId, String bookName, String bookAuthor, String studentName, String studentClassName, String startDate, String endDate) {
        this.libraryCardId = libraryCardId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.studentName = studentName;
        this.studentClassName = studentClassName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(String libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

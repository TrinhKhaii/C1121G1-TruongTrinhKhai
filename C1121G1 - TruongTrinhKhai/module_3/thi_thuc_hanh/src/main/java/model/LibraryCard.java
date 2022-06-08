package model;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:31
*/

public class LibraryCard {
    private String libraryCardId;
    private String bookId;
    private Integer studentId;
    private String startDate;
    private String endDate;

    public LibraryCard() {
    }

    public LibraryCard(String libraryCardId, String bookId, Integer studentId, String startDate, String endDate) {
        this.libraryCardId = libraryCardId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(String libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

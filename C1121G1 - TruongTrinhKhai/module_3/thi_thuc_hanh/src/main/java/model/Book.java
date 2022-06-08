package model;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:24
*/

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private Integer amount;
    private String description;

    public Book() {}

    public Book(String bookId, String bookName, String author, Integer amount, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.amount = amount;
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

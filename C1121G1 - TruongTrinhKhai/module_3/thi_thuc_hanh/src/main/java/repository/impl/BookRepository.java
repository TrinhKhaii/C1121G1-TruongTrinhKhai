package repository.impl;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:36
*/

import model.Book;
import model.LibraryCard;
import model.LibraryCardDTO;
import model.Student;
import repository.IBookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_BOOK = "select * from book";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String SELECT_ALL_LIBRARY_CARD_DTO = "select library_card_id, book.book_name, book.author, student.student_name, student.student_class_name, start_date, end_date\n" +
            "from library_card\n" +
            "inner join book on library_card.book_id = book.book_id\n" +
            "inner join student on library_card.student_id = student.student_id;";
    private static final String SELECT_BOOK_BY_ID = "select * from book where book_id = ?;";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where student_id = 1;";
    private static final String INSERT_INTO_LIBRARY_CARD = "insert into library_card(library_card_id, book_id, student_id, start_date, end_date)\n" +
            "values (?, ?, ?, ?, ?);";
    @Override
    public List<Book> findAllBook() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK)) {
            System.out.println(SELECT_ALL_BOOK);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                Integer amount = rs.getInt("amount");
                bookList.add(new Book(bookId, bookName, author, amount, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            System.out.println(SELECT_ALL_STUDENT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String studentClassName = rs.getString("student_class_name");
                studentList.add(new Student(studentId, studentName, studentClassName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<LibraryCardDTO> findAllLibraryCardDTO() {
        List<LibraryCardDTO> libraryCardDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIBRARY_CARD_DTO)) {
            System.out.println(SELECT_ALL_LIBRARY_CARD_DTO);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String libraryCardId = rs.getString("library_card_id");
                String bookName = rs.getString("book_name");
                String bookAuthor = rs.getString("author");
                String studentName = rs.getString("student_name");
                String studentClassName = rs.getString("student_class_name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                libraryCardDTOList.add(new LibraryCardDTO(libraryCardId, bookName, bookAuthor, studentName, studentClassName, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraryCardDTOList;
    }

    @Override
    public Book findBookById(String bookId) {
        Book book = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            System.out.println(SELECT_BOOK_BY_ID);
            preparedStatement.setString(1, bookId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("book_id");
                String name = rs.getString("book_name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                Integer amount = rs.getInt("amount");
                book = new Book(id, name, author, amount, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Student findStudentById(Integer studentId) {
        Student student = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            System.out.println(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String className = rs.getString("student_class_name");
                student = new Student(id, name, className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void insertLibrabyCard(LibraryCard libraryCard) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_LIBRARY_CARD)) {
            System.out.println(INSERT_INTO_LIBRARY_CARD);
            preparedStatement.setString(1, libraryCard.getLibraryCardId());
            preparedStatement.setString(2, libraryCard.getBookId());
            preparedStatement.setInt(3, libraryCard.getStudentId());
            preparedStatement.setString(4, libraryCard.getStartDate());
            preparedStatement.setString(5, libraryCard.getEndDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

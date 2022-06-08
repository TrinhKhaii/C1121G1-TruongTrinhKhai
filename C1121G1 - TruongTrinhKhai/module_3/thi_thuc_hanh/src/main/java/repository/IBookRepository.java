package repository;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:34
*/

import model.Book;
import model.LibraryCard;
import model.LibraryCardDTO;
import model.Student;

import java.util.List;

public interface IBookRepository {
    List<Book> findAllBook();

    List<Student> findAllStudent();

    List<LibraryCardDTO> findAllLibraryCardDTO();

    Book findBookById(String bookId);

    Student findStudentById(Integer studentId);

    void insertLibrabyCard(LibraryCard libraryCard);
}

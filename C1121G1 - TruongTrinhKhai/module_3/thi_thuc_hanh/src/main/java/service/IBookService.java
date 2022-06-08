package service;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:35
*/

import model.Book;
import model.LibraryCard;
import model.LibraryCardDTO;
import model.Student;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    List<Student> findAllStudent();

    List<LibraryCardDTO> findAllLibraryCardDTO();
    
    Book findBookById(String bookId);

    Student findStudentById(Integer studentId);

    void insertLibrabyCard(LibraryCard libraryCard);
}

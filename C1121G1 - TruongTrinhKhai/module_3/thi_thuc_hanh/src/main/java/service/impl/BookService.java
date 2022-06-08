package service.impl;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:35
*/

import model.Book;
import model.LibraryCard;
import model.LibraryCardDTO;
import model.Student;
import repository.IBookRepository;
import repository.impl.BookRepository;
import service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    private final IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAllBook();
    }

    @Override
    public List<Student> findAllStudent() {
        return bookRepository.findAllStudent();
    }

    @Override
    public List<LibraryCardDTO> findAllLibraryCardDTO() {
        return bookRepository.findAllLibraryCardDTO();
    }

    @Override
    public Book findBookById(String bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public Student findStudentById(Integer studentId) {
        return bookRepository.findStudentById(studentId);
    }

    @Override
    public void insertLibrabyCard(LibraryCard libraryCard) {
        bookRepository.insertLibrabyCard(libraryCard);
    }
}

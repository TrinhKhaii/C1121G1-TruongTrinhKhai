package controller;
/*
    Created by Trinh Khai
    Date: 27/03/2022
    Time: 10:45
*/


import model.Book;
import model.LibraryCard;
import model.LibraryCardDTO;
import model.Student;
import service.IBookService;
import service.impl.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private final IBookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "search":
//                    searchProduct(request, response);
                    break;
                case "borrow_book_list":
                    borrowBookLList(request, response);
                    break;
                default:
                    bookList(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "borrow":
                    borrowBook(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void bookList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Book> bookList = bookService.findAllBook();
        List<Student> studentList = bookService.findAllStudent();
        String bookAmount = request.getParameter("book_amount"); //null
        System.out.println("Amount: "+ bookAmount);
        request.setAttribute("bookList", bookList);
        request.setAttribute("studentList", studentList);
        request.setAttribute("bookAmount", bookAmount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void borrowBookLList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<LibraryCardDTO> libraryCardDTOList = bookService.findAllLibraryCardDTO();
        request.setAttribute("libraryCardDTOList", libraryCardDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("library_card_list.jsp");
        dispatcher.forward(request, response);
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String bookId = request.getParameter("book_id");
        String libraryCardId = request.getParameter("library_card_id");
        Integer studentId = Integer.valueOf(request.getParameter("student_id"));

        String bookAmount = request.getParameter("book_amount");
        System.out.println("so luong: " + bookAmount);

        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String startDate = current.format(formatter);

        String endDate = request.getParameter("end_date");
        LibraryCard libraryCard = new LibraryCard(libraryCardId, bookId, studentId, startDate, endDate);
        bookService.insertLibrabyCard(libraryCard);
        response.sendRedirect("book");
    }
}

package controller;
/*
    Created by Trinh Khai
    Date: 14/03/2022
    Time: 14:45
*/


import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private IUserService userService;

    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    searchUserByCountry(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                default:
                    break;
            }
        }catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userService.sortByName();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        Map<String, String> error = userService.check(user);
        RequestDispatcher dispatcher;
        if (error != null) {
            request.setAttribute("error", error);
        } else {
            try {
                userService.insertUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("messenger", "New user was created");
        }
        dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> listUser = userService.selectAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        User existingUser = userService.selectUserById(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        Map<String, String> error = userService.check(user);
        RequestDispatcher dispatcher;
        if (error != null) {
            request.setAttribute("user", user);
            request.setAttribute("error", error);
        } else {
            userService.updateUser(user);
            request.setAttribute("messenger", "Update user success");
        }
        dispatcher = request.getRequestDispatcher("user/update.jsp");
        dispatcher.forward(request, response);
    }

    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String country = request.getParameter("search");
        List<User> userSearchResultList = userService.searchUserByCountry(country);
        if (userSearchResultList.isEmpty()) {
            request.setAttribute("messenger", "Not found");
        } else {
            request.setAttribute("userSearchResultList", userSearchResultList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);
    }
}

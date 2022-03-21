package controller;
/*
    Created by Trinh Khai
    Date: 18/03/2022
    Time: 13:05
*/


import model.customer.Customer;
import model.customer.CustomerType;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();

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
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "search":
                    searchCustomerByName(request, response);
                    break;
                default:
                    listEmployee(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                    insertCustomer(request, response);
                    break;
                case "edit":
                    editCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> customerList = customerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        RequestDispatcher dispatcher;
        Customer customer = new Customer(id, name, birthday, idCard, phoneNumber, email, address, code, customerTypeId, gender);
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        if (customerService.selectCutomerByCode(code) != null) {
            // kiểm tra customer trùng code
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
            request.setAttribute("customer", customer);
            request.setAttribute("code", "Customer code already exist.");
        } else {
            Map<String, String> error = customerService.check(customer);

            if (error != null) {
                request.setAttribute("customerTypeList", customerTypeList);
                request.setAttribute("customer", customer);
                request.setAttribute("error", error);
            } else {
                customerService.insertCustomer(customer);
                request.setAttribute("messenger", "New customer was created");
            }
        }
        dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(id);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
        dispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        Customer customer = new Customer(id, name, birthday, idCard, phoneNumber, email, address, code, customerTypeId, gender);
//        Map<String, String> error = customerService.check(customer);
        RequestDispatcher dispatcher;
        List<CustomerType> customerTypeList = customerService.findAllCustomerType();
        if (customerService.selectCutomerByCode(code) != null) {
            // kiểm tra customer trùng code
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
            request.setAttribute("code", "Customer code already exist.");
        } else {
            Map<String, String> error = customerService.check(customer);

            if (error != null) {
                request.setAttribute("customerTypeList", customerTypeList);
                request.setAttribute("customer", customer);
                request.setAttribute("error", error);
            } else {
                customerService.updateCustomer(customer);
                request.setAttribute("messenger", "Update customer success");
            }
        }
//        if (error != null) {
//            request.setAttribute("customer", customer);
//            request.setAttribute("error", error);
//        } else {
//            if (customerService.updateCustomer(customer)) {
//                request.setAttribute("messenger", "Update customer success");
//            } else {
//                error.put("code", "Customer code already exist.");
//                request.setAttribute("error", error);
//            }
//        }
        dispatcher = request.getRequestDispatcher("customer/update.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        customerService.deleteCustomer(id);
        List<Customer> customerList = customerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("search");
        List<Customer> customerList = customerService.searchByName(name);
        if (customerList.isEmpty()) {
            request.setAttribute("messenger", "Not found");
        } else {
            request.setAttribute("customerList", customerList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/search.jsp");
        dispatcher.forward(request, response);
    }
}

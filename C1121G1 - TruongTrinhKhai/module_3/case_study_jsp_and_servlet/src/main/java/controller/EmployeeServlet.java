package controller;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 14:18
*/


import model.employee.*;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
                    deleteEmployee(request, response);
                    break;
                case "search":
                    searchEmployeeByName(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    editEmployee(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Employee> employeeList = employeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList  = employeeService.findAllDivision();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.valueOf(request.getParameter("position_id"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("education_degree_id"));
        Integer division_id = Integer.valueOf(request.getParameter("division_id"));
        String username = request.getParameter("user_name");
        Employee employee = new Employee(id, name, birthday, idCard, phoneNumber, email, address,salary, positionId, educationDegreeId, division_id, username);
        Map<String, String> error = employeeService.save(employee);
        RequestDispatcher dispatcher;
        if (error != null) {
            List<Position> positionList = employeeService.findAllPosition();
            List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
            List<Division> divisionList  = employeeService.findAllDivision();
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("employee", employee);
            request.setAttribute("error", error);
        } else {
            employeeService.insertEmployee(employee);
            List<Position> positionList = employeeService.findAllPosition();
            List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
            List<Division> divisionList  = employeeService.findAllDivision();
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("messenger", "New employee was created");
        }
        dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Employee employee = employeeService.selectEmployeeById(id);
        request.setAttribute("employee", employee);
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList  = employeeService.findAllDivision();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
        dispatcher.forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.valueOf(request.getParameter("position_id"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("education_degree_id"));
        Integer division_id = Integer.valueOf(request.getParameter("division_id"));
        String username = request.getParameter("user_name");
        Employee employee = new Employee(id, name, birthday, idCard, phoneNumber, email, address, salary, positionId, educationDegreeId, division_id, username);
        Map<String, String> error = employeeService.save(employee);
        RequestDispatcher dispatcher;
        List<Position> positionList = employeeService.findAllPosition();
        List<EducationDegree> educationDegreeList = employeeService.findAllEducationDegree();
        List<Division> divisionList  = employeeService.findAllDivision();
        if (error != null) {
            request.setAttribute("employee", employee);
            request.setAttribute("error", error);
        } else {
            employeeService.updateEmployee(employee);
            request.setAttribute("messenger", "Update employee success");
        }
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        dispatcher = request.getRequestDispatcher("employee/update.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        List<Employee> employeeList = employeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("search");
        List<Employee> employeeList = employeeService.searchByName(name);
        if (employeeList.isEmpty()) {
            request.setAttribute("messenger", "Not found");
        } else {
            request.setAttribute("employeeList", employeeList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/search.jsp");
        dispatcher.forward(request, response);
    }
}

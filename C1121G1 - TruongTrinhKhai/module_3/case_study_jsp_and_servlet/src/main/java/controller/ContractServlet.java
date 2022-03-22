package controller;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 16:15
*/


import model.contract.Contract;
import model.customer.Customer;
import model.dto.ContractDTO;
import model.dto.FacilityDTO;
import model.employee.Employee;
import model.service.Facility;
import service.IContractService;
import service.ICustomerService;
import service.IEmployeeService;
import service.IFacilityService;
import service.impl.ContractService;
import service.impl.CustomerService;
import service.impl.EmployeeService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractService();
    ICustomerService customerService = new CustomerService();
    IEmployeeService employeeService = new EmployeeService();
    IFacilityService facilityService = new FacilityService();

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
                default:
                    listContract(request, response);
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
                    insertContract(request, response);
                    break;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<ContractDTO> contractDTOList = contractService.findAllContractDTO();
        request.setAttribute("contractDTOList", contractDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> customerList = customerService.findAllCustomer();
        List<Employee> employeeList = employeeService.findAllEmployee();
        List<FacilityDTO> facilityDTOList = facilityService.selectAllFacilityDTO();
        request.setAttribute("customerList", customerList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("facilityDTOList", facilityDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        Double deposit = Double.valueOf(request.getParameter("deposit"));
        Double totalMoney = Double.valueOf(request.getParameter("total_money"));
        Integer customerId = Integer.valueOf(request.getParameter("customer_name"));
        Integer employeeId = Integer.valueOf(request.getParameter("employee_name"));
        Integer serviceId = Integer.valueOf(request.getParameter("service_name"));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, customerId, employeeId, serviceId);
        RequestDispatcher dispatcher;
        Map<String, String> error = contractService.check(contract);
        if (error != null) {
            List<Customer> customerList = customerService.findAllCustomer();
            List<Employee> employeeList = employeeService.findAllEmployee();
            List<FacilityDTO> facilityDTOList = facilityService.selectAllFacilityDTO();
            request.setAttribute("customerList", customerList);
            request.setAttribute("employeeList", employeeList);
            request.setAttribute("facilityDTOList", facilityDTOList);
            request.setAttribute("contract", contract);
            request.setAttribute("error", error);
        } else {
            contractService.insertContract(contract);
            request.setAttribute("messenger", "New contract was created");
        }
        dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }
}

package service.impl;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 14:22
*/

import model.employee.*;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.impl.CustomerService.*;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String POSITIVE_NUMBER_REGEX = "^[^\\D]+(.[^\\D]*)?$";

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        return employeeRepository.selectEmployeeById(id);
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }

    @Override
    public List<Position> findAllPosition() {
        return employeeRepository.findAllPosition();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return employeeRepository.findAllEducationDegree();
    }

    @Override
    public List<Division> findAllDivision() {
        return employeeRepository.findAllDivision();
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> error = new HashMap<>();
        if (!employee.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (!employee.getIdCard().matches(ID_CARD_REGEX)) {
            error.put("id_card", "ID number must be in the correct format XXXXXXXXX or XXXXXXXXXXXX (X is the number 0-9)");
        }
//        if (!employee.getBirthday().matches(DATE_REGEX)) {
//            error.put("birthday", "Wrong format of date");
//        }
        if (employee.getSalary() <= 0) {
            error.put("salary", "Salary must be greater than 0");
        }
        if (!employee.getPhoneNumber().matches(PHONE_NUMBER_REGEX)) {
            error.put("phone_number", "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx where x is a natural number");
        }
        if (!employee.getEmail().matches(EMAIL_REGEX)) {
            error.put("email", "Wrong format of email");
        }
        if (!employee.getAddress().matches(STRING_REGEX)) {
            error.put("address", "Address cannot have any extra spaces or no characters");
        }
        if (!employee.getUsername().matches(STRING_REGEX)) {
            error.put("user_name", "UserName cannot have any extra spaces or no characters");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }
}

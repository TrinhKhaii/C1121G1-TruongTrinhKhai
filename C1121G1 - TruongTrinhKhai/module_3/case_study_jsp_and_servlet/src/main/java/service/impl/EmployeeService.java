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

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String POSITIVE_NUMBER_REGEX = "^[^\\D]+(.[^\\D]*)?$";
    public static final String DATE_REGEX = "^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

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
//        if (!employee.getBirthday().matches(DATE_REGEX)) {
//            error.put("birthday", "Wrong format of date");
//        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }
}

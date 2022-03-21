package service;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 14:22
*/

import model.employee.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> findAllEmployee();

    Employee selectEmployeeById(Integer id);

    void insertEmployee(Employee employee) throws SQLException;

    void deleteEmployee(Integer id) throws SQLException;

    void updateEmployee(Employee employee) throws SQLException;

    List<Employee> searchByName(String name);

    List<Position> findAllPosition();

    List<EducationDegree> findAllEducationDegree();

    List<Division> findAllDivision();

    Map<String, String> save(Employee employee);
}

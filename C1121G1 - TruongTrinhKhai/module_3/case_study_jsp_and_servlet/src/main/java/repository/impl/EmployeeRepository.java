package repository.impl;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 13:53
*/

import model.employee.*;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_EMPLOYEE = "select * from employee;";
    private static final String SELECT_ALL_POSITION = "select * from position;";
    private static final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degree;";
    private static final String SELECT_ALL_DIVISION = "select * from division;";
    private static final String INSERT_NEW_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, user_name) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_BY_ID = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, user_name = ? where employee_id = ?;";
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = ?;";
    private static final String SEARCH_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?";

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = this.baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phoneNumber = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                Integer positionId = rs.getInt("position_id");
                Integer educationDegreeId = rs.getInt("education_degree_id");
                Integer divisionId = rs.getInt("division_id");
                String username = rs.getString("user_name");

                employeeList.add(new Employee(id, name, birthday, idCard, phoneNumber, email, address, salary, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        Employee employee = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phoneNumber = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                Integer positionId = rs.getInt("position_id");
                Integer educationDegreeId = rs.getInt("education_degree_id");
                Integer divisionId = rs.getInt("division_id");
                String username = rs.getString("user_name");
                employee = new Employee(id, name, birthday, idCard, phoneNumber, email, address, salary, positionId, educationDegreeId, divisionId, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_NEW_EMPLOYEE);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        System.out.println(DELETE_EMPLOYEE_BY_ID);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Employee> searchByName(String namee) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME)) {
            preparedStatement.setString(1, "%" + namee + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phoneNumber = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                Integer positionId = rs.getInt("position_id");
                Integer educationDegreeId = rs.getInt("education_degree_id");
                Integer divisionId = rs.getInt("division_id");
                String username = rs.getString("user_name");
                employeeList.add(new Employee(id, name, birthday, idCard, phoneNumber, email, address, salary, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Position> findAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                positionList.add(new Position(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("education_degree_id");
                String name = rs.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }

    @Override
    public List<Division> findAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("division_id");
                String name = rs.getString("division_name");
                divisionList.add(new Division(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

}

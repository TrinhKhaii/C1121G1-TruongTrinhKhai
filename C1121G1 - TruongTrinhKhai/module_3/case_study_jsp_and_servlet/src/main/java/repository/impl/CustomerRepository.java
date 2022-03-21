package repository.impl;
/*
    Created by Trinh Khai
    Date: 18/03/2022
    Time: 11:27
*/

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";
    private static final String INSERT_NEW_CUSTOMER = "insert into customer (customer_code, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER_BY_ID = "update customer set customer_code = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?;";
    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";
    private static final String SELECT_CUSTOMER_BY_CODE = "select * from customer where customer_code = ?;";

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("customer_id");
                String customerCode = rs.getString("customer_code");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                Integer gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phoneNumber = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                Integer customerTypeId = rs.getInt("customer_type_id");
                customerList.add(new Customer(id, name, birthday, idCard, phoneNumber, email, address, customerCode, customerTypeId, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCustomerById(Integer id) throws SQLException {
        Customer customer = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            System.out.println(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer customerTypeId = rs.getInt("customer_type_id");
                String customerCode = rs.getString("customer_code");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                Integer gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phoneNumber = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id, name, birthday, idCard, phoneNumber, email, address, customerCode, customerTypeId, gender);
            }
        }
        return customer;
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        boolean result;
        System.out.println(INSERT_NEW_CUSTOMER);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER)) {
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getCustomerTypeId());
            result = preparedStatement.executeUpdate() > 0;
        }
        return result;
    }

    @Override
    public void deleteCustomer(Integer id) throws SQLException {
        System.out.println(DELETE_CUSTOMER_BY_ID);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean result;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID)) {
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getCustomerTypeId());
            preparedStatement.setInt(10, customer.getId());
            result = preparedStatement.executeUpdate() > 0;
        }
        return result;
    }

    @Override
    public List<Customer> searchByName(String namee) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME)) {
            preparedStatement.setString(1, "%" + namee + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("customer_id");
                String customerCode = rs.getString("customer_code");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String idCard = rs.getString("customer_id_card");
                String phoneNumber = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                Integer customerTypeId = rs.getInt("customer_type_id");
                Integer gender = rs.getInt("customer_gender");
                customerList.add(new Customer(id, customerCode, name, birthday, idCard, phoneNumber, email, address, customerTypeId, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public Customer selectCutomerByCode(String code) {
        Customer customer = null;
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_CODE)) {
            System.out.println(SELECT_CUSTOMER_BY_CODE);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("customer_id");
                Integer customerTypeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                Integer gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phoneNumber = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id, name, birthday, idCard, phoneNumber, email, address, code, customerTypeId, gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}

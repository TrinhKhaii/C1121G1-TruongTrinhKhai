package service;
/*
    Created by Trinh Khai
    Date: 18/03/2022
    Time: 13:03
*/

import model.customer.Customer;
import model.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAllCustomer();

    Customer selectCustomerById(Integer id) throws SQLException;

    boolean insertCustomer(Customer customer) throws SQLException;

    void deleteCustomer(Integer id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> searchByName(String name);

    List<CustomerType> findAllCustomerType();

    Map<String, String> check(Customer customer);

    Customer selectCutomerByCode(String code);
}

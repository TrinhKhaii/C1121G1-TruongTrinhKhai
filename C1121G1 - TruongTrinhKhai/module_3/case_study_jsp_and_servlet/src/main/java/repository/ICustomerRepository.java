package repository;
/*
    Created by Trinh Khai
    Date: 18/03/2022
    Time: 11:24
*/

import model.customer.Customer;
import model.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAllCustomer();

    Customer selectCustomerById(Integer id) throws SQLException;

    boolean insertCustomer(Customer customer) throws SQLException;

    void deleteCustomer(Integer id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> searchByName(String name);

    List<CustomerType> findAllCustomerType();

    Customer selectCutomerByCode(String code);
}

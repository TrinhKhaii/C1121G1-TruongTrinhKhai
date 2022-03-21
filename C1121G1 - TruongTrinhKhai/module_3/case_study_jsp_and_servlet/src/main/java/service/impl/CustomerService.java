package service.impl;
/*
    Created by Trinh Khai
    Date: 18/03/2022
    Time: 13:04
*/

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.impl.EmployeeService.STRING_REGEX;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();
    private static final String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public Customer selectCustomerById(Integer id) throws SQLException {
        return customerRepository.selectCustomerById(id);
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {
        return customerRepository.insertCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) throws SQLException {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerRepository.findAllCustomerType();
    }

    @Override
    public Map<String, String> check(Customer customer) {
        Map<String, String> error = new HashMap<>();
//        if (!customer.getName().matches(STRING_REGEX)) {
//            error.put("name", "Name cannot have any extra spaces or no characters");
//        }
        if (!customer.getCustomerCode().matches(CUSTOMER_CODE_REGEX)) {
            error.put("code", "The format of the code must be KH-XXXX, where X is a natural number");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }

    public Customer selectCutomerByCode(String code) {
        return customerRepository.selectCutomerByCode(code);
    }
}

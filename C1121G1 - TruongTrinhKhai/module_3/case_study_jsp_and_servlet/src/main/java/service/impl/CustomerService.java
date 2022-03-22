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



public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    private static final String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";
    public static final String PHONE_NUMBER_REGEX = "^(090\\d{7})|(091\\d{7})|(\\(\\+84\\)90\\d{7})|(\\(\\+84\\)91\\d{7})$";
    public static final String ID_CARD_REGEX = "^((\\d{9})|(\\d{12}))$";
    public static final String EMAIL_REGEX = "^[\\w!#$%&'*+\\/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+\\/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

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
        if (!customer.getCustomerCode().matches(CUSTOMER_CODE_REGEX)) {
            error.put("code", "The format of the code must be KH-XXXX, where X is a natural number");
        }
        if (!customer.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
//        if (!customer.getBirthday().matches(DATE_REGEX)) {
//            error.put("birthday", "Wrong format of date (dd/mm/yyyy)");
//        }
        if (!customer.getPhoneNumber().matches(PHONE_NUMBER_REGEX)) {
            error.put("phone_number", "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx where x is a natural number");
        }
        if (!customer.getIdCard().matches(ID_CARD_REGEX)) {
            error.put("id_card", "ID number must be in the correct format XXXXXXXXX or XXXXXXXXXXXX (X is the number 0-9)");
        }
        if (!customer.getEmail().matches(EMAIL_REGEX)) {
            error.put("email", "Wrong format of email");
        }
        if (!customer.getAddress().matches(STRING_REGEX)) {
            error.put("address", "Address cannot have any extra spaces or no characters");
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

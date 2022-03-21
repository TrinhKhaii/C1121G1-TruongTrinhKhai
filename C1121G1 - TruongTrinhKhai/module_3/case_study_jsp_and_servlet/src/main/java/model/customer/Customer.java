package model.customer;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:26
*/

import model.Person;

public class Customer extends Person {
    private String customerCode;
    private Integer customerTypeId;
    private Integer gender;

    public Customer() {}

    public Customer(Integer id, String name, String birthday, String idCard, String phoneNumber, String email, String address, String customerCode, Integer customerTypeId, Integer gender) {
        super(id, name, birthday, idCard, phoneNumber, email, address);
        this.customerCode = customerCode;
        this.customerTypeId = customerTypeId;
        this.gender = gender;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}

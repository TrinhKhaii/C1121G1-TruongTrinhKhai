package model.contract;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 13:39
*/

import model.customer.Customer;
import model.employee.Employee;
import model.service.Facility;

public class Contract {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Double totalMoney;
    private Employee employeeId;
    private Customer customerId;
    private Facility facilityId;

    public Contract() {}

    public Contract(Integer id, String startDate, String endDate, Double deposit, Double totalMoney, Employee employeeId, Customer customerId, Facility facilityId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Facility getServiceId() {
        return facilityId;
    }

    public void setServiceId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", employeeId=" + employeeId.getId() +
                ", customerId=" + customerId.getId() +
                ", serviceId=" + facilityId.getId() +
                '}';
    }
}

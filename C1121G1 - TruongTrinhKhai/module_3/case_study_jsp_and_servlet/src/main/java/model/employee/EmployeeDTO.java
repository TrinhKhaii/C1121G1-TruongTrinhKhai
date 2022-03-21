package model.employee;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 14:39
*/

import model.Person;

public class EmployeeDTO extends Person {
    private Double salary;
    private Integer positionId;
    private Integer educationDegreeId;
    private Integer divisionId;
    private String username;

    public EmployeeDTO() {}

    public EmployeeDTO(Integer id, String name, String birthday, String idCard, String phoneNumber, String email, String address, Double salary, Integer positionId, Integer educationDegreeId, Integer divisionId, String username) {
        super(id, name, birthday, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

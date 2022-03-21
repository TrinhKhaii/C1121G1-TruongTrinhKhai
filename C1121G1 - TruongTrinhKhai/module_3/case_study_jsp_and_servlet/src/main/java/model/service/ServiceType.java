package model.service;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:29
*/

public class ServiceType {
    private Integer id;
    private String name;

    public ServiceType() {}

    public ServiceType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

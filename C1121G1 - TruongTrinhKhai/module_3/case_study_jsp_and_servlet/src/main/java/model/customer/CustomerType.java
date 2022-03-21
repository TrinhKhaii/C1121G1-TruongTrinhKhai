package model.customer;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:25
*/

public class CustomerType {
    private Integer id;
    private String name;

    public CustomerType() {}

    public CustomerType(Integer id, String name) {
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
        return "CustomerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

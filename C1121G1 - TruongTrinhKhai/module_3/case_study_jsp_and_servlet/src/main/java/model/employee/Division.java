package model.employee;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 10:48
*/

public class Division {
    private Integer id;
    private String name;

    public Division() {
    }

    public Division(Integer id, String name) {
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
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

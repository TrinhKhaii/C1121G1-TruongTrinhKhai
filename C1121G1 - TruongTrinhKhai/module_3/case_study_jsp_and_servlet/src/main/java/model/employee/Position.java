package model.employee;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 10:46
*/

public class Position {
    private Integer id;
    private String name;

    public Position() {
    }

    public Position(Integer id, String name) {
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
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package model.employee;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 10:48
*/

public class EducationDegree {
    private Integer id;
    private String name;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String name) {
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
        return "EducationDegree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

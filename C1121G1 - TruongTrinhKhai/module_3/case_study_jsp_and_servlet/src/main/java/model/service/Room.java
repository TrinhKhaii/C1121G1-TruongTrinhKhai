package model.service;
/*
    Created by Trinh Khai
    Date: 19/03/2022
    Time: 08:47
*/

public class Room  extends Facility{
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(Integer id, String code, String name, Integer area, Double cost, Integer maxPeople, Integer rentTypeId, Integer serviceTypeId, String freeServiceIncluded) {
        super(id, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }
}

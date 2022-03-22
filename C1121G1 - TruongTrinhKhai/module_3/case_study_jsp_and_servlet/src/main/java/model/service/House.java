package model.service;
/*
    Created by Trinh Khai
    Date: 19/03/2022
    Time: 09:00
*/

public class House extends Facility{
    private String roomStandard;
    private String descriptionOtherConvenience;
    private Integer numberOfFloors;

    public House() {}

    public House(Integer id, String code, String name, Integer area, Double cost, Integer maxPeople, Integer rentTypeId, Integer serviceTypeId, String roomStandard, String descriptionOtherConvenience, Integer numberOfFloors) {
        super(id, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId);
        this.roomStandard = roomStandard;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}

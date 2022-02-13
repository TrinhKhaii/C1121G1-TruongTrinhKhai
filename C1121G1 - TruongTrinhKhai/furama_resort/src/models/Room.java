//
// created by Trinh Khai at 15:20 26/1/2022
//

package models;

public class Room extends Facility{
    private String freeServiceIncluded;

    public Room(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
    }

    public Room(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent, String freeServiceIncluded) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                ", freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getServiceName() + "," + this.getUsableArea() + "," + this.getRentalCost() +
                "," + this.getMaxinumNumberOfPeople() + "," + this.getRentType() + "," + this.getNumberOfTimesToRent() + "," +
                this.getFreeServiceIncluded();

    }
}

//
// created by Trinh Khai at 15:11 26/1/2022
//

package models;

public class Villa extends Facility {
    public enum RoomStandard {
        DIAMOND("Diamond"),
        PLATINIUM("Platinium"),
        GOLD("Gold"),
        SILVER("Silver");
        private final String value;
        RoomStandard(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }
    private String roomStandard;
    private float poolArea;
    private int numberOfFloors;

    public Villa(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
    }

    public Villa(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent, String roomStandard, float poolArea, int numberOfFloors) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getServiceName() + "," + this.getUsableArea() + "," + this.getRentalCost() +
                "," + this.getMaxinumNumberOfPeople() + "," + this.getRentType() + "," + this.getNumberOfTimesToRent() + "," +
                this.getRoomStandard() + "," + this.getPoolArea() + "," + this.getNumberOfFloors();
    }
}

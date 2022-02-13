//
// created by Trinh Khai at 15:16 26/1/2022
//

package models;

public class House extends Facility{
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
    private int numberOfFloors;


    public House(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
    }

    public House(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent, String roomStandard, int numberOfFloors) {
        super(id, serviceName, usableArea, rentalCost, maxinumNumberOfPeople, rentType, numberOfTimesToRent);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getServiceName() + "," + this.getUsableArea() + "," + this.getRentalCost() +
                "," + this.getMaxinumNumberOfPeople() + "," + this.getRentType() + "," + this.getNumberOfTimesToRent() + "," +
                this.getRoomStandard() + "," + this.getNumberOfFloors();
    }
}

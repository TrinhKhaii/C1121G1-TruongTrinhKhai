//
// created by Trinh Khai at 15:01 26/1/2022
//

package models;

public abstract class Facility {
    public enum RentType {
        YEAR("Year"),
        MONTH("Month"),
        DAY("Day"),
        HOUR("Hour");
        private final String value;
        RentType(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }
    private String id;
    private String serviceName;
    private float usableArea;
    private int rentalCost;
    private int maxinumNumberOfPeople;
    private String rentType;
    private int numberOfTimesToRent;

    public Facility(String id, String serviceName, float usableArea, int rentalCost, int maxinumNumberOfPeople, String rentType, int numberOfTimesToRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxinumNumberOfPeople = maxinumNumberOfPeople;
        this.rentType = rentType;
        this.numberOfTimesToRent = numberOfTimesToRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(float usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxinumNumberOfPeople() {
        return maxinumNumberOfPeople;
    }

    public void setMaxinumNumberOfPeople(int maxinumNumberOfPeople) {
        this.maxinumNumberOfPeople = maxinumNumberOfPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public void setNumberOfTimesToRent(int numberOfTimesToRent) {
        this.numberOfTimesToRent = numberOfTimesToRent;
    }

    public int getNumberOfTimesToRent() {
        return numberOfTimesToRent;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCost=" + rentalCost +
                ", maxinumNumberOfPeople=" + maxinumNumberOfPeople +
                ", rentType='" + rentType;
    }
}

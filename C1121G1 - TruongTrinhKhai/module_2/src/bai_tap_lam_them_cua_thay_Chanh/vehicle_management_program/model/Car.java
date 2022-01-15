package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

public class Car extends Vehicle {
    private int numOfSeats;
    private String type; // tourist, coach

    public Car() {}

    public Car(int numOfSeats, String type) {
        this.numOfSeats = numOfSeats;
        this.type = type;
    }

    public Car(String controlPlate, Manufacturer manufacturerName, int yearOfManufacture, String ownerName, int numOfSeats, String type) {
        super(controlPlate, manufacturerName, yearOfManufacture, ownerName);
        this.numOfSeats = numOfSeats;
        this.type = type;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                ", numOfSeats=" + numOfSeats +
                ", type='" + type + '\'' +
                '}';
    }
}

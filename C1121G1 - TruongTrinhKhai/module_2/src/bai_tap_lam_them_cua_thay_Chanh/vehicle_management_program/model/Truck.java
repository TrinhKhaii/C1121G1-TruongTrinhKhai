package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

public class Truck extends Vehicle{
    private int payload;

    public Truck(){}

    public Truck(int payload) {
        this.payload = payload;
    }

    public Truck(String controlPlate, Manufacturer manufacturerName, int yearOfManufacture, String ownerName, int payload) {
        super(controlPlate, manufacturerName, yearOfManufacture, ownerName);
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                ", payload=" + payload +
                '}';
    }
}

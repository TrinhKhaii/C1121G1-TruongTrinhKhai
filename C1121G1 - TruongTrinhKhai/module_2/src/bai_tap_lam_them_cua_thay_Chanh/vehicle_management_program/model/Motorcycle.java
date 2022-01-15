package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

public class Motorcycle extends Vehicle{
    private int Wattage;

    public Motorcycle() {}

    public Motorcycle(int wattage) {
        Wattage = wattage;
    }

    public Motorcycle(String controlPlate, Manufacturer manufacturerName, int yearOfManufacture, String ownerName, int wattage) {
        super(controlPlate, manufacturerName, yearOfManufacture, ownerName);
        Wattage = wattage;
    }

    public int getWattage() {
        return Wattage;
    }

    public void setWattage(int wattage) {
        Wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                super.toString() +
                ", Wattage=" + Wattage +
                '}';
    }
}

package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

public abstract class Vehicle {
    private String controlPlate;
    private Manufacturer manufacturerName;
    private int yearOfManufacture;
    private String ownerName;

    public Vehicle() {}

    public Vehicle(String controlPlate, Manufacturer manufacturerName, int yearOfManufacture, String ownerName) {
        this.controlPlate = controlPlate;
        this.manufacturerName = manufacturerName;
        this.yearOfManufacture = yearOfManufacture;
        this.ownerName = ownerName;
    }

    public String getControlPlate() {
        return controlPlate;
    }

    public void setControlPlate(String controlPlate) {
        this.controlPlate = controlPlate;
    }

    public String getManufacturerName() {
        return manufacturerName.getName();
    }

    public void setManufacturerName(Manufacturer manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "controlPlate='" + controlPlate + '\'' +
                ", manufacturerName='" + manufacturerName.getName() + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", ownerName='" + ownerName;
    }
}

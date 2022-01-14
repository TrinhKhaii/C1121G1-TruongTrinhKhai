package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

public class Vehicle {
    private String controlPlate;
    private String manufacturerName;
    private int yearOfManufacture;
    private String ownerName;

    public Vehicle() {
    }

    public Vehicle(String controlPlate, String manufacturerName, int yearOfManufacture, String ownerName) {
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
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
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
        return "Vehicle{" +
                "controlPlate='" + controlPlate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

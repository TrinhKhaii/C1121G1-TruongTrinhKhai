package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model;

import java.util.ArrayList;

public class Manufacturer {
    public static ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

    static {
        manufacturerList.add(new Manufacturer("HSX-001", "Yamaha", "Japan"));
        manufacturerList.add(new Manufacturer("HSX-002", "Honda", "Japan"));
        manufacturerList.add(new Manufacturer("HSX-003", "Dongfeng", "China"));
        manufacturerList.add(new Manufacturer("HSX-004", "Hyundai", "Korea"));
        manufacturerList.add(new Manufacturer("HSX-005", "Ford", "USA"));
        manufacturerList.add(new Manufacturer("HSX-006", "Toyota", "Japan"));
        manufacturerList.add(new Manufacturer("HSX-006", "Hino", "Japan"));
    }

    private String id;
    private String name;
    private String countryName;

    public Manufacturer() {
    }

    public Manufacturer(String id, String name, String countryName) {
        this.id = id;
        this.name = name;
        this.countryName = countryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}

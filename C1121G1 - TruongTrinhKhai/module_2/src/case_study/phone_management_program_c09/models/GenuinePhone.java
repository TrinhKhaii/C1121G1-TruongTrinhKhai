package case_study.phone_management_program_c09.models;

public class GenuinePhone extends Phone{
    public enum WarrantyCoverage {
        DOMESTIC("Domestic"),
        INTERNATIONAL("International");
        private final String value;
        WarrantyCoverage(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }

    private int warrantyPeriod;
    private String warrantyCoverage;

    public GenuinePhone() {}

    public GenuinePhone(int id, String name, int price, int quantity, String manufacturer, int warrantyPeriod, String warrantyCoverage) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    public String toString() {
        return "GenuinePhone{" +
                super.toString() +
                ", warrantyPeriod=" + warrantyPeriod +
                ", warrantyCoverage='" + warrantyCoverage + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getName() + "," + this.getPrice() + "," + this.getQuantity() +
                "," + this.getManufacturer() + "," + this.getWarrantyPeriod() + "," + this.getWarrantyCoverage();
    }
}

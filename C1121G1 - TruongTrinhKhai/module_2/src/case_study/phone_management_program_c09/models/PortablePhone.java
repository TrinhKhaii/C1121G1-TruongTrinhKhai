package case_study.phone_management_program_c09.models;

public class PortablePhone extends Phone{
    public enum Status {
        REPAIRED("Repaired") ,
        UNREPAIRED("Unrepaired");
        private final String value;
        Status(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }

    private String portableCountry;
    private String status;

    PortablePhone() {}

    public PortablePhone(int id, String name, int price, int quantity, String manufacturer, String portableCountry, String status) {
        super(id, name, price, quantity, manufacturer);
        this.portableCountry = portableCountry;
        this.status = status;
    }

    public String getPortableCountry() {
        return portableCountry;
    }

    public void setPortableCountry(String portableCountry) {
        this.portableCountry = portableCountry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PortablePhone{" +
                super.toString() +
                ", portableCountry='" + portableCountry + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getName() + "," + this.getPrice() + "," + this.getQuantity() +
                "," + this.getManufacturer() + "," + this.getPortableCountry() + "," + this.getStatus();
    }
}

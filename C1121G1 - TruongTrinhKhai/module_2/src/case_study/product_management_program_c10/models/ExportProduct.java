package case_study.product_management_program_c10.models;

public class ExportProduct extends Product{
    private int exportPrice;
    private String countryOfImport;

    public ExportProduct() {}

    public ExportProduct(int id, String code, String name, int price, int quantity, String manufacturer, int exportPrice, String countryOfImport) {
        super(id, code, name, price, quantity, manufacturer);
        this.exportPrice = exportPrice;
        this.countryOfImport = countryOfImport;
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(int exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCountryOfImport() {
        return countryOfImport;
    }

    public void setCountryOfImport(String countryOfImport) {
        this.countryOfImport = countryOfImport;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                super.toString() +
                ", exportPrice=" + exportPrice +
                ", countryOfImport='" + countryOfImport + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getCode() + "," + this.getName() + "," + this.getPrice() + "," +
                this.getQuantity() + "," + this.getManufacturer() + "," + this.getExportPrice() + "," + this.getCountryOfImport();
    }
}

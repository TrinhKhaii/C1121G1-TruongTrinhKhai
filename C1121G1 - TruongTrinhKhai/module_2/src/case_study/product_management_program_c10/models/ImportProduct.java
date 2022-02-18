package case_study.product_management_program_c10.models;

public class ImportProduct extends Product{
    private int importPrice;
    private String importProvince;
    private int  importTax;

    public ImportProduct() {}

    public ImportProduct(int id, String code, String name, int price, int quantity, String manufacturer, int importPrice, String importProvince, int importTax) {
        super(id, code, name, price, quantity, manufacturer);
        this.importPrice = importPrice;
        this.importProvince = importProvince;
        this.importTax = importTax;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportProvince() {
        return importProvince;
    }

    public void setImportProvince(String importProvince) {
        this.importProvince = importProvince;
    }

    public int getImportTax() {
        return importTax;
    }

    public void setImportTax(int importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                super.toString() +
                ", importPrice=" + importPrice +
                ", importProvince='" + importProvince + '\'' +
                ", importTax=" + importTax +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getCode() + "," + this.getName() + "," + this.getPrice() + "," +
                this.getQuantity() + "," + this.getManufacturer() + "," + this.getImportPrice() + "," +
                this.getImportProvince() + "," + this.getImportTax();
    }
}

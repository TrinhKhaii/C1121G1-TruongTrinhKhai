package ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String origin;

    public Product() {
    }

    public Product(int id, String name, double price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

}

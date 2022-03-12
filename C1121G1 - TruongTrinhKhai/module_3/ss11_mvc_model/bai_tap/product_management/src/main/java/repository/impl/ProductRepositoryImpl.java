package repository.impl;

import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    static List<Product> productList = new LinkedList<>();

    static {
        productList.add(new Product(1, "Samsung Galaxy S5", 100000.0, "Discount 10%", "Samsung"));
        productList.add(new Product(2, "Samsung Galaxy S6", 200000.0, "Discount 20%", "Samsung"));
        productList.add(new Product(3, "Samsung Galaxy S7", 300000.0, "Discount 15%", "Samsung"));
        productList.add(new Product(4, "Iphone 12", 400000.0, "Discount 5%", "Apple"));
        productList.add(new Product(5, "Iphone 11", 350000.0, "Discount 15%", "Apple"));
        productList.add(new Product(6, "Iphone X", 200000.0, "Discount 20%", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (productList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            for (Product product : productList) {
                System.out.println("-----------Product list-----------");
                System.out.println("Id: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Description: " + product.getDescription());
                System.out.println("Manufacturer: " + product.getManufacturer());
                System.out.println("-------------------------------");
            }
        }
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Integer id, String name, Double price, String description, String manufacturer) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setManufacturer(manufacturer);
            }
        }
    }

    @Override
    public void remove(Integer id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productList.remove(product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> searchProductList = new ArrayList<>();
        boolean check = false;
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                check = true;
                searchProductList.add(product);
            }
        }
        if (!check) {
            System.out.println("Product id does not exist.");
            return null;
        } else {
            return searchProductList;
        }
    }
}

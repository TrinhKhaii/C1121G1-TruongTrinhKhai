package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Integer id);

    void display();

    void create(Product product);

    void update(Integer id, String name, Double price, String description, String manufacturer);

    void remove(Integer id);

    List<Product> search(String name);
}

package service;

import model.Product;
import model.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void display();

    void create(Product product);

    void update(Integer id, String name, Double price, String description, String manufacturer);

    void remove(Integer id);

    List<Product> search(String name);

    Integer lastId();

    Map<String, String> save(ProductDTO productDTO);
}

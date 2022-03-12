package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void display() {
        this.productRepository.display();
    }

    @Override
    public void create(Product product) {
        this.productRepository.create(product);
    }

    @Override
    public void update(Integer id, String name, Double price, String description, String manufacturer) {
        if (name.equals("")) {
            System.out.println("Name cannot be blank.");
            return;
        }
        if (price.equals("")) {
            System.out.println("Price cannot be blank.");
            return;
        }
        if (description.equals("")) {
            System.out.println("Description cannot be blank.");
            return;
        }
        if (manufacturer.equals("")) {
            System.out.println("Manufacturer cannot be blank.");
            return;
        }
        if (this.productRepository.findById(id) == null) {
            System.out.println("Product id does not exist.");
            return;
        }
        this.productRepository.update(id, name, price, description, manufacturer);
    }

    @Override
    public void remove(Integer id) {
        if (this.productRepository.findById(id) == null) {
            System.out.println("Product id does not exist.");
            return;
        }
        this.productRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        if (name.equals("")) {
            System.out.println("Name cannot be blank.");
            return null;
        }
        return this.productRepository.search(name);
    }

    public Integer lastId() {
        List<Product> productList = this.productRepository.findAll();
        return productList.get(productList.size() - 1).getId();
    }
}

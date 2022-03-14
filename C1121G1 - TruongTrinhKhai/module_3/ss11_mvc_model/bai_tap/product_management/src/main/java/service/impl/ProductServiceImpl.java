package service.impl;

import model.Product;
import model.ProductDTO;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String POSITIVE_NUMBER_REGEX = "^[^\\D]+(.[^\\D]*)?$";

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

    @Override
    public Map<String, String> save(ProductDTO productDTO) {
        Map<String, String> error = new HashMap<>();
        if (!productDTO.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (!(productDTO.getPrice()).matches(POSITIVE_NUMBER_REGEX)) {
            error.put("price", "Price must be a positive number");
        }
        if (!productDTO.getDescription().matches(STRING_REGEX)) {
            error.put("description", "Description cannot have any extra spaces or no characters");
        }
        if (!productDTO.getManufacturer().matches(STRING_REGEX)) {
            error.put("manufacturer", "Manufacturer cannot have any extra spaces or no characters");
        }
        if (error.isEmpty()) {
            Product product = new Product(productDTO.getId(), productDTO.getName(), Double.parseDouble(productDTO.getPrice()), productDTO.getDescription(), productDTO.getManufacturer());
            create(product);
            return null;
        } else {
            return error;
        }
    }
}

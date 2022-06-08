package service.impl;
/*
    Created by Trinh Khai
    Date: 22/03/2022
    Time: 19:20
*/

import model.Category;
import model.Product;
import model.ProductDTO;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDTO> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public List<Category> findAllCategory() {
        return productRepository.findAllCategory();
    }

    @Override
    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteEmployee(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<ProductDTO> searchByAll(String name, String price, String color, String category) {
        return productRepository.searchByAll(name, price, color, category);
    }

    @Override
    public List<ProductDTO> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public List<ProductDTO> searchByPrice(String price) {
        return productRepository.searchByPrice(price);
    }


    @Override
    public Integer getCount() {
        return productRepository.getCount();
    }
}

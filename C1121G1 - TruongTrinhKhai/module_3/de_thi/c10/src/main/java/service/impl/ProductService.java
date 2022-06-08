package service.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 22:33
*/

import model.Category;
import model.Product;
import model.ProductDTO;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO();
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
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<ProductDTO> seachProductByName(String name) {
        return productRepository.seachProductByName(name);
    }
}

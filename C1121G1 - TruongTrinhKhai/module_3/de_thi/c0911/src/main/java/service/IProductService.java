package service;
/*
    Created by Trinh Khai
    Date: 22/03/2022
    Time: 19:20
*/

import model.Category;
import model.Product;
import model.ProductDTO;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<ProductDTO> findAllProduct();

    List<Category> findAllCategory();

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteEmployee(Integer id);

    List<ProductDTO> searchByAll(String name, String price, String color, String category);

    List<ProductDTO> searchByName(String name);

    List<ProductDTO> searchByPrice(String price);

    Integer getCount();
}

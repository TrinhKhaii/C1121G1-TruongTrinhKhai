package repository;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 22:33
*/

import model.Category;
import model.Product;
import model.ProductDTO;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> findAllProductDTO();

    List<Category> findAllCategory();

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    List<ProductDTO> seachProductByName(String name);
}

package repository.impl;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 22:33
*/

import model.Category;
import model.Product;
import model.ProductDTO;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_PRODUCT = "select id, `name`, price, quantity, color, category.category_name, category.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id;";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String INSERT_NEW_PRODUCT = "insert into product(`name`, price, quantity, color, category_id)\n" +
            "values (?, ?, ?, ?, ?);";
    private static final String UPDATE_PRODUCT_BY_ID = "update product\n" +
            "set name = ?, price = ?, quantity = ?, color = ?, category_id = ?\n" +
            "where id = ?;";
    private static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ?;";
    private static final String SEARCH_PRODUCT_BY_NAME = "select id, `name`, price, quantity, color, category.category_name, category.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id\n" +
            "where `name` like ?;";

    @Override
    public List<ProductDTO> findAllProductDTO() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String categoryName = rs.getString("category_name");
                Integer categoryId = rs.getInt("category_id");
                productDTOList.add(new ProductDTO(id, name, price, quantity, color, categoryId, categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            System.out.println(SELECT_ALL_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public void insertProduct(Product product) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT)) {
            System.out.println(INSERT_NEW_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID)) {
            System.out.println(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> seachProductByName(String searchName) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, "%" + searchName + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                Integer categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                productDTOList.add(new ProductDTO(id, name, price, quantity, color, categoryId, categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }
}

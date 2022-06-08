package repository.impl;
/*
    Created by Trinh Khai
    Date: 22/03/2022
    Time: 19:08
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

    private static final String SELECT_ALL_PRODUCT = "select product_id, product_name, product_price, product_quantity, product_color, category.category_name, category.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id\n" +
            "order by product.product_id;";
    private static final String SELECT_ALL_CATEGORY = "select category_id, category_name from category;";
    private static final String INSERT_PRODUCT = "insert into product(product_name, product_price, product_quantity, product_color, category_id) values (?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT_BY_ID = "update product set product_name = ?, product_price = ?, product_quantity = ?, product_color = ?, category_id = ? where product_id = ?;";
    private static final String DELETE_PRODUCT_BY_ID = "delete from product where product_id = ?;";
    private static final String SEARCH_BY_ALL = "select product_id, product_name, product_price, product_quantity, product_color, category.category_name, product.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id\n" +
            "where product_name like ? and product_price like ? and product_color like ? and category.category_name like ?;";
    private static final String SEARCH_BY_NAME = "select product_id, product_name, product_price, product_quantity, product_color, category.category_name, product.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id\n" +
            "where product_name like ?;";
    private static final String SEARCH_BY_PRICE = "select product_id, product_name, product_price, product_quantity, product_color, category.category_name, product.category_id\n" +
            "from product\n" +
            "inner join category on product.category_id = category.category_id\n" +
            "where product_price like ?;";

    @Override
    public List<ProductDTO> findAllProduct() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                Double price = rs.getDouble("product_price");
                Integer quantity = rs.getInt("product_quantity");
                String color = rs.getString("product_color");
                String categoryName = rs.getString("category_name");
                Integer categoryId = rs.getInt("category_id");
                productDTOList.add(new ProductDTO(id, name, price, quantity, color, categoryName, categoryId));
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
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            System.out.println(INSERT_PRODUCT);
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
            System.out.println(UPDATE_PRODUCT_BY_ID);
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
    public List<ProductDTO> searchByAll(String name, String price, String color, String category) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ALL)) {
            System.out.println(SEARCH_BY_ALL);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + price + "%");
            preparedStatement.setString(3, "%" + color + "%");
            preparedStatement.setString(4, "%" + category + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                Double product_price = rs.getDouble("product_price");
                Integer product_quantity = rs.getInt("product_quantity");
                String product_color = rs.getString("product_color");
                String product_categoryName = rs.getString("category_name");
                Integer product_categoryId = rs.getInt("category_id");
                ProductDTO productDTO = new ProductDTO(product_id, product_name, product_price, product_quantity, product_color, product_categoryName, product_categoryId);
                productDTOList.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> searchByName(String name) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(SEARCH_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                Double product_price = rs.getDouble("product_price");
                Integer product_quantity = rs.getInt("product_quantity");
                String product_color = rs.getString("product_color");
                String product_categoryName = rs.getString("category_name");
                Integer product_categoryId = rs.getInt("category_id");
                productDTOList.add(new ProductDTO(product_id, product_name, product_price, product_quantity, product_color, product_categoryName, product_categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> searchByPrice(String price) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_PRICE)) {
            System.out.println(SEARCH_BY_PRICE);
            preparedStatement.setString(1, "%" + price + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                Double product_price = rs.getDouble("product_price");
                Integer product_quantity = rs.getInt("product_quantity");
                String product_color = rs.getString("product_color");
                String product_categoryName = rs.getString("category_name");
                Integer product_categoryId = rs.getInt("category_id");
                productDTOList.add(new ProductDTO(product_id, product_name, product_price, product_quantity, product_color, product_categoryName, product_categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }

    @Override
    public Integer getCount() {
        return null;
    }
}

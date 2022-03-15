package repository.impl;
/*
    Created by Trinh Khai
    Date: 14/03/2022
    Time: 14:56
*/

import model.User;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String INSERT_USER_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?;";
    private static final String SEARCH_USERS_BY_COUNTRY = "SELECT id, name, email, country FROM users WHERE country LIKE ?;";
    private static final String ORDER_BY_NAME = "SELECT id, name, email, country FROM users ORDER BY name ASC";

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public User selectUserById(Integer id) {
        User user = null;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public boolean deleteUser(Integer id) throws SQLException {
        boolean rowDelete;
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        } finally {
            connection.close();
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdate = statement.executeUpdate() > 0;
        } finally {
            connection.close();
        }
        return rowUpdate;
    }

    @Override
    public List<User> searchUserByCountry(String country1) {
        List<User> userSearchResultList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country1 + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userSearchResultList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userSearchResultList;
    }

    @Override
    public List<User> sortByName() {
        List<User> orderedList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ORDER_BY_NAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                orderedList.add(new User(id, name, email, country));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderedList;
    }
}

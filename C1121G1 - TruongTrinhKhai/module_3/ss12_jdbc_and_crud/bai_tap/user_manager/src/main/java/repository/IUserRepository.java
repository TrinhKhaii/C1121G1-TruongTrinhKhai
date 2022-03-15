package repository;
/*
    Created by Trinh Khai
    Date: 14/03/2022
    Time: 14:52
*/

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;

    User selectUserById(Integer id);

    List<User> selectAllUser();

    boolean deleteUser(Integer id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchUserByCountry(String country);

    List<User> sortByName();
}

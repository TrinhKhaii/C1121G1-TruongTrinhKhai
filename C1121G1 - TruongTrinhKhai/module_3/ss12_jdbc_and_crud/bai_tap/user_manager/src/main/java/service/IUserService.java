package service;
/*
    Created by Trinh Khai
    Date: 14/03/2022
    Time: 15:24
*/

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void insertUser(User user) throws SQLException;

    User selectUser(Integer id);

    List<User> selectAllUser();

    boolean deleteUser(Integer id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}

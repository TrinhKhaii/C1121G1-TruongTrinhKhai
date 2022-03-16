package dao;
/*
    Created by Trinh Khai
    Date: 13/03/2022
    Time: 11:37
*/

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User selectUser(Integer id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permisions);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();

    List<User> selectAllUsersBySP();

    void updateUserBySP(User user);

    void deleteUserBySP(Integer id);
}

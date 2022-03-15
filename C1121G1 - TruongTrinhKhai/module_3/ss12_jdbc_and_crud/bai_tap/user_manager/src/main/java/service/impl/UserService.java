package service.impl;
/*
    Created by Trinh Khai
    Date: 14/03/2022
    Time: 15:24
*/

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.*;

public class UserService implements IUserService {
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private IUserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userRepository.selectUserById(id);
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = userRepository.selectAllUser();
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });
        return userList;
    }

    @Override
    public boolean deleteUser(Integer id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchUserByCountry(String country) {
        if (!country.matches(STRING_REGEX)) {
            System.out.println("Country cannot have any extra spaces or no characters");
            return null;
        }
        return userRepository.searchUserByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public Map<String, String> check(User user) {
        Map<String, String> error = new HashMap<>();
        if (!user.getName().matches(STRING_REGEX)) {
            error.put("name", "Name cannot have any extra spaces or no characters");
        }
        if (!user.getEmail().matches(EMAIL_REGEX)) {
            error.put("email", "Wrong format of email");
        }
        if (!user.getCountry().matches(STRING_REGEX)) {
            error.put("country", "Country cannot have any extra spaces or no characters");
        }
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }
}

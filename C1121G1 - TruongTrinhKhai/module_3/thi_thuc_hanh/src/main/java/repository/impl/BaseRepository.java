package repository.impl;
/*
    Created by Trinh Khai
    Date: 24/03/2022
    Time: 15:17
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_thuc_hanh?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "12345678";
    private Connection connection;

    public BaseRepository() {}

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

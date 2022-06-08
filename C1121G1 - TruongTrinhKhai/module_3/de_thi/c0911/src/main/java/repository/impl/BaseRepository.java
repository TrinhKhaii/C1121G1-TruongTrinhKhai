package repository.impl;
/*
    Created by Trinh Khai
    Date: 22/03/2022
    Time: 19:05
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/de_thi_c09?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "Khai21122001";
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

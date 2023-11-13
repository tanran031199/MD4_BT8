package rikkei.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/productManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Manhthang01hd";

    public static Connection getConnection() {
        Connection connection;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }
}

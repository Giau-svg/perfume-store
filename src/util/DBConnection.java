package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/java_nuochoa";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode() + "\n" + e);
        }
        return null;
    }

    public static void close(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

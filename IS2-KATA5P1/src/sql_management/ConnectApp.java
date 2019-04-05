package sql_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectApp {

    public static Connection connect() {
        Connection connection = null;
        String url = "jdbc:sqlite:Kata5.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

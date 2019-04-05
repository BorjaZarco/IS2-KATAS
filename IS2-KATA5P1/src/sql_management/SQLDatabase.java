package sql_management;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase {

    public SQLDatabase (String name) {
        create(name);
    }

    public void create(String fileName) {
        String url = "jdbc:sqlite:" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("El driver es " + meta.getDriverName());
                System.out.println("Se ha creado una nueva BD.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}

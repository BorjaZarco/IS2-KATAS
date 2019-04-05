package sql_management;

import java.sql.*;

public class SelectApp {
    public final Connection connection;
    public SelectApp (Connection connection) {
        this.connection = connection;
    }

    public void selectFromDB(String searchQuery)  {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + "\t" +
                                resultSet.getString("Name") + "\t" +
                                resultSet.getString("Surname") + "\t" +
                                resultSet.getString("Department") + "\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
package sql_management;
import java.sql.*;

public class SQLTable {
    private final Connection connection;
    public final String name;


    public SQLTable(String tableName, Connection connection) {
        this.name = tableName;
        this.connection = connection;
    }

    public void create() {
        String sql = "CREATE TABLE IF NOT EXISTS "+ this.name +" (\n"
                + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " Mail text NOT NULL);";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String email) {
        String sql = "INSERT INTO "+this.name+" (Mail) VALUES(?)";
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Insercion finalizada");
    }

    public void select(String selectObject)  {
        String searchQuery = "select "+selectObject+"from "+this.name;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + "\t" +
                                resultSet.getString("mail") + "\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

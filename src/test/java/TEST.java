import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TEST {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Загрузка драйвера JDBC
            Class.forName("org.postgresql.Driver");

            // URL для подключения к PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/JavaEE";
            String username = "postgres";
            String password = "VladPavl45566";

            // Подключение к базе данных
            connection = DriverManager.getConnection(url, username, password);
            
            // Если подключение успешно, выведем сообщение
            System.out.println("Подключение к PostgreSQL успешно!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Закрываем соединение
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
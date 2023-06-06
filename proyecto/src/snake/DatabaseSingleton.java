package snake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private Connection connection;

    private DatabaseSingleton() {
        // Código de inicialización de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/proyecto";
        String usuario = "root";
        String contraseña = "programacion";

        try {
            connection = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
package org.example.surveysystem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL вашей базы данных, имя пользователя и пароль
    private static final String URL = "jdbc:postgresql://localhost:5433/surveydb"; // Замените на свой URL базы данных
    private static final String USER = "postgres"; // Ваш пользователь
    private static final String PASSWORD = "yourpassword"; // Ваш пароль

    // Метод для получения подключения к базе данных
    public static Connection getConnection() throws SQLException {
        try {
            // Регистрируем драйвер PostgreSQL, если это необходимо (можно убрать, если JDBC драйвер автоматически регистрируется)
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL JDBC Driver not found.");
        }

        // Возвращаем подключение к базе данных
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

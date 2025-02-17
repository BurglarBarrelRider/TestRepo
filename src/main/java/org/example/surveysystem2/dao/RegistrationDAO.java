package org.example.surveysystem2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {

    private static final String URL = "jdbc:postgresql://localhost:5433/surveydb"; // Ваш URL базы данных
    private static final String USER = "postgres"; // Ваш пользователь
    private static final String PASSWORD = "yourpassword"; // Ваш пароль

    // Метод для подключения к базе данных
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Метод для регистрации пользователя в базе данных
    public static boolean registerUser(String name, String surname, String age, String email, String password) {
        String sql = "INSERT INTO users (name, surname, age, email, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setInt(3, Integer.parseInt(age));
            stmt.setString(4, email);
            stmt.setString(5, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

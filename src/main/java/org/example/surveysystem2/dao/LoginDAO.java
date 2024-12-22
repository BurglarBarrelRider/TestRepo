package org.example.surveysystem2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.surveysystem2.DatabaseConnection;

public class LoginDAO {

    // Метод для проверки данных пользователя
    public boolean validate(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            // Если результат не пустой, то пользователь найден
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Если пользователь не найден
    }

    // Метод для получения userId по email
    public int getUserByEmail(String email) throws SQLException {
        String query = "SELECT user_id FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("user_id");  // Возвращаем user_id, если пользователь найден
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // Если пользователь не найден
    }
}

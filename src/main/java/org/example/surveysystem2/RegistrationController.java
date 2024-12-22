package org.example.surveysystem2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import org.example.surveysystem2.dao.RegistrationDAO;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {

    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    // Clear all fields
    @FXML
    public void clearFields(ActionEvent event) {
        nameField.clear();
        surnameField.clear();
        ageField.clear();
        emailField.clear();
        passwordField.clear();
    }

    // Save user data to the database
    @FXML
    public void registerUser(ActionEvent event) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String age = ageField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Check if any fields are empty
        if (name.isEmpty() || surname.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Please fill all fields!");
            return;
        }

        // Validate email format (simple check)
        if (!email.contains("@")) {
            showAlert("Please enter a valid email!");
            return;
        }

        // Register the user in the database
        boolean isRegistered = RegistrationDAO.registerUser(name, surname, age, email, password);

        if (isRegistered) {
            showAlert("Registration successful!");
            try {
                goToWelcome(event);  // Navigate to the Welcome page
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Failed to go to welcome screen.");
            }
        } else {
            showAlert("Registration failed! Please try again.");
        }
    }

    // Go to Welcome.fxml
    @FXML
    public void goToWelcome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/surveysystem2/Welcome.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Show an alert message
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }
}

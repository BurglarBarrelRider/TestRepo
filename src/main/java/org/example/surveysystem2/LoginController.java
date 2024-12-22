package org.example.surveysystem2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.surveysystem2.dao.LoginDAO;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button loginButton; // Login button

    @FXML
    private TextField emailField; // Corrected email input field reference to match FXML

    @FXML
    private PasswordField passwordField; // Password field

    @FXML
    private Label errorLabel; // Label for error messages

    private final LoginDAO loginDAO = new LoginDAO(); // DAO instance to handle validation

    // Method to handle the login button click event
    @FXML
    void onLoginButtonClick(ActionEvent event) {
        String email = emailField.getText(); // Use the correct field reference here
        String password = passwordField.getText();

        // Check if the email and password fields are not empty
        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Все поля должны быть заполнены!");
            errorLabel.setStyle("-fx-text-fill: red;");
        } else {
            // Validate the credentials using LoginDAO
            boolean isValid = loginDAO.validate(email, password);
            if (isValid) {
                errorLabel.setText("Вход выполнен успешно!");
                errorLabel.setStyle("-fx-text-fill: green;");
                try {
                    goToHelloPage(event);  // Navigate to hello-view.fxml on successful login
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                errorLabel.setText("Неверный email или пароль!");
                errorLabel.setStyle("-fx-text-fill: red;");
            }
        }
    }

    // Navigate to the hello-view.fxml screen
    @FXML
    public void goToHelloPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/surveysystem2/hello-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Navigate to the Welcome.fxml screen (for redirection purposes)
    @FXML
    public void goToWelcome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/surveysystem2/Welcome.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Getter and Setter for the login button (optional for further use in the application)
    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }
}

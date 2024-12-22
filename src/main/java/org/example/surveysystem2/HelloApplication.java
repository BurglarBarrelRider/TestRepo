package org.example.surveysystem2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Загружаем Welcome.fxml при старте приложения
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/surveysystem2/Welcome.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Welcome Screen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

module org.example.surveysystem2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.desktop;

    opens org.example.surveysystem2 to javafx.fxml;
    exports org.example.surveysystem2;
    exports org.example.surveysystem2.dao;
    opens org.example.surveysystem2.dao to javafx.fxml;
    exports org.example.surveysystem2.controller;
    opens org.example.surveysystem2.controller to javafx.fxml;

}


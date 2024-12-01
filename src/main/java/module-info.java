module org.example.testrepo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.testrepo to javafx.fxml;
    exports org.example.testrepo;
}
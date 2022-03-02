module com.example.filmai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.filmai to javafx.fxml;
    exports com.example.filmai;
}
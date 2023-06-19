module com.example.dotcwiczenie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dotcwiczenie to javafx.fxml;
    exports com.example.dotcwiczenie;
}
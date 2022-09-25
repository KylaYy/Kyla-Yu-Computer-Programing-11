module com.example.kylayugameofchance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kylayugameofchance to javafx.fxml;
    exports com.example.kylayugameofchance;
}
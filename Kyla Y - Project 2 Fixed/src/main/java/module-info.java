module com.example.kylay_project2_fixed {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.kylay_project2_fixed to javafx.fxml;
    exports com.example.kylay_project2_fixed;
}
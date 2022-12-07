module com.example.kylayufriendsbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kylayufriendsbook to javafx.fxml;
    exports com.example.kylayufriendsbook;
}
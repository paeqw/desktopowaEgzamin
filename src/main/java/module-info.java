module com.example.desktopowa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.desktopowa to javafx.fxml;
    exports com.example.desktopowa;
}
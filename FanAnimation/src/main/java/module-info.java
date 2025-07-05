module com.example.fananimation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fananimation to javafx.fxml;
    exports com.example.fananimation;
}
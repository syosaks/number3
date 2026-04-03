module com.example.number3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.number3 to javafx.fxml;
    exports com.example.number3;
}
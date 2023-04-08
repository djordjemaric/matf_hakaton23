module com.example.hakaton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hakaton to javafx.fxml;
    exports com.example.hakaton;
}
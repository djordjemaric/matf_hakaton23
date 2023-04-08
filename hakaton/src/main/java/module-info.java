module com.example.hakaton {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.hakaton to javafx.fxml;
    exports com.example.hakaton;
}
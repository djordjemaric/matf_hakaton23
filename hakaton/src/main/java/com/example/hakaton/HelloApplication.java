package com.example.hakaton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();

        VBox left = new VBox();
        Button nivo1 = new Button("1");
        Button nivo2 = new Button("2");
        Button nivo3 = new Button("3");

        left.getChildren().addAll(nivo1, nivo2, nivo3);

        VBox right = new VBox();
        Button dalje = new Button("dalje");
        right.getChildren().addAll(dalje);

        root.getChildren().addAll(left, right);

        Scene scena = new Scene(root,800,640);
        stage.setScene(scena);
        stage.setTitle("Nivoi");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
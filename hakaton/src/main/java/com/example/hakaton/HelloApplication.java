package com.example.hakaton;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        HBox nivoi = new HBox();

        Button nivo1 = new Button("1");
        Button nivo2 = new Button("2");
        Button nivo3 = new Button("3");

        nivo1.setOnAction(e -> {
            Tutorijal tutorijal1 = new Tutorijal(1, "Prva lekcija iz SQL-a");
            tutorijal1.show();
        });

        Button dalje = new Button("dalje");

        nivoi.getChildren().addAll(nivo1, nivo2, nivo3, dalje);
        root.getChildren().addAll(nivoi);

        Scene scena = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scena.getStylesheets().add("style.css");
        stage.setScene(scena);
        stage.setTitle("Nivoi");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
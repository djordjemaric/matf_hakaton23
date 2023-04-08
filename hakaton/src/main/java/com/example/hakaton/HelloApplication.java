package com.example.hakaton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    Boolean[] activated = {false,false,false,false,false,false,false,false,false};
    @Override
    public void start(Stage stage) throws IOException {
        HBox root1 = new HBox();
        HBox root2 = new HBox();
        HBox root3 = new HBox();

        HBox top1 = new HBox();
        HBox top2 = new HBox();
        HBox top3 = new HBox();

        Button nivo1 = new Button("1");
        Button nivo2 = new Button("2");
        Button nivo3 = new Button("3");
        Button dalje1 = new Button("Next");

        Button nivo4 = new Button("4");
        Button nivo5 = new Button("5");
        Button nivo6 = new Button("6");
        Button dalje2 = new Button("Next");

        Button nivo7 = new Button("7");
        Button nivo8 = new Button("8");
        Button nivo9 = new Button("9");
        Button dalje3 = new Button("Finish");

        nivo2.setDisable(true);
        nivo3.setDisable(true);
        nivo4.setDisable(true);
        nivo5.setDisable(true);
        nivo6.setDisable(true);
        nivo7.setDisable(true);
        nivo8.setDisable(true);
        nivo9.setDisable(true);
        dalje1.setDisable(true);
        dalje2.setDisable(true);
        dalje3.setDisable(true);

        top1.getChildren().addAll(nivo1, nivo2, nivo3);
        top1.getChildren().addAll(dalje1);
        root1.getChildren().addAll(top1);

        top2.getChildren().addAll(nivo4, nivo5, nivo6);
        top2.getChildren().addAll(dalje2);
        root2.getChildren().addAll(top2);

        top3.getChildren().addAll(nivo7, nivo8, nivo9);
        top3.getChildren().addAll(dalje3);
        root3.getChildren().addAll(top3);

        TextArea textAreaT = new TextArea("kasgfkashfkahskfhasku\nakshfkashf\naksfhb");
        TextArea textAreaV = new TextArea("kasgfaahskfhasku\naksdfhdfhfffkashf\nakssdfsssssfhb");
        TextField textFieldV = new TextField();
        Button btnT = new Button("Probaj");
        Button btnV = new Button("Prosledi resenje");
        VBox vbT = new VBox();
        VBox vbV = new VBox();
        vbT.getChildren().addAll(textAreaT,btnT);
        vbV.getChildren().addAll(textAreaV,textFieldV,btnV);

        nivo1.setOnAction(e -> {
            if(!activated[0]){
                root1.getChildren().addAll(vbT);
                activated[0] = true;
            }else{
                root1.getChildren().remove(1);
                activated[0] = false;
            }
        });

        btnT.setOnAction(e -> {
            root1.getChildren().remove(1);
            root1.getChildren().addAll(vbV);
        });

        btnV.setOnAction(e -> {

            root1.getChildren().remove(1);
            nivo1.setStyle("-fx-background-color: #4CAF50;");
            nivo2.setDisable(false);
        });

        Scene scena1 = new Scene(root1,800,640);
        Scene scena2 = new Scene(root2,800,640);
        Scene scena3 = new Scene(root3,800,640);

        stage.setScene(scena1);
        stage.setTitle("Stage 1");
        stage.show();

        dalje1.setOnAction(e -> {
            stage.setScene(scena2);
            stage.setTitle("Stage 2");
            stage.show();
        });

        dalje2.setOnAction(e -> {
            stage.setScene(scena3);
            stage.setTitle("Stage 3");
            stage.show();
        });

        dalje3.setOnAction(e -> {
            stage.setScene(scena1);
            stage.setTitle("Stage 1");
            stage.show();
        });

    }

    public static void main(String[] args) {
        launch();
    }
}

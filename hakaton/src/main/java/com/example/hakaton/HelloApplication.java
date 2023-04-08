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
    Boolean mozesNivo = true;
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
        nivo2.setOnAction(e -> {
            if(!activated[1]){
                root1.getChildren().addAll(vbT);
                activated[1] = true;
            }else{
                root1.getChildren().remove(1);
                activated[1] = false;
            }
        });
        nivo3.setOnAction(e -> {
            if(!activated[2]){
                root1.getChildren().addAll(vbT);
                activated[2] = true;
            }else{
                root1.getChildren().remove(1);
                activated[2] = false;
            }
        });

        nivo4.setOnAction(e -> {
            if(!activated[3]){
                root2.getChildren().addAll(vbT);
                activated[3] = true;
            }else{
                root2.getChildren().remove(1);
                activated[3] = false;
            }
        });
        nivo5.setOnAction(e -> {
            if(!activated[4]){
                root2.getChildren().addAll(vbT);
                activated[4] = true;
            }else{
                root2.getChildren().remove(1);
                activated[4] = false;
            }
        });
        nivo6.setOnAction(e -> {
            if(!activated[5]){
                root2.getChildren().addAll(vbT);
                activated[5] = true;
            }else{
                root2.getChildren().remove(1);
                activated[5] = false;
            }
        });

        nivo7.setOnAction(e -> {
            if(!activated[6]){
                root3.getChildren().addAll(vbT);
                activated[6] = true;
            }else{
                root3.getChildren().remove(1);
                activated[6] = false;
            }
        });
        nivo8.setOnAction(e -> {
            if(!activated[7]){
                root3.getChildren().addAll(vbT);
                activated[7] = true;
            }else{
                root3.getChildren().remove(1);
                activated[7] = false;
            }
        });
        nivo9.setOnAction(e -> {
            if(!activated[8]){
                root3.getChildren().addAll(vbT);
                activated[8] = true;
            }else{
                root3.getChildren().remove(1);
                activated[8] = false;
            }
        });

        btnT.setOnAction(e -> {
            if(activated[0] || activated[1] || activated[2]) {
                root1.getChildren().remove(1);
                root1.getChildren().addAll(vbV);
            }
            if(activated[3] || activated[4] || activated[5]) {
                root2.getChildren().remove(1);
                root2.getChildren().addAll(vbV);
            }
            if(activated[6] || activated[7] || activated[8]) {
                root3.getChildren().remove(1);
                root3.getChildren().addAll(vbV);
            }
        });

        btnV.setOnAction(e -> {
            //if(!nivo1.isDisabled()) {
            if (activated[0]) {
                root1.getChildren().remove(1);
                nivo1.setStyle("-fx-background-color: #4CAF50;");
                nivo2.setDisable(false);
                activated[0] = false;
                //nivo1.setDisable(true);
                return;
            }
            //if(!nivo2.isDisabled()
            if (activated[1]) {
                root1.getChildren().remove(1);
                nivo2.setStyle("-fx-background-color: #4CAF50;");
                nivo3.setDisable(false);
                activated[1] = false;
                //nivo2.setDisable(true);
                return;
            }
            //if(!nivo3.isDisabled()) {
            if (activated[2]) {
                root1.getChildren().remove(1);
                nivo3.setStyle("-fx-background-color: #4CAF50;");
                nivo4.setDisable(false);
                dalje1.setDisable(false);
                activated[2] = false;
                //nivo3.setDisable(true);
                return;
            }
            //if(!nivo4.isDisabled()) {
            if (activated[3]) {
                root2.getChildren().remove(1);
                nivo4.setStyle("-fx-background-color: #4CAF50;");
                nivo5.setDisable(false);
                activated[3] = false;
                //nivo4.setDisable(true);
                return;
            }
            //if(!nivo5.isDisabled()) {
            if (activated[4]) {
                root2.getChildren().remove(1);
                nivo5.setStyle("-fx-background-color: #4CAF50;");
                nivo6.setDisable(false);
                activated[4] = false;
                //nivo5.setDisable(true);
                return;
            }
            //if(!nivo6.isDisabled()) {
            if (activated[5]) {
                root2.getChildren().remove(1);
                nivo6.setStyle("-fx-background-color: #4CAF50;");
                nivo7.setDisable(false);
                dalje2.setDisable(false);
                activated[5] = false;
                //nivo6.setDisable(true);
                return;
            }
            //if(!nivo7.isDisabled()) {
            if (activated[6]) {
                root3.getChildren().remove(1);
                nivo7.setStyle("-fx-background-color: #4CAF50;");
                nivo8.setDisable(false);
                activated[6] = false;
                //nivo7.setDisable(true);
                return;
            }
            //if(!nivo8.isDisabled()) {
            if (activated[7]) {
                root3.getChildren().remove(1);
                nivo8.setStyle("-fx-background-color: #4CAF50;");
                nivo9.setDisable(false);
                activated[7] = false;
                //nivo8.setDisable(true);
                return;
            }
            //if(!nivo9.isDisabled()) {
            if (activated[8]) {
                root3.getChildren().remove(1);
                nivo9.setStyle("-fx-background-color: #4CAF50;");
                dalje3.setDisable(false);
                activated[8] = false;
                //nivo9.setDisable(true);
            }
        });

        VBox rootB = new VBox();
        VBox rootE = new VBox();
        TextArea taB = new TextArea("Dobrodosli");
        TextArea taE = new TextArea("Uspesno ste zavrsili sve lekcije");
        Button btnB = new Button("Zapocni");
        Button btnE = new Button("Zavrsi");
        rootB.getChildren().addAll(taB,btnB);
        rootE.getChildren().addAll(taE,btnE);

        Scene pocetna = new Scene(rootB,800,600);
        pocetna.getStylesheets().addAll("style.css");
        Scene scena1 = new Scene(root1,800,640);
        scena1.getStylesheets().addAll("style.css");
        Scene scena2 = new Scene(root2,800,640);
        scena2.getStylesheets().addAll("style.css");
        Scene scena3 = new Scene(root3,800,640);
        scena3.getStylesheets().addAll("style.css");
        Scene poslednja = new Scene(rootE,800,600);
        poslednja.getStylesheets().addAll("style.css");

        stage.setScene(pocetna);
        stage.setTitle("Dobrodosli");
        stage.show();

        btnB.setOnAction(e -> {
            stage.setScene(scena1);
            stage.setTitle("Stage 1");
            stage.show();
        });

        btnE.setOnAction(e -> {
            stage.close();
        });

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
            stage.setScene(poslednja);
            stage.setTitle("Kraj");
            stage.show();
        });

    }

    public static void main(String[] args) {
        launch();
    }
}

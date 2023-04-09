package com.example.hakaton;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Asocijacija extends Stage {

    public Asocijacija() {

        String[][] odgovori = {
                {"pera", "peric", "tijana", "profesor"},
                {"38161123456", "2001", "2005", "broj"},
                {"sinus", "kvadratna", "inverzan", "funkcija"}
        };



        VBox root = new VBox();
        HBox top = new HBox();
        HBox bot = new HBox();

        root.getChildren().addAll(top, bot);

        VBox vbL = new VBox();
        vbL.setPadding(new Insets(10, 10, 10, 10));
        VBox vbS = new VBox();
        vbS.setPadding(new Insets(10, 10, 10, 10));
        VBox vbD = new VBox();
        vbD.setPadding(new Insets(10, 10, 10, 10));
        top.getChildren().addAll(vbL, vbS, vbD);

        HBox hbL1 = new HBox();
        Label lbL1 = new Label("1: ");
        TextField tfL1 = new TextField();
        hbL1.getChildren().addAll(lbL1,tfL1);

        HBox hbL2 = new HBox();
        Label lbL2 = new Label("2: ");
        TextField tfL2 = new TextField();
        hbL2.getChildren().addAll(lbL2, tfL2);

        HBox hbL3 = new HBox();
        Label lbL3 = new Label("3: ");
        TextField tfL3 = new TextField();
        hbL3.getChildren().addAll(lbL3, tfL3);

        HBox hbLR = new HBox();
        Label lbLR = new Label("R: ");
        TextField tfLR = new TextField();
        hbLR.getChildren().addAll(lbLR, tfLR);

        tfLR.setPromptText("Resenje kolone 1");

        Button btnL = new Button("Kolona1");
        btnL.setOnAction(e -> {
            if(tfL1.getText().toLowerCase().equals(odgovori[0][0]) && tfL2.getText().toLowerCase().equals(odgovori[0][1]) && tfL3.getText().toLowerCase().equals(odgovori[0][2]) && tfLR.getText().toLowerCase().equals(odgovori[0][3])) {
                System.out.println("Brao kolona 1");
                vbL.setDisable(true);
            }
        });

        vbL.getChildren().addAll(hbL1, hbL2,hbL3, hbLR, btnL);

        // Creating a HBox with a Label and a TextField for tfL1
        HBox hbS1 = new HBox();
        Label lbS1 = new Label("1: ");
        TextField tfS1 = new TextField();
        hbS1.getChildren().addAll(lbS1,tfS1);

// Creating a HBox with a Label and a TextField for tfL2
        HBox hbS2 = new HBox();
        Label lbS2 = new Label("2: ");
        TextField tfS2 = new TextField();
        hbS2.getChildren().addAll(lbS2, tfS2);

// Creating a HBox with a Label and a TextField for tfL3
        HBox hbS3 = new HBox();
        Label lbS3 = new Label("3: ");
        TextField tfS3 = new TextField();
        hbS3.getChildren().addAll(lbS3, tfS3);

// Creating a HBox with a Label and a TextField for tfLR
        HBox hbSR = new HBox();
        Label lbSR = new Label("R: ");
        TextField tfSR = new TextField();
        hbSR.getChildren().addAll(lbSR, tfSR);

        tfSR.setPromptText("Resenje kolone 3");

        Button btnS = new Button("Kolona2");

        btnS.setOnAction(e -> {
            if(tfS1.getText().toLowerCase().equals(odgovori[1][0]) && tfS2.getText().toLowerCase().equals(odgovori[1][1]) && tfS3.getText().toLowerCase().equals(odgovori[1][2]) && tfSR.getText().toLowerCase().equals(odgovori[1][3])) {
                System.out.println("Brao kolona 2");
                vbS.setDisable(true);
            }
        });

        vbS.getChildren().addAll(hbS1, hbS2, hbS3, hbSR, btnS);



        HBox hbR1 = new HBox();
        Label lbR1 = new Label("1: ");
        TextField tfR1 = new TextField();
        hbR1.getChildren().addAll(lbR1,tfR1);

        HBox hbR2 = new HBox();
        Label lbR2 = new Label("2: ");
        TextField tfR2 = new TextField();
        hbR2.getChildren().addAll(lbR2, tfR2);

        HBox hbR3 = new HBox();
        Label lbR3 = new Label("3: ");
        TextField tfR3 = new TextField();
        hbR3.getChildren().addAll(lbR3, tfR3);

        HBox hbRR = new HBox();
        Label lbRR = new Label("R: ");
        TextField tfRR = new TextField();
        hbRR.getChildren().addAll(lbRR, tfRR);

        tfRR.setPromptText("Resenje kolone 3");

        Button btnD = new Button("Kolona3");

        btnD.setOnAction(e -> {
            if(tfR1.getText().toLowerCase().equals(odgovori[2][0]) && tfR2.getText().toLowerCase().equals(odgovori[2][1]) && tfR3.getText().toLowerCase().equals(odgovori[2][2]) && tfRR.getText().toLowerCase().equals(odgovori[2][3])) {
                System.out.println("Brao kolona 3");
                vbD.setDisable(true);
            }
        });

        vbD.getChildren().addAll(hbR1, hbR2, hbR3, hbRR, btnD);

        VBox vbB = new VBox();
        TextField tfB = new TextField();
        Button btnB = new Button("KONACNO");
        btnB.setOnAction(e -> {
            if(tfB.getText().toLowerCase().equals("matematika")) {
                System.out.println("POGODJENO");
                tfB.setDisable(true);
//                stage.close();
                close();
            }
        });
        vbB.getChildren().addAll(tfB, btnB);
        bot.getChildren().addAll(vbB);

        Scene scena = new Scene(root, 700, 400);
        setScene(scena);
        setTitle("Asocijacija");
//        stage.setScene(scena);
//        stage.show();

    }

}

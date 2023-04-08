package com.example.hakaton;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Tutorijal extends Stage {
    private int nivo;

    public Tutorijal(int nivo, String opis) {
        setTitle("Tutorijal za nivo " + nivo);

        Group koren = new Group();

        Text paragraf = new Text();
        paragraf.setFont(Font.font("Verdana", 12));
        paragraf.setText(opis);

        Translate pozicija = new Translate(10, 30);
        paragraf.getTransforms().addAll(pozicija);
        koren.getChildren().addAll(paragraf);

        setScene(new Scene(koren, 400, 400));
    }
}

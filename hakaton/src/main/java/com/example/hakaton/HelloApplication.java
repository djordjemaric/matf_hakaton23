package com.example.hakaton;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class HelloApplication extends Application {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 640;
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



        nivo1.setShape(new Circle(25));
        nivo1.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.12, 20)
        );
        nivo2.setShape(new Circle(25));
        nivo2.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.42, 20)
        );
        nivo3.setShape(new Circle(25));
        nivo3.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.72, 20)
        );

        nivo4.setShape(new Circle(25));
        nivo4.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.12, 20)
        );
        nivo5.setShape(new Circle(25));
        nivo5.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.42, 20)
        );
        nivo6.setShape(new Circle(25));
        nivo6.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.72, 20)
        );
        nivo7.setShape(new Circle(25));
        nivo7.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.12, 20)
        );

        nivo8.setShape(new Circle(25));
        nivo8.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.42, 20)
        );

        nivo9.setShape(new Circle(25));
        nivo9.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.72, 20)
        );

        dalje1.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.7, WINDOW_HEIGHT * 0.9)
        );

        dalje2.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.7, WINDOW_HEIGHT * 0.9)
        );

        dalje3.getTransforms().addAll(
                new Translate(WINDOW_WIDTH * 0.7, WINDOW_HEIGHT * 0.9)
        );




        top1.getChildren().addAll(nivo1, nivo2, nivo3);
        top1.getChildren().addAll(dalje1);
        root1.getChildren().addAll(top1);

        top2.getChildren().addAll(nivo4, nivo5, nivo6);
        top2.getChildren().addAll(dalje2);
        root2.getChildren().addAll(top2);

        top3.getChildren().addAll(nivo7, nivo8, nivo9);
        top3.getChildren().addAll(dalje3);
        root3.getChildren().addAll(top3);

        Text textAreaT = new Text("Osnovni upit se sastoji od naredbi SELECT i FROM\n" +
                "SELECT naredbom oznacavamo koje atribute zelimo da izdvojimo\n" +
                "FROM naredbom oznacavamo iz koje tabele zelimo da izdvojimo informacije\n" +
                "Ukoliko zelimo da izdvojimo sve atribute, mozemo iskoristiti operator *\n" +
                "\n" +
                "Hajde da izvrsimo nas prvi upit. Zelimo da izdvojimo sve atribute o svim ucenicima u nasoj skoli.\n" +
                "\n" +
                "Upit izgleda ovako: SELECT * FROM skola; \n Red je na tebe da probas! Klikni na dugme!");

        //prikazi sliku
        Text textAreaV = new Text("Izdvoji sve atribute o svim ucenicima u skoli. \n\nKlikni na probaj kada si spreman da proveris svoje resenje.");
        TextField textFieldV = new TextField();
        Button btnT = new Button("Probaj");
        Button btnV = new Button("Prosledi resenje");
        VBox vbT = new VBox();
        VBox vbV = new VBox();

        Rectangle okvir = new Rectangle();
        okvir.setHeight(200);
        okvir.setWidth(500);

        Image prvaT = new Image("2.png");
        ImagePattern paternPrvaT = new ImagePattern(prvaT);
        okvir.setFill(paternPrvaT);

        vbT.getChildren().addAll(textAreaT,okvir,btnT);

        Image prvaV = new Image("1.png");
        ImagePattern paternPrvaV = new ImagePattern(prvaV);

        Rectangle okvir2 = new Rectangle();
        okvir2.setHeight(200);
        okvir2.setWidth(500);

        okvir2.setFill(paternPrvaV);
        vbV.getChildren().addAll(textAreaV,textFieldV,okvir2,btnV);

        vbT.getTransforms().addAll(
                new Translate(-30,WINDOW_HEIGHT*0.3)
        );

        vbV.getTransforms().addAll(
                new Translate(-30,WINDOW_HEIGHT*0.3)
        );

        btnT.getTransforms().addAll(
                new Translate(200, 0)
        );

        btnV.getTransforms().addAll(
                new Translate(160, 0)
        );

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
                textAreaT.setText("Ukoliko zelimo samo odredjene informacije o ucenicima, to mozemo uraditi\n u okvirPraznau SELECT naredbe." +
                        "Zelimo da izdvojimo samo imena za sve ucenike. \nTo mozemo uraditi sledecim upitom:  SELECT ime FROM skola;\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "\n" +
                        "Red je na tebe da probas! Klikni na dugme! ->");
                textAreaV.setText("Izdvoji prezimena za sve ucenike u skoli.\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("3.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root1.getChildren().addAll(vbT);
                activated[1] = true;
            }else{
                root1.getChildren().remove(1);
                activated[1] = false;
            }
        });
        nivo3.setOnAction(e -> {
            if(!activated[2]){
                textAreaT.setText("Mozemo odabrati proizvoljan broj atributa iz tabele.\nSada zelimo da izdvojimo ime i prezime za sve ucenike.\n" +
                        "To mozemo uraditi sledecim upitom: SELECT ime, prezime FROM skola\n" +
                        "\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Izdvoji ime, adresu i broj telefona za svakog ucenika.\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("5.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root1.getChildren().addAll(vbT);
                activated[2] = true;
            }else{
                root1.getChildren().remove(1);
                activated[2] = false;
            }
        });

        nivo4.setOnAction(e -> {
            if(!activated[3]){
                textAreaT.setText("WHERE naredbu koristimo kako bismo izdvojili samo one redove koji ispunjavaju navedeni uslov.\n" +
                        "Mozemo koristiti operatore =, >, < <>\n" +
                        "\n" +
                        "Zelimo da izdvojimo sve atribute samo o onin ucenicima koji su rodjeni nakon 2001 godine.\n" +
                        "\n" +
                        "SELECT * FROM skola WHERE godina > 2001;\n" +
                        "\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Izdvoji sve informacije o ucenicima rodjenim pre 2003 godine.\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("7.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root2.getChildren().addAll(vbT);
                activated[3] = true;
            }else{
                root2.getChildren().remove(1);
                activated[3] = false;
            }
        });
        nivo5.setOnAction(e -> {
            if(!activated[4]){
                textAreaT.setText("Ukoliko su nam potrebni stroziji kriterijumi, uslove mozemo spajati naredbama AND i OR.\n\n" +
                        "Ako upotrebimo AND, da bi red bio izdvojen neophodno je da oba uslova budu ispunjena.\n\n" +
                        "U slucaju da se koristi OR, dovoljno je da bar jedan bude ispunjen kako bi red bio izdvojen.\n\n" +
                        "Pogledajmo na primeru: Zelimo da izdvojimo sve decake rodjene 2001. godine\n" +
                        "SELECT * FROM skola WHERE godina > 2001 AND pol = M\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Izdvoji sve ucenike koji su rodjeni 2003. godine ili su devojcice\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("9.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root2.getChildren().addAll(vbT);
                activated[4] = true;
            }else{
                root2.getChildren().remove(1);
                activated[4] = false;
            }
        });
        nivo6.setOnAction(e -> {
            if(!activated[5]){
                textAreaT.setText("Ukoliko imamo vise dozvoljenih opcija, umesto da pisemo nekoliko OR naredbi,\n mozemo iskoristiti IN naredbu.\n" +
                        "Hajde da izdvojimo sve ucenike koji se zovu Pera, Mika ili Jelena\n" +
                        "\n" +
                        "SELECT *  FROM skola WHERE ime IN ('Pera', 'Mika', 'Jelena')\n" +
                        "\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Izdvoji sve ucenike koji se prezivaju Mikic, Zikic, ili Janic.\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("11.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root2.getChildren().addAll(vbT);
                activated[5] = true;
            }else{
                root2.getChildren().remove(1);
                activated[5] = false;
            }
        });

        nivo7.setOnAction(e -> {
            if(!activated[6]){
                textAreaT.setText("Nase rezultate mozemo uredjivati po razlicitim kriterijumima naredbom ORDER BY.\n" +
                        "Ukoliko zelimo da budu uredjeni po kriterijumu rastuce, koristimo kljucnu rec ASC (ascending). \n" +
                        "Ako zelimo opadajuce, koristimo DESC (descending)\n" +
                        "\n" +
                        "Hajde da izdvojimo sve ucenike, ali da ih uredimo azbucno po imenu.\n" +
                        "\n" +
                        "SELECT * FROM skola ORDER BY ime ASC;\n" +
                        "\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Izdvoji sve ucenike a rezultat uredi po godini opadajuce.\nKlikni na probaj kada si spreman da proveris svoje resenje.");

                Image slika = new Image("13.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root3.getChildren().addAll(vbT);
                activated[6] = true;
            }else{
                root3.getChildren().remove(1);
                activated[6] = false;
            }
        });
        nivo8.setOnAction(e -> {
            if(!activated[7]){
                textAreaT.setText("Nad upitima mozemo izvrsavati i skupovne operacije \n" +
                        "UNION - u rezultatu ce se naci svi redovi iz oba upita\n" +
                        "INTERSECT - u rezultatu ce se naci samo oni redovi koji se nalaze u oba upita\n" +
                        "EXCEPT - u rezultatu ce se naci redovi koji se nalaze u prvom upitu ali se NE nalaze u drugom\n" +
                        "Neophodno je da oba upita izdvajaju iste atribute kako bi skupovna operacija bila izvrsena.\n" +
                        "Hajde da izdvojimo sve ucenike koji su rodjeni 2001. godine i koji su decaci.\n" +
                        "SELECT * FROM skola WHERE godina = 2001\n" +
                        "UNION\n" +
                        "SELECT * FROM skola WHERE pol = M\n" +
                        "Rezultat izvrsavanja je obojen plavom bojom\n" +
                        "Red je na tebe da probas! Klikni na dugme!");
                textAreaV.setText("Koristeci skupovne operatore, izdvoji sve devojcice sem onih koje su rodjene 2003.\n" +
                        "Hint: koristi operator EXCEPT");

                Image slika = new Image("15.png");
                ImagePattern slikaPatern = new ImagePattern(slika);
                okvir.setFill(slikaPatern);
                root3.getChildren().addAll(vbT);
                activated[7] = true;
            }else{
                root3.getChildren().remove(1);
                activated[7] = false;
            }
        });
        nivo9.setOnAction(e -> {
            if(!activated[8]){
                textAreaT.setText("Vreme je da proverimo sta si naucio! \n" +
                        "Na sledecem slajdu se nalazi zadatak gde ces moci da proveris sve oblasti koje smo danas obradili");
                textAreaV.setText("Napisi dva upita. \n" +
                        "Prvi - Izdvoji ime, prezime i adresu svih ucenika koji se prezivaju Mikic ili su \nrodjeni 2000. ili 2005. godine. Hint: koristi IN operator\n" +
                        "Drugi - Izdvoji ime, prezime i adresu svih decaka koji nisu rodjeni 2001.\n" +
                        "Napravi presek izmedju ova dva upita.\n");
                okvir.setFill(null);
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

            // pokreni animaciju
            if (activated[0]) {
                root1.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root1.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("2.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root1.getChildren().remove(1);
                });
                fejd.play();

                nivo1.setStyle("-fx-background-color: #4CAF50;");
                nivo2.setDisable(false);
                activated[0] = false;
                //nivo1.setDisable(true);
                return;
            }
            //if(!nivo2.isDisabled()
            if (activated[1]) {
                root1.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root1.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("4.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root1.getChildren().remove(1);
                });
                fejd.play();

                nivo2.setStyle("-fx-background-color: #4CAF50;");
                nivo3.setDisable(false);
                activated[1] = false;
                //nivo2.setDisable(true);
                return;
            }
            //if(!nivo3.isDisabled()) {
            if (activated[2]) {
                root1.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root1.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("6.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root1.getChildren().remove(1);
                });
                fejd.play();

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

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root2.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("8.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root2.getChildren().remove(1);
                });
                fejd.play();

                nivo4.setStyle("-fx-background-color: #4CAF50;");
                nivo5.setDisable(false);
                activated[3] = false;
                //nivo4.setDisable(true);
                return;
            }
            //if(!nivo5.isDisabled()) {
            if (activated[4]) {
                root2.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root2.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("10.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root2.getChildren().remove(1);
                });
                fejd.play();

                nivo5.setStyle("-fx-background-color: #4CAF50;");
                nivo6.setDisable(false);
                activated[4] = false;
                //nivo5.setDisable(true);
                return;
            }
            //if(!nivo6.isDisabled()) {
            if (activated[5]) {
                root2.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root2.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("12.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root2.getChildren().remove(1);
                });
                fejd.play();

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

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root3.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("14.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root3.getChildren().remove(1);
                });
                fejd.play();

                nivo7.setStyle("-fx-background-color: #4CAF50;");
                nivo8.setDisable(false);
                activated[6] = false;
                //nivo7.setDisable(true);
                return;
            }
            //if(!nivo8.isDisabled()) {
            if (activated[7]) {
                root3.getChildren().remove(1);

                Group group = new Group();

                Rectangle okvir3 = new Rectangle();
                okvir3.setHeight(200);
                okvir3.setWidth(500);

                Rectangle okvir2c = new Rectangle();
                okvir2c.setHeight(200);
                okvir2c.setWidth(500);

                Image c = new Image("1.png");
                ImagePattern paternc = new ImagePattern(c);
                okvir2c.setFill(paternc);

                group.getChildren().addAll(okvir3,okvir2c);
                group.getTransforms().addAll(
                        new Translate(-30, WINDOW_HEIGHT * 0.3)
                );

                root3.getChildren().addAll(group);

                FadeTransition fejd = new FadeTransition(Duration.seconds(2),okvir2c);
                fejd.setFromValue(1.0);
                fejd.setToValue(0.0);

                Image p = new Image("16.png");
                ImagePattern pp = new ImagePattern(p);
                okvir3.setFill(pp);


                fejd.setOnFinished(actionEvent -> {
                    root3.getChildren().remove(1);
                });
                fejd.play();

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
        Label taB = new Label("SQL je upitni jezik koji se koristi za izvrsavanje upita nad relacionim bazama podataka. \n" +
                "\n" +
                "Podaci se u bazama podataka cuvaju u tabelama. \n" +
                "Tabela se sastoji od kolona koje oznacavaju osobine/atribute.\nSvaki red u tabeli cuva vrednosti tih atributa.\n" +
                "\n" +
                "Tabela koju cemo korisiti u nastavku opisuje ucenike u jednoj skoli i izgleda ovako:");
        //taB.setStyle("-fx-text-alignment: center;");
        Text taE = new Text("Uspesno ste zavrsili sve lekcije");
        //taE.setStyle("-fx-text-alignment: center;");
        Button btnB = new Button("Zapocni");
        Button btnE = new Button("Zavrsi");
        rootB.getChildren().addAll(taB,btnB);
        rootE.getChildren().addAll(taE,btnE);

        btnB.getTransforms().addAll(
                new Translate(350, 0)
        );

        btnE.getTransforms().addAll(
                new Translate(350, 0)
        );

        Scene pocetna = new Scene(rootB,WINDOW_WIDTH, WINDOW_HEIGHT);
        pocetna.getStylesheets().addAll("style.css");
        Scene scena1 = new Scene(root1,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena1.getStylesheets().addAll("style.css");
        Scene scena2 = new Scene(root2,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena2.getStylesheets().addAll("style.css");
        Scene scena3 = new Scene(root3,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena3.getStylesheets().addAll("style.css");
        Scene poslednja = new Scene(rootE,WINDOW_WIDTH, WINDOW_HEIGHT);
        poslednja.getStylesheets().addAll("style.css");


        stage.setScene(pocetna);
        stage.setTitle("Dobrodosli");
        stage.setResizable(false);
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

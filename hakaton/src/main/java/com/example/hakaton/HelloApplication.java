package com.example.hakaton;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
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
import java.util.Date;
import java.util.Objects;


public class HelloApplication extends Application {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 597;
    Boolean[] activated = {false,false,false,false,false,false,false,false,false};
    Boolean mozesNivo = true;
    String odgovori[] = {
            "SELECT * FROM skola;",
            "SELECT prezime FROM skola;",
            "SELECT ime, adresa, telefon FROM skola;",
            "SELECT * FROM SKOLA where godina < 2003;",
            "SELECT * FROM skola WHERE godina = 2003 OR pol='Z';",
            "SELECT * FROM skola WHERE prezime IN ('Mikic', 'Zikic', 'Janic');",
            "SELECT * FROM skola ORDER BY godina DESC;",
            "SELECT * FROM skola WHERE pol = 'Z' EXCEPT SELECT * FROM skola WHERE godina = 2003;",
            "SELECT ime, prezime, adresa FROM skola WHERE prezime = 'Mikic' OR godina IN (2000, 2005) " +
                    "INTERSECT SELECT ime, prezime, adresa FROM skola WHERE pol = 'M' AND godina <> 2001;"
    };
    Query q = new Query();
    String[][] pitanjaTest = {
            {"1. Izdvoji sve kolone iz tabele customers",
                    "A. SELECT * FROM customers",
                    "B. SELECT columns FROM customers",
                    "C. SELECT all FROM customers",
                    "D. SELECT rows FROM customers"},

            {"2. Izdvoji samo kolone name i email iz tabele users",
                    "A. SELECT name, email FROM users",
                    "B. SELECT * FROM users WHERE name, email",
                    "C. SELECT columns name, email FROM users",
                    "D. SELECT users.name, users.email"},

            {"3. Iz tabele orders izdvoji samo one redove gde je status posiljke shipped",
                    "A. SELECT * FROM orders WHERE status = shipped",
                    "B. SELECT orders WHERE status = shipped",
                    "C. SELECT rows FROM orders WHERE status = shipped",
                    "D. SELECT columns FROM orders WHERE status = shipped"},

            {"4. Izdvoji zaposlene iz tabele employees koji imaju platu vecu od 50000",
                    "A. SELECT * FROM employees WHERE salary >= 50000",
                    "B. SELECT employees WHERE salary >= 50000",
                    "C. SELECT rows FROM employees WHERE salary >= 50000",
                    "D. SELECT columns FROM employees WHERE salary >= 50000"},

            {"5. Izdvoji sve redove iz tabele products i uredi ih opadajuce po ceni",
                    "A. SELECT * FROM products ORDER BY price DESC",
                    "B. SELECT products ORDER BY price DESC",
                    "C. SELECT rows FROM products ORDER BY price DESC",
                    "D. SELECT columns FROM products ORDER BY price DESC"},

            {"6. Uredi redove rastuce po koloni created_at",
                    "A. SELECT * FROM orders ORDER BY created_at ASC",
                    "B. SELECT orders ORDER BY created_at ASC",
                    "C. SELECT rows FROM orders ORDER BY created_at ASC",
                    "D. SELECT columns FROM orders ORDER BY created_at ASC"},

            {"7. Koja je svrha UNION operatora u SQL-u?",
                    "A. Spajanje rezultata dve ili više SELECT naredbi u jedinstveni skup podataka",
                    "B. Vraćanje samo jedinstvenih redova iz dve ili više SELECT naredbi",
                    "C. Vraćanje samo zajedničkih redova iz dve ili više SELECT naredbi",
                    "D. Isključivanje zajedničkih redova iz dve ili više SELECT naredbi"},

            {"8. Koja je svrha INTERSECT operatora u SQL-u?",
                    "A. Spajanje rezultata dve ili više SELECT naredbi u jedinstveni skup podataka",
                    "B. Vraćanje samo jedinstvenih redova iz dve ili više SELECT naredbi",
                    "C. Vraćanje samo zajedničkih redova iz dve ili više SELECT naredbi",
                    "D. Isključivanje zajedničkih redova iz dve ili više SELECT naredbi"},

            {"9. Koja je svrha EXCEPT operatora u SQL-u?",
                    "A. Spajanje rezultata dve ili više SELECT naredbi u jedinstveni skup podataka",
                    "B. Vraćanje samo jedinstvenih redova iz dve ili više SELECT naredbi",
                    "C. Vraćanje samo zajedničkih redova iz dve ili više SELECT naredbi",
                    "D. Isključivanje zajedničkih redova iz dve ili više SELECT naredbi"},

            {"10. Koja od sledećih je valjana upotreba UNION operatora u SQL-u?",
                    "A. Spajanje rezultata dve ili više SELECT naredbi sa različitim brojem kolona",
                    "B. Vraćanje samo jedinstvenih redova iz jedne SELECT naredbe",
                    "C. Vraćanje samo zajedničkih redova iz dve ili više SELECT naredbi",
                    "D. Isključivanje zajedničkih redova iz dve ili više SELECT naredbi"},

            {"11. Koja od sledećih je valjana upotreba INTERSECT operatora u SQL-u?",
                    "A. Spajanje rezultata dve ili više SELECT naredbi sa različitim brojem stupaca",
                    "B. Vraćanje samo jedinstvenih redova iz jedne SELECT naredbe",
                    "C. Vraćanje samo zajedničkih redova iz dve ili više SELECT naredbi",
                    "D. Isključivanje zajedničkih redova iz dve ili više SELECT naredbi"}
    };

    String[] odgovoriTest = {"1", "1", "1", "1", "1", "1", "1", "3", "4", "1", "3", "4"};
    int brojTacnihOdgovora = 0;
    int redniBrojPitanja = 0;

    Date timeStart = new Date();
    Date timeEnd = new Date();

    public static void rezultat(int brojTacnihOdgovora,Text taE,Stage stage,Scene poslednja){
        Integer brojPoena = 10*(brojTacnihOdgovora-1);
        taE.setText("Uspesno ste zavrsili sve lekcije\n" + "Osvoji li ste " + brojPoena + " poena.");
        stage.setScene(poslednja);
        stage.setTitle("Kraj");
        stage.show();
    }
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

        Image pozadinaSlika = new Image("img-01.png");
        BackgroundImage pozadina = new BackgroundImage(pozadinaSlika,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,false,false,false,false));
        Background b = new Background(pozadina);

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

        TextArea textAreaT = new TextArea("Osnovni upit se sastoji od naredbi SELECT i FROM\n" +
                "SELECT naredbom oznacavamo koje atribute zelimo da izdvojimo\n" +
                "FROM naredbom oznacavamo iz koje tabele zelimo da izdvojimo informacije\n" +
                "Ukoliko zelimo da izdvojimo sve atribute, mozemo iskoristiti operator *\n" +
                "\n" +
                "Hajde da izvrsimo nas prvi upit. Zelimo da izdvojimo sve atribute o svim ucenicima u nasoj skoli.\n" +
                "\n" +
                "Upit izgleda ovako: SELECT * FROM skola; \n Red je na tebe da probas! Klikni na dugme!");

        //prikazi sliku
        textAreaT.setWrapText(true);
        textAreaT.setEditable(false);
        textAreaT.setPrefWidth(200);
        textAreaT.setPrefHeight(100);
        TextArea textAreaV = new TextArea("Izdvoji sve atribute o svim ucenicima u skoli. \n\nKlikni na probaj kada si spreman da proveris svoje resenje.");
        textAreaV.setWrapText(true);
        textAreaV.setEditable(false);
        textAreaV.setPrefWidth(200);
        textAreaV.setPrefHeight(100);
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
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[0])){
                    System.out.println("NETACNO");
                    return;
                }

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
                textFieldV.setText("");
                //nivo1.setDisable(true);
                return;
            }
            //if(!nivo2.isDisabled()
            if (activated[1]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[1])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                //nivo2.setDisable(true);
                return;
            }
            //if(!nivo3.isDisabled()) {
            if (activated[2]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[2])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo4.isDisabled()) {
            if (activated[3]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[3])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo5.isDisabled()) {
            if (activated[4]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[4])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo6.isDisabled()) {
            if (activated[5]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[5])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo7.isDisabled()) {
            if (activated[6]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[6])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo8.isDisabled()) {
            if (activated[7]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[7])){
                    System.out.println("NETACNO");
                    return;
                }
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
                textFieldV.setText("");
                return;
            }
            //if(!nivo9.isDisabled()) {
            if (activated[8]) {
                String odgovor = textFieldV.getText();
                if(!q.compare(odgovor,odgovori[8])){
                    System.out.println("NETACNO");
                    return;
                }
                root3.getChildren().remove(1);
                nivo9.setStyle("-fx-background-color: #4CAF50;");
                dalje3.setDisable(false);
                activated[8] = false;
                textFieldV.setText("");
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
        taB.getTransforms().addAll(
                new Translate(115, 0)
        );
        Text taE = new Text();
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

        VBox rootTest = new VBox();

        RadioButton rb1 = new RadioButton(pitanjaTest[redniBrojPitanja][1]);
        RadioButton rb2 = new RadioButton(pitanjaTest[redniBrojPitanja][2]);
        RadioButton rb3 = new RadioButton(pitanjaTest[redniBrojPitanja][3]);
        RadioButton rb4 = new RadioButton(pitanjaTest[redniBrojPitanja][4]);

        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);

        Label lbl = new Label(pitanjaTest[redniBrojPitanja][0]);
        rootTest.getChildren().addAll(lbl,rb1,rb2,rb3,rb4);

        Scene pocetna = new Scene(rootB,WINDOW_WIDTH, WINDOW_HEIGHT);
        pocetna.getStylesheets().addAll("style.css");
        Scene scena1 = new Scene(root1,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena1.getStylesheets().addAll("style.css");
        Scene scena2 = new Scene(root2,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena2.getStylesheets().addAll("style.css");
        Scene scena3 = new Scene(root3,WINDOW_WIDTH, WINDOW_HEIGHT);
        scena3.getStylesheets().addAll("style.css");
        Scene scenaTest = new Scene(rootTest,WINDOW_WIDTH, WINDOW_HEIGHT);
        scenaTest.getStylesheets().addAll("style.css");
        Scene poslednja = new Scene(rootE,WINDOW_WIDTH, WINDOW_HEIGHT);
        poslednja.getStylesheets().addAll("style.css");

        scena1.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (activated[0]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[0])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Greska");
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();
                        return;
                    }

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

                    nivo1.setStyle("-fx-background-color: goldenrod;");
                    nivo2.setDisable(false);
                    activated[0] = false;
                    //nivo1.setDisable(true);
                    return;
                }
                //if(!nivo2.isDisabled()
                if (activated[1]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[1])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();
                        return;
                    }
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

                    nivo2.setStyle("-fx-background-color: goldenrod;");
                    nivo3.setDisable(false);
                    activated[1] = false;
                    //nivo2.setDisable(true);
                    return;
                }
                //if(!nivo3.isDisabled()) {
                if (activated[2]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[2])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo3.setStyle("-fx-background-color: goldenrod;");
                    nivo4.setDisable(false);
                    dalje1.setDisable(false);
                    activated[2] = false;
                    //nivo3.setDisable(true);
                    return;
                }
            }
        });

        scena2.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (activated[3]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[3])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo4.setStyle("-fx-background-color: goldenrod;");
                    nivo5.setDisable(false);
                    activated[3] = false;
                    //nivo4.setDisable(true);
                    return;
                }
                //if(!nivo5.isDisabled()) {
                if (activated[4]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[4])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo5.setStyle("-fx-background-color: goldenrod;");
                    nivo6.setDisable(false);
                    activated[4] = false;
                    //nivo5.setDisable(true);
                    return;
                }
                //if(!nivo6.isDisabled()) {
                if (activated[5]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[5])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo6.setStyle("-fx-background-color: goldenrod;");
                    nivo7.setDisable(false);
                    dalje2.setDisable(false);
                    activated[5] = false;
                    //nivo6.setDisable(true);
                    return;
                }
            }
        });

        scena3.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (activated[6]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[6])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo7.setStyle("-fx-background-color: goldenrod;");
                    nivo8.setDisable(false);
                    activated[6] = false;
                    //nivo7.setDisable(true);
                    return;
                }
                //if(!nivo8.isDisabled()) {
                if (activated[7]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[7])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
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

                    nivo8.setStyle("-fx-background-color: goldenrod;");
                    nivo9.setDisable(false);
                    activated[7] = false;
                    //nivo8.setDisable(true);
                    return;
                }
                //if(!nivo9.isDisabled()) {
                if (activated[8]) {
                    String odgovor = textFieldV.getText();
                    if(!q.compare(odgovor,odgovori[8])){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Greska");
                        alert.setHeaderText(null);
                        alert.setContentText("Probaj opet!");
                        alert.showAndWait();;
                        return;
                    }
                    root3.getChildren().remove(1);
                    nivo9.setStyle("-fx-background-color: goldenrod;");
                    dalje3.setDisable(false);
                    activated[8] = false;
                    //nivo9.setDisable(true);
                }
            }
        });

        rootB.setBackground(b);
        root1.setBackground(b);
        root2.setBackground(b);
        root3.setBackground(b);
        rootTest.setBackground(b);
        rootE.setBackground(b);

        stage.setScene(pocetna);
        stage.setTitle("Dobrodosli");
        stage.setResizable(false);
        stage.show();

        rb1.setOnAction(e -> {
            if(redniBrojPitanja == 11){
                rezultat(brojTacnihOdgovora,taE,stage,poslednja);
            }else {
                if (Objects.equals(odgovoriTest[redniBrojPitanja], "1")) {
                    brojTacnihOdgovora++;
                }

                lbl.setText(pitanjaTest[redniBrojPitanja][0]);
                rb1.setText(pitanjaTest[redniBrojPitanja][1]);
                rb2.setText(pitanjaTest[redniBrojPitanja][2]);
                rb3.setText(pitanjaTest[redniBrojPitanja][3]);
                rb4.setText(pitanjaTest[redniBrojPitanja][4]);
                rb1.setSelected(false);
                redniBrojPitanja++;
            }
        });

        rb2.setOnAction(e -> {
            if(redniBrojPitanja == 11){
                rezultat(brojTacnihOdgovora,taE,stage,poslednja);
            }else {
                if (Objects.equals(odgovoriTest[redniBrojPitanja], "2")) {
                    brojTacnihOdgovora++;
                }
                lbl.setText(pitanjaTest[redniBrojPitanja][0]);
                rb1.setText(pitanjaTest[redniBrojPitanja][1]);
                rb2.setText(pitanjaTest[redniBrojPitanja][2]);
                rb3.setText(pitanjaTest[redniBrojPitanja][3]);
                rb4.setText(pitanjaTest[redniBrojPitanja][4]);
                rb2.setSelected(false);
                redniBrojPitanja++;
            }
        });

        rb3.setOnAction(e -> {
            if(redniBrojPitanja == 11){
                rezultat(brojTacnihOdgovora,taE,stage,poslednja);
            }else {
                if (Objects.equals(odgovoriTest[redniBrojPitanja], "3")) {
                    brojTacnihOdgovora++;
                }
                lbl.setText(pitanjaTest[redniBrojPitanja][0]);
                rb1.setText(pitanjaTest[redniBrojPitanja][1]);
                rb2.setText(pitanjaTest[redniBrojPitanja][2]);
                rb3.setText(pitanjaTest[redniBrojPitanja][3]);
                rb4.setText(pitanjaTest[redniBrojPitanja][4]);
                rb3.setSelected(false);
                redniBrojPitanja++;
            }
        });

        rb4.setOnAction(e -> {
            if(redniBrojPitanja == 11){
                rezultat(brojTacnihOdgovora,taE,stage,poslednja);
            }else{
                if(Objects.equals(odgovoriTest[redniBrojPitanja], "4")){
                    brojTacnihOdgovora++;
                }
                lbl.setText(pitanjaTest[redniBrojPitanja][0]);
                rb1.setText(pitanjaTest[redniBrojPitanja][1]);
                rb2.setText(pitanjaTest[redniBrojPitanja][2]);
                rb3.setText(pitanjaTest[redniBrojPitanja][3]);
                rb4.setText(pitanjaTest[redniBrojPitanja][4]);
                rb4.setSelected(false);
                redniBrojPitanja++;
            }
        });

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
            stage.setScene(scenaTest);
            stage.setTitle("Kviz");
            stage.show();
        });

    }

    public static void main(String[] args) {
        launch();
    }
}

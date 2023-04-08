package com.example.hakaton;

public class Dete {

    private String ime, prezime, ulica;
    private Integer god_rodjenja, broj_telefona, skola_fk;


    public Dete(String ime, String prezime, String ulica, Integer god_rodjenja, Integer broj_telefona, Integer skola_fk) {
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.god_rodjenja = god_rodjenja;
        this.broj_telefona = broj_telefona;
        this.skola_fk = skola_fk;
    }


    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getUlica() {
        return ulica;
    }

    public Integer getGod_rodjenja() {
        return god_rodjenja;
    }

    public Integer getBroj_telefona() {
        return broj_telefona;
    }

    public Integer getSkola_fk() {
        return skola_fk;
    }
}

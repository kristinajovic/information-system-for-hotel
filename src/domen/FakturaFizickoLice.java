/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;


public class FakturaFizickoLice {
    
    int brojRacuna;
    String mestoIzdavanja;
    int ukupno;
    String korisniciNocenja;
    Zaposleni zaposleni;
    KupacFizickoLice kupacFizickoLice;
    String nacinPlacanja;
    public FakturaFizickoLice() {
        
    }

    public FakturaFizickoLice(int brojRacuna, String mestoIzdavanja, int ukupno, String korisniciNocenja, Zaposleni zaposleni, KupacFizickoLice kupacFizickoLice, String nacinPlacanja) {
        this.brojRacuna = brojRacuna;
        this.mestoIzdavanja = mestoIzdavanja;
        this.ukupno = ukupno;
        this.korisniciNocenja = korisniciNocenja;
        this.zaposleni = zaposleni;
        this.kupacFizickoLice = kupacFizickoLice;
        this.nacinPlacanja = nacinPlacanja;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public int getUkupno() {
        return ukupno;
    }

    public void setUkupno(int ukupno) {
        this.ukupno = ukupno;
    }

    public String getKorisniciNocenja() {
        return korisniciNocenja;
    }

    public void setKorisniciNocenja(String korisniciNocenja) {
        this.korisniciNocenja = korisniciNocenja;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public KupacFizickoLice getKupacFizickoLice() {
        return kupacFizickoLice;
    }

    public void setKupacFizickoLice(KupacFizickoLice kupacFizickoLice) {
        this.kupacFizickoLice = kupacFizickoLice;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    @Override
    public String toString() {
        return brojRacuna+"";
    }

   
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

public class Rezervacija {
    int brojRezervacije;
    Date datumOd;
    Date datumDo;
    String nacinRezervisanja;
    String napomena;
    String tipPansiona;
    String nazivGosta;
    Zaposleni zaposleni;
    Gost gost;

   
    

    public Rezervacija() {
    }

      public Rezervacija(int brojRezervacije, Date datumOd, Date datumDo, String nacinRezervisanja, String napomena, String tipPansiona, Zaposleni zaposleni, Gost gost) {
        this.brojRezervacije = brojRezervacije;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.nacinRezervisanja = nacinRezervisanja;
        this.napomena = napomena;
        this.tipPansiona = tipPansiona;
     //   this.nazivGosta = nazivGosta;
        this.zaposleni = zaposleni;
        this.gost = gost;
      
    }
    
    
    public Rezervacija(int brojRezervacije, Date datumOd, Date datumDo, String nacinRezervisanja, String napomena, String tipPansiona, String nazivGosta, Zaposleni zaposleni, Gost gost) {
        this.brojRezervacije = brojRezervacije;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.nacinRezervisanja = nacinRezervisanja;
        this.napomena = napomena;
        this.tipPansiona = tipPansiona;
        this.nazivGosta = nazivGosta;
        this.zaposleni = zaposleni;
        this.gost = gost;
      
    }
    
    

    public int getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getNacinRezervisanja() {
        return nacinRezervisanja;
    }

    public void setNacinRezervisanja(String nacinRezervisanja) {
        this.nacinRezervisanja = nacinRezervisanja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getTipPansiona() {
        return tipPansiona;
    }

    public void setTipPansiona(String tipPansiona) {
        this.tipPansiona = tipPansiona;
    }

    public String getNazivGosta() {
        return nazivGosta;
    }

    public void setNazivGosta(String nazivGosta) {
        this.nazivGosta = nazivGosta;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

   
     @Override
    public String toString() {
        return brojRezervacije+"";
    }
    
}

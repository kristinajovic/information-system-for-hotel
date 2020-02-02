/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

public class Gost {
    int gostID;
    String imePrezime;
    String nazivGosta;
    String kontakt;
    Zaposleni zaposleni;

    
    
      public Gost() {
        
    }
    
    public Gost(int gostID, String imePrezime, String nazivGosta, String kontakt, Zaposleni zaposleni) {
        this.gostID = gostID;
        this.imePrezime = imePrezime;
        this.nazivGosta = nazivGosta;
        this.kontakt = kontakt;
        this.zaposleni = zaposleni;
    }

    
  
    
    public int getGostID() {
        return gostID;
    }

    public void setGostID(int gostID) {
        this.gostID = gostID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getNazivGosta() {
        return nazivGosta;
    }

    public void setNazivGosta(String nazivGosta) {
        this.nazivGosta = nazivGosta;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
       
    @Override
        public String toString() {
            return imePrezime;
        }
    
            
    
}

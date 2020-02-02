/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

public class Zaposleni {
    int zaposleniID;
    String ime;

    String prezime;
    
    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String ime,String prezime) {
        this.zaposleniID = zaposleniID;
        this.ime = ime;
        this.prezime=prezime;
    }

    
    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }


     public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    
}

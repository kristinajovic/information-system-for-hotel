/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;


public class KupacFizickoLice {
    
    int kupacFizId;
    String ime;
    String prezime;
    
    public KupacFizickoLice () {
        
    }

    public KupacFizickoLice(int kupacFizId, String ime, String prezime) {
        this.kupacFizId = kupacFizId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getKupacFizId() {
        return kupacFizId;
    }

    public void setKupacFizId(int kupacFizId) {
        this.kupacFizId = kupacFizId;
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

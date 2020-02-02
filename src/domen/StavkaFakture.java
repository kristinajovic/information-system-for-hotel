/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

public class StavkaFakture {
    
    int rbrStavke;
    FakturaFizickoLice faktura;
    int kolicina;
    JedinicaMere jedinicaMere;
    Usluga usluga;
    
    public StavkaFakture() {
        
    }

    public StavkaFakture(int rbrStavke, FakturaFizickoLice faktura, int kolicina, JedinicaMere jedinicaMere, Usluga usluga) {
        this.rbrStavke = rbrStavke;
        this.faktura = faktura;
        this.kolicina = kolicina;
        this.jedinicaMere = jedinicaMere;
        this.usluga = usluga;
    }

    public int getRbrStavke() {
        return rbrStavke;
    }

    public void setRbrStavke(int rbrStavke) {
        this.rbrStavke = rbrStavke;
    }

    public FakturaFizickoLice getFaktura() {
        return faktura;
    }

    public void setFaktura(FakturaFizickoLice faktura) {
        this.faktura = faktura;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

   
    
    
}

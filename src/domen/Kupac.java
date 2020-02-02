/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;


public class Kupac {
    int kupacID;
    String naziv;
    Pib pib;

    public Kupac() {
    }

    public Kupac(int kupacID, String naziv,Pib pib) {
        this.kupacID = kupacID;
        this.naziv = naziv;
       
        this.pib = pib;
    }

   

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

  
    public Pib getPib() {
        return pib;
    }

    public void setPib(Pib pib) {
        this.pib= pib;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
   
    
}

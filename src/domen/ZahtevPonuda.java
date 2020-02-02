/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

public class ZahtevPonuda {
    
    int zahtevID;
    String nazivZahteva;
    Restoran r;
    
    public ZahtevPonuda() {
        
    }

    public ZahtevPonuda(int zahtevID, String nazivZahteva, Restoran r) {
        this.zahtevID = zahtevID;
        this.nazivZahteva = nazivZahteva;
        this.r = r;
    }

    public int getZahtevID() {
        return zahtevID;
    }

    public void setZahtevID(int zahtevID) {
        this.zahtevID = zahtevID;
    }

    public String getNazivZahteva() {
        return nazivZahteva;
    }

    public void setNazivZahteva(String nazivZahteva) {
        this.nazivZahteva = nazivZahteva;
    }

    public Restoran getR() {
        return r;
    }

    public void setR(Restoran r) {
        this.r = r;
    }
    
}

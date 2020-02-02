/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;


public class RezervisaneSobe {
    Rezervacija rezervacija;
    int sobaID;
    int brojOdraslih;
    int brojDece;
    int iznos;
    String Napomena;
    int brojSobe;

    public RezervisaneSobe() {
        
    }
    public RezervisaneSobe(Rezervacija rezervacija, int sobaID, int brojOdraslih, int brojDece, int iznos, String Napomena, int brojSobe) {
        this.rezervacija = rezervacija;
        this.sobaID = sobaID;
        this.brojOdraslih = brojOdraslih;
        this.brojDece = brojDece;
        this.iznos = iznos;
        this.Napomena = Napomena;
        this.brojSobe = brojSobe;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public int getSobaID() {
        return sobaID;
    }

    public void setSobaID(int sobaID) {
        this.sobaID = sobaID;
    }

    public int getBrojOdraslih() {
        return brojOdraslih;
    }

    public void setBrojOdraslih(int brojOdraslih) {
        this.brojOdraslih = brojOdraslih;
    }

    public int getBrojDece() {
        return brojDece;
    }

    public void setBrojDece(int brojDece) {
        this.brojDece = brojDece;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getNapomena() {
        return Napomena;
    }

    public void setNapomena(String Napomena) {
        this.Napomena = Napomena;
    }

    public int getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(int brojSobe) {
        this.brojSobe = brojSobe;
    }
    
    
    
    
    
}

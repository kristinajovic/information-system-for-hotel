/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;


public class Restoran {
    int restoranID;
    String nazivRestorana;
    
    public Restoran() {
        
    }

    public Restoran(int restoranID, String nazivRestorana) {
        this.restoranID = restoranID;
        this.nazivRestorana = nazivRestorana;
    }

    public int getRestoranID() {
        return restoranID;
    }

    public void setRestoranID(int restoranID) {
        this.restoranID = restoranID;
    }

    public String getNazivRestorana() {
        return nazivRestorana;
    }

    public void setNazivRestorana(String nazivRestorana) {
        this.nazivRestorana = nazivRestorana;
    }
    
    
}

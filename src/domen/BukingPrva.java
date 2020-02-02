/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

/**
 *
 * @author admin
 */
public class BukingPrva {
    int agencijaID;
    String nazivAgencije;
    
    public BukingPrva() {
        
    }

    public BukingPrva(int agencijaID, String nazivAgencije) {
        this.agencijaID = agencijaID;
        this.nazivAgencije = nazivAgencije;
    }

    public int getAgencijaID() {
        return agencijaID;
    }

    public void setAgencijaID(int agencijaID) {
        this.agencijaID = agencijaID;
    }

    public String getNazivAgencije() {
        return nazivAgencije;
    }

    public void setNazivAgencije(String nazivAgencije) {
        this.nazivAgencije = nazivAgencije;
    }
    
}

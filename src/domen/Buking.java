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
public class Buking {
    
    int agencijaID;
    String nazivAgencije;
    String kontaktTel;
    String email;
    String adresa;
    
    public Buking() {
        
    }

    public Buking(int agencijaID, String nazivAgencije, String kontaktTel, String email, String adresa) {
        this.agencijaID = agencijaID;
        this.nazivAgencije = nazivAgencije;
        this.kontaktTel = kontaktTel;
        this.email = email;
        this.adresa = adresa;
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

    public String getKontaktTel() {
        return kontaktTel;
    }

    public void setKontaktTel(String kontaktTel) {
        this.kontaktTel = kontaktTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
    
}

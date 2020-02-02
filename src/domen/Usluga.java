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
public class Usluga {
    
    int uslugaId;
    String nazivUsluge;
    String opisUsluge;
    int cena;
    public Usluga() {
        
    }

    public Usluga(int uslugaId, String nazivUsluge, String opisUsluge, int cena) {
        this.uslugaId = uslugaId;
        this.nazivUsluge = nazivUsluge;
        this.opisUsluge = opisUsluge;
        this.cena = cena;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(int uslugaId) {
        this.uslugaId = uslugaId;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public String getOpisUsluge() {
        return opisUsluge;
    }

    public void setOpisUsluge(String opisUsluge) {
        this.opisUsluge = opisUsluge;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return nazivUsluge;
    }
    
    
    
}

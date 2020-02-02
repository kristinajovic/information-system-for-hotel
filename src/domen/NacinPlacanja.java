/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

public class NacinPlacanja {
    int nacinPlacanjaID;
    String nazivNacinaPlacanja;

    public NacinPlacanja() {
    }

    public NacinPlacanja(int nacinPlacanjaID, String nazivNacinaPlacanja) {
        this.nacinPlacanjaID = nacinPlacanjaID;
        this.nazivNacinaPlacanja = nazivNacinaPlacanja;
    }

    public int getNacinPlacanjaID() {
        return nacinPlacanjaID;
    }

    public void setNacinPlacanjaID(int nacinPlacanjaID) {
        this.nacinPlacanjaID = nacinPlacanjaID;
    }

    public String getNazivNacinaPlacanja() {
        return nazivNacinaPlacanja;
    }

    public void setNazivNacinaPlacanja(String nazivNacinaPlacanja) {
        this.nazivNacinaPlacanja = nazivNacinaPlacanja;
    }

    @Override
    public String toString() {
        return nazivNacinaPlacanja;
    }
    
    
}

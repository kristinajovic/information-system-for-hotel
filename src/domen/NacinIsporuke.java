/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;


public class NacinIsporuke {
    int nacinIsporukeID;
    String nazivNacinaIsporuke;

    public NacinIsporuke() {
    }

    public NacinIsporuke(int nacinIsporukeID, String nazivNacinaIsporuke) {
        this.nacinIsporukeID = nacinIsporukeID;
        this.nazivNacinaIsporuke = nazivNacinaIsporuke;
    }

    public int getNacinIsporukeID() {
        return nacinIsporukeID;
    }

    public void setNacinIsporukeID(int nacinIsporukeID) {
        this.nacinIsporukeID = nacinIsporukeID;
    }

    public String getNazivNacinaIsporuke() {
        return nazivNacinaIsporuke;
    }

    public void setNazivNacinaIsporuke(String nazivNacinaIsporuke) {
        this.nazivNacinaIsporuke = nazivNacinaIsporuke;
    }

    @Override
    public String toString() {
        return nazivNacinaIsporuke;
    }
    
    
    
}

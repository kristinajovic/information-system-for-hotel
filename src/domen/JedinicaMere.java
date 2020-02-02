/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

public class JedinicaMere {
    int jmId;
    String nazivJM;

    Opis_JM opis_JM;

    
    public JedinicaMere() {
        
    }

    public JedinicaMere(int jmId, String nazivJM, Opis_JM opis_JM) {
        this.jmId = jmId;
        this.nazivJM = nazivJM;
        this.opis_JM = opis_JM;
    }
    
    
    public int getJmId() {
        return jmId;
    }

    public void setJmId(int jmId) {
        this.jmId = jmId;
    }

    public String getNazivJM() {
        return nazivJM;
    }

    public void setNazivJM(String nazivJM) {
        this.nazivJM = nazivJM;
    }

    public Opis_JM getOpis_JM() {
        return opis_JM;
    }

    public void setOpis_JM(Opis_JM opis_JM) {
        this.opis_JM = opis_JM;
    }
    
    
    
    
}

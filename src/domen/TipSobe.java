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
public class TipSobe {
    
    int tipSobeID;
    String nazivSobe;
    int redniBroj;
    
    public TipSobe() {
        
    }

    public TipSobe(int tipSobeID, String nazivSobe, int redniBroj) {
        this.tipSobeID = tipSobeID;
        this.nazivSobe = nazivSobe;
        this.redniBroj = redniBroj;
    }

    public int getTipSobeID() {
        return tipSobeID;
    }

    public void setTipSobeID(int tipSobeID) {
        this.tipSobeID = tipSobeID;
    }

    public String getNazivSobe() {
        return nazivSobe;
    }

    public void setNazivSobe(String nazivSobe) {
        this.nazivSobe = nazivSobe;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }
    
    
}

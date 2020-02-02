/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;


public class PonudaRest {
    
    int ponudaID;
    String nazivPonude;
    ZahtevPonuda z;
    Restoran r;

    public PonudaRest() {
    }

    public PonudaRest(int ponudaID, String nazivPonude, ZahtevPonuda z,Restoran r) {
        this.ponudaID = ponudaID;
        this.nazivPonude = nazivPonude;
        this.z = z;
        this.r=r;
    }

    public int getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(int ponudaID) {
        this.ponudaID = ponudaID;
    }

    public String getNazivPonude() {
        return nazivPonude;
    }

    public void setNazivPonude(String nazivPonude) {
        this.nazivPonude = nazivPonude;
    }

    public ZahtevPonuda getZ() {
        return z;
    }

    public void setZ(ZahtevPonuda z) {
        this.z = z;
    }

    public Restoran getR() {
        return r;
    }

    public void setR(Restoran r) {
        this.r = r;
    }
    
    
}

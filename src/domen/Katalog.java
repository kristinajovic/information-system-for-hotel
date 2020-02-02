/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;


public class Katalog {
    int brojKataloga;
    Date datumOd;
    Date datumDo;

    public Katalog() {
    }

    public Katalog(int brojKataloga, Date datumOd, Date datumDo) {
        this.brojKataloga = brojKataloga;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public int getBrojKataloga() {
        return brojKataloga;
    }

    public void setBrojKataloga(int brojKataloga) {
        this.brojKataloga = brojKataloga;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }
    
    
    
}

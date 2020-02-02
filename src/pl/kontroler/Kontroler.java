/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kontroler;

import db.DBKonekcija;
import domen.Buking;
import domen.BukingDruga;
import domen.BukingPrva;
import domen.FakturaFizickoLice;
import domen.Gost;
import domen.JedinicaMere;
import domen.Kupac;
import domen.Rezervacija;
import domen.PonudaRest;
import domen.RezervisaneSobe;
import domen.StavkaFakture;
import domen.TipSobe;
import domen.ZahtevPonuda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Kontroler {

    private static Kontroler instanca;
    private DBKonekcija db;
    private int aktivanSK;
    private Map<String, Object> mapa;

    public static Kontroler vratiInstancuKontrolera() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Kontroler() {
        db = new DBKonekcija();
        mapa = new HashMap<>();
    }

    public Map<String, Object> getMapa() {
        return mapa;
    } 
    
    

    public List<Rezervacija> vratiListuRezervacija() {
        return db.vratiListuRez();
    }

    public List<Kupac> vratiListuKupaca() {
      return  db.vratiListuKupaca();
    }



    public void sacuvajRezervaciju(Rezervacija n) throws Exception {
         db.sacuvajRezervaciju(n);
    }

    public void obrisiRezervaciju(Rezervacija n) throws Exception {
        db.obrisiRezervaciju(n);
                
    }

    public void izmeniKupca(Kupac k) throws Exception {
       db.izmeniKupca(k);
    }

    

    public void dodajKupca(Kupac k) throws Exception {
        db.sacuvajKupca(k);
    }

    public void obrisiKupca(Kupac k) throws Exception {
       db.obrisiKupca(k);
        
    }

    public void izmeniRezervaciju(Rezervacija n) throws Exception{
        db.izmeniRez(n);
        
    }

    public void izmeniRezervaciju2(Rezervacija n) throws Exception {
  db.izmeniRez2(n);
       
    }

    public List<Gost> vratiListuGostiju() {
       return db.vratiListuGostiju();
    }

    public void obrisiGosta(Gost k) throws Exception {
    db.obrisiGosta(k);
    }

    public void izmeniGosta(Gost k) throws Exception {
        db.izmeniGosta(k);
    }

    public void dodajGosta(Gost k) throws Exception {
        db.dodajGosta(k);
    }

    public void dodajRezervisanuSobu(RezervisaneSobe k) throws Exception {
        db.dodajRezSobu(k);
    }

    public List<RezervisaneSobe> vratiListuRezSobe() {
         return  db.vratiListuRezSobe();
        
    }

    public void obrisiRezSobu(RezervisaneSobe k) throws Exception {
        db.obrisiRezSO(k);
    }

    public void izmeniRezervisanuSobu(RezervisaneSobe re) throws Exception {
        db.izmeniRezSobu(re);
    }

    public void izmeniRezervisanuSobu2(RezervisaneSobe re) throws Exception {
                db.izmeniRezSobu2(re);

    }

    public List<ZahtevPonuda> vratiListuZahteva() {
        return db.vratiListuZahteva();
    }

    public void obrisiZahtev(ZahtevPonuda n) throws Exception {
        db.obrisiZahtev(n);
    }

    public void izmeniZahtev(ZahtevPonuda k) throws Exception {
        db.izmeniZahtev(k);
    }

    public void dodajZahtev(ZahtevPonuda k) throws Exception {

        db.dodajZahtev(k);
    }

    public void dodajPonuduRest(PonudaRest p) throws Exception {
        db.dodajPonudu(p);
    }

    public List<PonudaRest> vratiListuPonuda() {
        return db.vratiListuPonuda();
}

    public void obrisiPonudu(PonudaRest m) throws Exception {
        db.obrisiPonudu(m);
    }

    public void izmeniPonudu(PonudaRest r) throws Exception {
        db.izmeniPonudu(r);
    }

    public void izmeniPonudu2(PonudaRest r) throws Exception {
                db.izmeniPonudu2(r);

    }

    public void dodajJM(JedinicaMere k) throws Exception {
    db.dodajJM(k);
    }

    public List<FakturaFizickoLice> vartiListuFaktura() {
        return db.vratiListuFaktura();
    }

    public void izmeniFakturu(FakturaFizickoLice ff) throws Exception {
        db.izmeniFakturu(ff);
    }

    public void izmeniFakturu2(FakturaFizickoLice ff) throws Exception {
        db.izmeniFakturu2(ff);
    }

    public void obrisiFakturu(FakturaFizickoLice k) throws Exception {
        db.obrisiFakturu(k);
    }

    public void dodajFakturu(FakturaFizickoLice ff) throws Exception {
        db.dodajFakturu(ff);

    }

    public void dodajStavkuFakture(StavkaFakture k) throws Exception {
        db.dodajStavkuFakture(k);
    }

    public List<StavkaFakture> vratiListuStavki() {
        return db.vratiListuStavkiFakture();
    }

    public void izmeniStavkuFakture(StavkaFakture k) throws Exception {
        db.izmeniStavkuFakture(k);
    }

    public void obrisiStavkuFakture(StavkaFakture k) throws Exception {
        db.obrisiStavku(k);
    }

    public void izmeniRezervaciju3(Rezervacija n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dodajBuking(Buking k) throws Exception {
          db.dodajBuking(k);
    }

    public List<BukingPrva> vratiListuPrva() {
       return  db.vratiListuBukinga();
    }

    public List<BukingDruga> vratiListuDruga() {
         return  db.vratiListuDruga();
        
    }

    public void obrisiPrvuBuk(BukingPrva m) throws Exception {
        db.obrisiBukPrvu(m);
    }

    public void izmeniBukingPrva(BukingPrva k) throws Exception {
        db.izmeniBukingPrvu(k);
    }

    public void obrisiDruguBuk(BukingDruga m) throws Exception {
        db.obrisiDruguBuk(m);
    }

    public void izmeniBukingDruga(BukingDruga k) throws Exception {
    db.izmeniBukingDrugu(k);
    }

    public List<TipSobe> vratiListuPrviTip() {
            return  db.vratiListuPrviTip();
    }

    public List<TipSobe> vratiListuDrugiTip() {
        
          return  db.vratiListuDrugiTip();
    }

    public void obrisiPrviTip(TipSobe m) throws Exception {
         db.obrisiPrviTip(m);
    }

    public void obrisiDrugiTip(TipSobe m) throws Exception {
           db.obrisiDrugiTip(m);
    }

    public void dodajTipSobe(TipSobe k) throws Exception {
          db.dodajTipSobe(k);
    }

    public void izmeniTipSobe(TipSobe k) throws Exception {
        db.izmmeniTipSobePrvi(k);
    }

    public void izmeniTipSobeDva(TipSobe k) throws Exception {
                db.izmmeniTipSobeDrugi(k);
    }

    public List<Buking> vratiBukinge() {
      return  db.vratiListuBukingView();
    }

    public void izmeniBukingView(Buking k) throws Exception {
         db.izmeniBukingView(k);
    }

    public void obrisiBukingView(Buking m) throws Exception {
        db.obrisiListuBukinga(m);
    }
    
    

 
}

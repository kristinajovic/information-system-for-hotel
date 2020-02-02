/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.FakturaFizickoLice;
import domen.Kupac;
import domen.StavkaFakture;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelStavki extends AbstractTableModel {

    List<StavkaFakture> listaStavki;

    public TblModelStavki(List<StavkaFakture> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaStavki == null) {
            return 0;
        }
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaFakture k = listaStavki.get(rowIndex);

        switch (columnIndex) {
            case 0:
               return k.getRbrStavke();

            case 1:
               return k.getFaktura().getBrojRacuna();

            case 2:
                return k.getKolicina();
             case 3:
                return k.getJedinicaMere().getNazivJM();
           case 4:
                return k.getUsluga().getNazivUsluge();
        
             default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Redni broj stavke";

            case 1:
                return "Broj racuna";

            case 2:
                return "Kolicina";
           case 3:
                return "Jedinica mere";
            case 4:
                return "Usluga";
            
            default:
                return "";
        }

    }
    
    public void dodaj(StavkaFakture k) {
        listaStavki.add(k);
        fireTableDataChanged();
    }

    public List<StavkaFakture> vratiListuStavki() {
        return listaStavki;
    }

    public void obrisiRed(int red) {
        listaStavki.remove(red);
        fireTableDataChanged();
    }

    public StavkaFakture vratiStavkuFakture(int red) {
        return listaStavki.get(red);
    }

    
}

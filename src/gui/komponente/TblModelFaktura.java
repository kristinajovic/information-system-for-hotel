/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.FakturaFizickoLice;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelFaktura extends AbstractTableModel {

    List<FakturaFizickoLice> listaFaktura;

    public TblModelFaktura(List<FakturaFizickoLice> listaFaktura) {
        this.listaFaktura = listaFaktura;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaFaktura == null) {
            return 0;
        }
        return listaFaktura.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FakturaFizickoLice k = listaFaktura.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getBrojRacuna();
            case 1:
                return k.getMestoIzdavanja();
            case 2:
                return k.getUkupno();
             case 3:
                return k.getKorisniciNocenja();
           case 4:
                return k.getZaposleni().toString();
            case 5:
                return k.getKupacFizickoLice().toString();
                  case 6:
                return k.getNacinPlacanja();
             default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Broj racuna";
            case 1:
                return "Mesto izdavanja";
            case 2:
                return "Ukupno";
           case 3:
                return "Korisnici nocenja";
            case 4:
                return "Zaposleni";
            case 5:
                return "Kupac";
                     case 6:
                return "Nacin placanja";
            default:
                return "";
        }

    }
    
    public void dodaj(FakturaFizickoLice k) {
        listaFaktura.add(k);
        fireTableDataChanged();
    }

    public List<FakturaFizickoLice> vratiListuFaktura() {
        return listaFaktura;
    }

    public void obrisiRed(int red) {
        listaFaktura.remove(red);
        fireTableDataChanged();
    }

    public FakturaFizickoLice vratiFakturu(int red) {
        return listaFaktura.get(red);
    }

    
}

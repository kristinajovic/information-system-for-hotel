/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.ZahtevPonuda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TblModelZahtev extends AbstractTableModel {

    List<ZahtevPonuda> listaZahteva;

    public TblModelZahtev(List<ZahtevPonuda> listaZahteva) {
        this.listaZahteva = listaZahteva;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaZahteva == null) {
            return 0;
        }
        return listaZahteva.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZahtevPonuda k = listaZahteva.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getZahtevID();
            case 1:
                return k.getNazivZahteva();
            case 2:
                return k.getR().getRestoranID();
                
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Zahtev ID";
            case 1:
                return "Naziv zahteva";
            case 2:
                return "Restoran ID";
            
            default:
                return "";
        }

    }
    
    public void dodaj(ZahtevPonuda k) {
       listaZahteva.add(k);
        fireTableDataChanged();
    }

    public List<ZahtevPonuda> vratiListuZahteva() {
        return listaZahteva;
    }

    public void obrisiRed(int red) {
        listaZahteva.remove(red);
        fireTableDataChanged();
    }

    public ZahtevPonuda vratiZahtev(int red) {
        return listaZahteva.get(red);
    }

    
}

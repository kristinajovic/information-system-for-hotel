/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Gost;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelGost extends AbstractTableModel {

    List<Gost> listaGostiju;

    public TblModelGost(List<Gost> listaGostiju) {
        this.listaGostiju = listaGostiju;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaGostiju == null) {
            return 0;
        }
        return listaGostiju.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gost k = listaGostiju.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getGostID();
            case 1:
                return k.getImePrezime();
            case 2:
                return k.getNazivGosta();
                 case 3:
                return k.getKontakt();
            case 4:
                return k.getZaposleni().getZaposleniID();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Gost ID";
            case 1:
                return "Ime i prezime";
            case 2:
                return "Naziv gosta";
             case 3:
                return "Kontakt";
              case 4:
                return "Zaposleni ID";
            default:
                return "";
        }

    }
    
    public void dodaj(Gost k) {
       listaGostiju.add(k);
        fireTableDataChanged();
    }

    public List<Gost> vratiListuGostiju() {
        return listaGostiju;
    }

    public void obrisiRed(int red) {
        listaGostiju.remove(red);
        fireTableDataChanged();
    }

    public Gost vratiGosta(int red) {
        return listaGostiju.get(red);
    }

    
}

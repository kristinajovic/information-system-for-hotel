/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Buking;
import domen.BukingDruga;
import domen.BukingPrva;
import domen.Gost;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelDruga extends AbstractTableModel {

    List<BukingDruga> listaBukinga;

    public TblModelDruga(List<BukingDruga> listaBukinga) {
        this.listaBukinga = listaBukinga;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaBukinga == null) {
            return 0;
        }
        return listaBukinga.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BukingDruga k = listaBukinga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getAgencijaID();
            case 1:
                return k.getKontaktTel();
                  case 2:
                return k.getEmail();
                  case 3:
                return k.getAdresa();
            
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Agencija ID";
            case 1:
                return "Kontakt telefon";
            case 2:
                return "Email";
                 case 3:
                return "Adresa";
            default:
                return "";
        }

    }
    
    public void dodaj(BukingDruga k) {
       listaBukinga.add(k);
        fireTableDataChanged();
    }

    public List<BukingDruga> vratiListuBukinga() {
        return listaBukinga;
    }

    public void obrisiRed(int red) {
        listaBukinga.remove(red);
        fireTableDataChanged();
    }

    public BukingDruga vratiDrugu(int red) {
        return listaBukinga.get(red);
    }

    
}

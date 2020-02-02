/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Buking;
import domen.BukingPrva;
import domen.Gost;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelPrva extends AbstractTableModel {

    List<BukingPrva> listaBukinga;

    public TblModelPrva(List<BukingPrva> listaBukinga) {
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BukingPrva k = listaBukinga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getAgencijaID();
            case 1:
                return k.getNazivAgencije();
            
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
                return "Naziv agencije";
           
            default:
                return "";
        }

    }
    
    public void dodaj(BukingPrva k) {
       listaBukinga.add(k);
        fireTableDataChanged();
    }

    public List<BukingPrva> vratiListuGostiju() {
        return listaBukinga;
    }

    public void obrisiRed(int red) {
        listaBukinga.remove(red);
        fireTableDataChanged();
    }

    public BukingPrva vratiPrvu(int red) {
        return listaBukinga.get(red);
    }

    
}

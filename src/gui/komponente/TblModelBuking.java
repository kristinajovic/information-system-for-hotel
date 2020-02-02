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


public class TblModelBuking extends AbstractTableModel {

    List<Buking> listaBukinga;

    public TblModelBuking(List<Buking> listaBukinga) {
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buking k = listaBukinga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getAgencijaID();
            case 1:
                return k.getNazivAgencije();
               case 2:
                return k.getKontaktTel();
                case 3:
                return k.getEmail();
                case 4:
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
                return "Naziv agencije";
               case 2:
                return "Kontakt tel";
              case 3:
                return "Email";
               case 4:
                return "Adresa";
            
            default:
                return "";
        }

    }
    
    public void dodaj(Buking k) {
       listaBukinga.add(k);
        fireTableDataChanged();
    }

    public List<Buking> vratiListuGostiju() {
        return listaBukinga;
    }

    public void obrisiRed(int red) {
        listaBukinga.remove(red);
        fireTableDataChanged();
    }

    public Buking vratiPrvu(int red) {
        return listaBukinga.get(red);
    }

    
}

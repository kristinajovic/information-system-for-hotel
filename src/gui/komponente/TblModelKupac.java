/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Kupac;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelKupac extends AbstractTableModel {

    List<Kupac> listaKupaca;

    public TblModelKupac(List<Kupac> listaKupaca) {
        this.listaKupaca = listaKupaca;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaKupaca == null) {
            return 0;
        }
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k = listaKupaca.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKupacID();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getPib();
          //  case 3:
             //   return k.getMesto().getNazivMesta();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kupac ID";
            case 1:
                return "Naziv";
            case 2:
                return "Pib";
           
            default:
                return "";
        }

    }
    
    public void dodaj(Kupac k) {
        listaKupaca.add(k);
        fireTableDataChanged();
    }

    public List<Kupac> vratiListuKupaca() {
        return listaKupaca;
    }

    public void obrisiRed(int red) {
        listaKupaca.remove(red);
        fireTableDataChanged();
    }

    public Kupac vratiKupca(int red) {
        return listaKupaca.get(red);
    }

    
}

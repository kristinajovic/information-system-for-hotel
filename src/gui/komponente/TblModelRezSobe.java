/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.RezervisaneSobe;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TblModelRezSobe extends AbstractTableModel {

    List<RezervisaneSobe> listaRezSoba;

    public TblModelRezSobe(List<RezervisaneSobe> listaRezSoba) {
        this.listaRezSoba = listaRezSoba;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaRezSoba == null) {
            return 0;
        }
        return listaRezSoba.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezervisaneSobe k = listaRezSoba.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getRezervacija().getBrojRezervacije();
            case 1:
                return k.getSobaID();
            case 2:
                return k.getBrojOdraslih();
                 case 3:
                return k.getBrojDece();
                  case 4:
                return k.getIznos();
                 case 5:
                return k.getNapomena();
                  case 6:
                return k.getBrojSobe();
                          
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
                return "Broj rezervacije";
            case 1:
                return "Soba ID";
            case 2:
                return "Broj odraslih";
             case 3:
                return "Broj dece";
            case 4:
                return "Iznos";
              case 5:
                return "Napomena";
                   case 6:
                return "Broj sobe";
            default:
                return "";
        }

    }
    
    public void dodaj(RezervisaneSobe k) {
        listaRezSoba.add(k);
        fireTableDataChanged();
    }

    public List<RezervisaneSobe> vratiListuKupaca() {
        return listaRezSoba;
    }

    public void obrisiRed(int red) {
        listaRezSoba.remove(red);
        fireTableDataChanged();
    }

    public RezervisaneSobe vratiKupca(int red) {
        return listaRezSoba.get(red);
    }

    
}

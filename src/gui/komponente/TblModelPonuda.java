/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.PonudaRest;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelPonuda extends AbstractTableModel {

    List<PonudaRest> listaPonuda;

    public TblModelPonuda(List<PonudaRest> listaPonuda) {
        this.listaPonuda = listaPonuda;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaPonuda == null) {
            return 0;
        }
        return listaPonuda.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PonudaRest k = listaPonuda.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getPonudaID();
            case 1:
                return k.getNazivPonude();
            case 2:
                return k.getZ().getZahtevID();
             case 3:
                return k.getR().getRestoranID();
           
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ponuda ID";
            case 1:
                return "Naziv ponude";
            case 2:
                return "Zahtev ID";
             case 3:
                return "Restoran ID";
              
            default:
                return "";
        }

    }
    
    public void dodaj(PonudaRest k) {
       listaPonuda.add(k);
        fireTableDataChanged();
    }

    public List<PonudaRest> vratiListuPonuda() {
        return listaPonuda;
    }

    public void obrisiRed(int red) {
        listaPonuda.remove(red);
        fireTableDataChanged();
    }

    public PonudaRest vratiPonudu(int red) {
        return listaPonuda.get(red);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Buking;
import domen.BukingPrva;
import domen.Gost;
import domen.TipSobe;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelDrugiTip extends AbstractTableModel {

    List<TipSobe> listaTipova;

    public TblModelDrugiTip(List<TipSobe> listaTipova) {
        this.listaTipova = listaTipova;
    }
    
    
    @Override
    public int getRowCount() {
         if (listaTipova == null) {
            return 0;
        }
        return listaTipova.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipSobe k = listaTipova.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getTipSobeID();
            case 1:
                return k.getNazivSobe();
            case 2:
                return k.getRedniBroj(); 
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Tip sobe ID";
            case 1:
                return "Naziv sobe";
             case 2:
                return "Redni broj"; 
            default:
                return "";
        }

    }
    
    public void dodaj(TipSobe k) {
       listaTipova.add(k);
        fireTableDataChanged();
    }

    public List<TipSobe> vratiListuTipova() {
        return listaTipova;
    }

    public void obrisiRed(int red) {
        listaTipova.remove(red);
        fireTableDataChanged();
    }

    public TipSobe vratiPrvu(int red) {
        return listaTipova.get(red);
    }

    
}

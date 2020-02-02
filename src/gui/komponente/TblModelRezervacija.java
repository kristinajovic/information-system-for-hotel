/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TblModelRezervacija extends AbstractTableModel {
    
    List<Rezervacija> rezervacija;

    public TblModelRezervacija(List<Rezervacija> narudzbenice) {
        this.rezervacija = narudzbenice;
    }
   

    @Override
    public int getRowCount() {
         if (rezervacija == null) {
            return 0;
        }
      //  return rezervacija.size();
         
       return rezervacija.size();
    }
    

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija n = rezervacija.get(rowIndex);
         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        switch (columnIndex) {
            case 0:
                return n.getBrojRezervacije();
            case 1:
               
                return sdf.format(n.getDatumOd());
            case 2:
                
                return sdf.format(n.getDatumDo());
            case 3:
                return n.getNacinRezervisanja();
                
            case 4: 
                return n.getNapomena();
            case 5:
                return n.getTipPansiona();
            case 6:
                return n.getNazivGosta();
            
            case 7:
                return n.getZaposleni().toString();
           
              case 8:
                return n.getGost().toString();
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
                return "DatumOD";
            case 2:
                return "DatumDO";
            case 3:
                return "NacinRezervisanja";
            case 4:
                return "Napomena";
            case 5:
                return "Tip pansiona";
            
            case 6:
                return "Naziv gosta";
            case 7:
                return "Zaposleni";
             case 8:
                return "Gost";
            default:
                return "";
        }
    }
    
    
    public void dodaj(Rezervacija n) {
        rezervacija.add(n);
        fireTableDataChanged();
    }

    public List<Rezervacija> vratiListuRezervacija() {
        return rezervacija;
    }

    public void obrisiRed(int red) {
        rezervacija.remove(red);
        fireTableDataChanged();
    }
    
     public Rezervacija vratiRezervaciju(int red) {
        return rezervacija.get(red);
    }
}

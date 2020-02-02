/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.Buking;
import domen.BukingDruga;
import domen.BukingPrva;
import domen.FakturaFizickoLice;
import domen.Gost;
import domen.JedinicaMere;
import domen.Kupac;
import domen.KupacFizickoLice;
import domen.Pib;
import domen.PonudaRest;
import domen.Restoran;
import domen.Rezervacija;
import domen.RezervisaneSobe;
import domen.StavkaFakture;
import domen.TipSobe;
import domen.Usluga;
import domen.ZahtevPonuda;
import domen.Zaposleni;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Util;


public class DBKonekcija {

  

    public List<Rezervacija> vratiListuRez() {
         List<Rezervacija> listaRez = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from rezervacija re join zaposleni ra on re.zaposleniid=ra.zaposleniid join gost ka on re.gostid=ka.gostid ";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                int brojR = rs.getInt("brojRezervacije");
              //  java.util.Date datumOd = new java.util.Date(rs.getDate("datumOD").getTime());
                // java.util.Date datumDo = new java.util.Date(rs.getDate("datumDO").getTime());
                java.sql.Date datumOd=new java.sql.Date(rs.getDate("datumOD").getTime());
                 java.sql.Date datumDo = new java.sql.Date(rs.getDate("datumDO").getTime());
                 String nacinRezervisanja = rs.getString("nacinRezervisanja");    
                 String napomena = rs.getString("napomena");    
                 String tipPansiona = rs.getString("tipPansiona");    
                  String nazivGosta = rs.getString("nazivGosta");    

                  
                  
                  
                 int zaposleniID = rs.getInt("zaposleniID");
                String ime = rs.getString("ime");
                String prezime=rs.getString("prezime");
               Zaposleni zapp = new Zaposleni(zaposleniID, ime,prezime);
                  
                  
                 int gostID= rs.getInt("gostID");
                 String imePrezG=rs.getString("imePrezime");
                  String nazivG=rs.getString("nazivGosta");
                  String kontakt=rs.getString("kontakt");
                
             
                Gost kup = new Gost(gostID, imePrezG, nazivG, kontakt, null);
                
       
               
              
        
                Rezervacija nar = new Rezervacija(brojR, datumOd,datumDo, nacinRezervisanja, napomena, tipPansiona, nazivGosta, zapp, kup);
                     

               
                listaRez.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRez;
    }

    public List<Kupac> vratiListuKupaca() {
         List<Kupac> listaKupaca = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from kupacpravnolice";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
             java.util.Map map = connection.getTypeMap();
            map.put("SYSTEM.PIB", Pib.class);
            connection.setTypeMap(map);

            while (rs.next()) {

               
                int kupacid = rs.getInt("kupacid");
               String naziv = rs.getString("naziv");
             //  String brojTelefona = rs.getString("brojtelefona");
               Pib pib = (Pib) rs.getObject("pib");
               
               Kupac kupac = new Kupac(kupacid, naziv, pib);
               listaKupaca.add(kupac);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaKupaca;
    }

   

    


    public void sacuvajRezervaciju(Rezervacija n) throws Exception {
        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO rezervacija VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
              ps.setInt(1,n.getBrojRezervacije());

            ps.setDate(2, new Date(n.getDatumOd().getTime()));
            ps.setDate(3,new Date(n.getDatumDo().getTime()));
              ps.setString(4, n.getNacinRezervisanja());
              ps.setString(5, n.getNapomena());
              ps.setString(6, n.getTipPansiona());
              ps.setString(7, n.getNazivGosta());
 
            ps.setInt(8, n.getZaposleni().getZaposleniID());
            ps.setInt(9, n.getGost().getGostID());
       
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void obrisiRezervaciju(Rezervacija n) throws Exception {
        List<Rezervacija> listaRezervacija = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from rezervacija where brojrezervacije = " + n.getBrojRezervacije();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void izmeniKupca(Kupac k) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE kupacpravnolice SET naziv=? WHERE kupacid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


           
         //   ps.setString(2, k.getBrojTelefona());
            ps.setString(1, k.getNaziv());
            ps.setInt(2, k.getKupacID());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
             
    }

   

    public void sacuvajKupca(Kupac k) throws Exception {
           try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO kupacpravnolice VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getKupacID());
            ps.setString(2, k.getNaziv());
            
           //  ps.setObject(3,k.getPib());

         //   ps.setInt(3, k.getPib());
              
            ps.setObject(3, k.getPib());
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void obrisiKupca(Kupac k) throws Exception {
          List<Kupac> listaKupaca = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from kupacpravnolice where kupacid= " + k.getKupacID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
        
    }

    public void izmeniRez(Rezervacija n)  throws Exception{
        
          try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE rezervacija SET nacinrezervisanja=?,napomena=?,tippansiona=?,gostid=? WHERE brojrezervacije=?";
            PreparedStatement ps = connection.prepareStatement(upit);


           
         //  ps.setDate(1, (Date) new java.util.Date(n.getDatumOd().toString()));
           // ps.setDate(2, (Date) new java.util.Date(n.getDatumDo().toString()));

            ps.setString(1, n.getNacinRezervisanja());
             ps.setString(2, n.getNapomena());
             ps.setString(3, n.getTipPansiona());
            
            ps.setInt(4, n.getGost().getGostID());
            ps.setInt(5, n.getBrojRezervacije());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
        
        
    }

    public void izmeniRez2(Rezervacija n) throws Exception {

          try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE rezervacija SET nacinrezervisanja=?,napomena=?,tippansiona=?,nazivgosta=?, gostid=? WHERE brojrezervacije=?";
            PreparedStatement ps = connection.prepareStatement(upit);


           
         //  ps.setDate(1, (Date) new java.util.Date(n.getDatumOd().toString()));
           // ps.setDate(2, (Date) new java.util.Date(n.getDatumDo().toString()));

            ps.setString(1, n.getNacinRezervisanja());
             ps.setString(2, n.getNapomena());
             ps.setString(3, n.getTipPansiona());
            ps.setString(4, n.getNazivGosta());
            
            ps.setInt(5, n.getGost().getGostID());
            ps.setInt(6, n.getBrojRezervacije());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            //System.out.println(ex.getMessage());
            
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
            }

   /* public void obrisiRezervaciju(Rezervacija n) throws Exception {
         List<Rezervacija> listaRezervacijas = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from rezervacija where brojRezervacije= " + n.getBrojRezervacije();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
         //   System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
        
    }
    */

    public List<Gost> vratiListuGostiju() {
        
            List<Gost> listaGostiju = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from gost";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                int gostId = rs.getInt("gostid");
                String imPr = rs.getString("imeprezime");
                String naz = rs.getString("nazivgosta");

                String kontakt = rs.getString("kontakt");
                Zaposleni z=new Zaposleni();
                int zap=rs.getInt("zaposleniid");
             z.setZaposleniID(zap);
                
               
               Gost gg = new Gost(gostId,imPr, naz,kontakt, z);
               listaGostiju.add(gg);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaGostiju;
        
    }

    public void obrisiGosta(Gost k) throws Exception {
         List<Gost> listaGostiju = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from gost where gostId= " + k.getGostID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void izmeniGosta(Gost k) throws Exception {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE gost SET imeprezime=?,nazivgosta=?,kontakt=?,zaposleniid=? WHERE gostid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


           
         //   ps.setString(2, k.getBrojTelefona());
            ps.setString(1, k.getImePrezime());
            ps.setString(2, k.getNazivGosta());
             ps.setString(3, k.getKontakt());

             ps.setInt(4, k.getZaposleni().getZaposleniID());
             ps.setInt(5, k.getGostID());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
             
        
    }

    public void dodajGosta(Gost k) throws Exception {
        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO gost VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getGostID());
             ps.setString(2, k.getImePrezime());

            ps.setString(3, k.getNazivGosta());
            
           //  ps.setObject(3,k.getPib());

         //   ps.setInt(3, k.getPib());
              
            ps.setString(4, k.getKontakt());
            ps.setInt(5, k.getZaposleni().getZaposleniID());
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
        
    }

    public void dodajRezSobu(RezervisaneSobe k) throws Exception {
         try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO rezervisanesobe VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getRezervacija().getBrojRezervacije());
              ps.setInt(2,k.getSobaID());
              ps.setInt(3,k.getBrojOdraslih());
              ps.setInt(4,k.getBrojDece());
              ps.setInt(5, k.getIznos());
              ps.setString(6,k.getNapomena());
              ps.setInt(7, k.getBrojSobe());

        
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public List<RezervisaneSobe> vratiListuRezSobe() {
            List<RezervisaneSobe> listaRezSob = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from rezervisanesobe";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                int rez = rs.getInt("brojrezervacije");
                 int sobId = rs.getInt("sobaid");
                int brO = rs.getInt("brojodraslih");
                int brD = rs.getInt("brojdece");
                int iznos = rs.getInt("iznos");
                String nap = rs.getString("napomena");
                int brS = rs.getInt("brojsobe");

                
               Rezervacija r=new Rezervacija();
               
             r.setBrojRezervacije(rez);
                
               
               RezervisaneSobe gg = new RezervisaneSobe(r,sobId, brO,brD, iznos,nap,brS);
               listaRezSob.add(gg);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRezSob;
        
    }

    public void obrisiRezSO(RezervisaneSobe k) throws Exception {
    List<Gost> listaGostiju = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from rezervisanesobe where sobaid= " + k.getSobaID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }

    public void izmeniRezSobu(RezervisaneSobe re) throws Exception {
          try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE rezervisanesobe SET brojodraslih=?,brojdece=?,iznos=?,brojsobe=? WHERE sobaid=? AND brojrezervacije=?";
            PreparedStatement ps = connection.prepareStatement(upit);

             ps.setInt(1,re.getBrojOdraslih());
             ps.setInt(2,re.getBrojDece());
             ps.setInt(3,re.getIznos());
           //  ps.setString(4,re.getNapomena());
             ps.setInt(4,re.getBrojSobe());
             ps.setInt(5,re.getSobaID());
             ps.setInt(6,re.getRezervacija().getBrojRezervacije());

           
        
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
         //   System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
        
    }

    public void izmeniRezSobu2(RezervisaneSobe re) throws Exception {
  try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE rezervisanesobe SET brojodraslih=?,brojdece=?,iznos=?,napomena=?,brojsobe=? WHERE sobaid=? AND brojrezervacije=?";
            PreparedStatement ps = connection.prepareStatement(upit);

             ps.setInt(1,re.getBrojOdraslih());
             ps.setInt(2,re.getBrojDece());
             ps.setInt(3,re.getIznos());
            ps.setString(4,re.getNapomena());
             ps.setInt(5,re.getBrojSobe());
             ps.setInt(6,re.getSobaID());
             ps.setInt(7,re.getRezervacija().getBrojRezervacije());
           
        
            ps.executeUpdate();
            ps.close();
            connection.close();

         } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }    }


    public List<ZahtevPonuda> vratiListuZahteva() {
         List<ZahtevPonuda> listaZahteva = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from zahtevponuda";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                  int rez = rs.getInt("zahtevid");
                  String nap = rs.getString("nazivzahteva");

                  int sobId = rs.getInt("restoranid");
               

                
                 Restoran r=new Restoran();
               
                 r.setRestoranID(sobId);
                
               
               ZahtevPonuda gg = new ZahtevPonuda(rez,nap, r);
               listaZahteva.add(gg);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaZahteva;

    }

    public void obrisiZahtev(ZahtevPonuda n) throws Exception {
        List<ZahtevPonuda> listaZahteva = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from zahtevponuda where zahtevid = " + n.getZahtevID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }

    public void izmeniZahtev(ZahtevPonuda k) throws Exception {
 try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE zahtevponuda SET nazivzahteva=?,restoranid=? WHERE zahtevid=?";
            PreparedStatement ps = connection.prepareStatement(upit);

           
            ps.setString(1,k.getNazivZahteva());
            ps.setInt(2,k.getR().getRestoranID());

            ps.setInt(3,k.getZahtevID());


           
        
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
         //   System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }    }

    public void dodajZahtev() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dodajZahtev(ZahtevPonuda k) throws Exception {

          try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO zahtevponuda VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
              ps.setInt(1,k.getZahtevID());
              ps.setString(2,k.getNazivZahteva());
              ps.setInt(3, k.getR().getRestoranID());
              

        
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
           // System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void dodajPonudu(PonudaRest p) throws Exception {
        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO ponudarest VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
              ps.setInt(1,p.getPonudaID());
              ps.setString(2,p.getNazivPonude());
              ps.setInt(3, p.getZ().getZahtevID());

              ps.setInt(4, p.getR().getRestoranID());
              

        
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
           // System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }

    }

    public List<PonudaRest> vratiListuPonuda() {
         List<PonudaRest> listaPonuda = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from ponudarest";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                  int rez = rs.getInt("ponudaid");
                  String nap = rs.getString("nazivponude");
                  int zah = rs.getInt("zahtevid");

                  int sobId = rs.getInt("restoranid");
               

                
                 Restoran r=new Restoran();
               
                 r.setRestoranID(sobId);
                ZahtevPonuda zaht=new ZahtevPonuda();
                zaht.setZahtevID(zah);
               
               PonudaRest gg = new PonudaRest(rez,nap,zaht,r);
               listaPonuda.add(gg);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPonuda;

    }

    public void obrisiPonudu(PonudaRest m) throws Exception {
         List<PonudaRest> listaPonuda = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from ponudarest where ponudaid = " + m.getPonudaID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void izmeniPonudu(PonudaRest r) throws Exception {

         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE ponudarest SET nazivponude=?, zahtevid=? WHERE ponudaid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


        

            ps.setString(1, r.getNazivPonude());
            ps.setInt(2, r.getZ().getZahtevID());

          
            ps.setInt(3, r.getPonudaID());
            
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
        
    
    }

    public void izmeniPonudu2(PonudaRest r) throws Exception {
    try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE ponudarest SET nazivponude=?, zahtevid=?, restoranid=? WHERE ponudaid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


        

            ps.setString(1, r.getNazivPonude());
            ps.setInt(2, r.getZ().getZahtevID());
            ps.setInt(3, r.getR().getRestoranID());

          
            ps.setInt(4, r.getPonudaID());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
            }

    public void dodajJM(JedinicaMere k) throws Exception {
         try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO jedinicamere VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getJmId());
            ps.setString(2, k.getNazivJM());
            
           //  ps.setObject(3,k.getPib());

         //   ps.setInt(3, k.getPib());
              
            ps.setObject(3, k.getOpis_JM());
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
        
    }

    public List<FakturaFizickoLice> vratiListuFaktura() {
           List<FakturaFizickoLice> listaFaktura = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from fakturafizickolice f join zaposleni z on f.zaposleniid=z.zaposleniid join kupacfizickolice k on f.kupacfizid=k.kupacfizid";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                int brracuna = rs.getInt("brojracuna");
                 String naziv = rs.getString("mestoizdavanja");

                int ukupno = rs.getInt("ukupno");
                String kor = rs.getString("korisnicinocenja");
                int zaposleniID = rs.getInt("zaposleniID");
                String ime = rs.getString("ime");
                String prezime=rs.getString("prezime");
               Zaposleni zapp = new Zaposleni(zaposleniID, ime,prezime);

            int kupid=rs.getInt("kupacfizid");
            String ime2 = rs.getString("imek");
                String prezime2=rs.getString("prezimek");
               
                KupacFizickoLice kupac = new KupacFizickoLice(kupid, ime2, prezime2);
                
               String nac=rs.getString("nacinplacanja");

                
                FakturaFizickoLice ff=new FakturaFizickoLice(brracuna,naziv,ukupno,kor,zapp,kupac,nac);
                
               listaFaktura.add(ff);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFaktura;
    }

    public void izmeniFakturu(FakturaFizickoLice ff) throws Exception {
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE fakturafizickolice SET mestoizdavanja=?, korisnicinocenja=?, zaposleniid=?,kupacfizid=?, nacinplacanja=? WHERE brojracuna=?";
            PreparedStatement ps = connection.prepareStatement(upit);

            
              ps.setString(1, ff.getMestoIzdavanja());
              ps.setString(2, ff.getKorisniciNocenja());


            ps.setInt(3, ff.getZaposleni().getZaposleniID());
            ps.setInt(4, ff.getKupacFizickoLice().getKupacFizId());
            ps.setString(5, ff.getNacinPlacanja());
            ps.setInt(6, ff.getBrojRacuna());


           
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }
        
    }

    public void izmeniFakturu2(FakturaFizickoLice ff) throws Exception {
try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE fakturafizickolice SET mestoizdavanja=?, ukupno=?, korisnicinocenja=?, zaposleniid=?,kupacfizid=?, nacinplacanja=? WHERE brojracuna=?";
            PreparedStatement ps = connection.prepareStatement(upit);

            
              ps.setString(1, ff.getMestoIzdavanja());
             ps.setInt(2, ff.getUkupno());

              ps.setString(3, ff.getKorisniciNocenja());


            ps.setInt(4, ff.getZaposleni().getZaposleniID());
            ps.setInt(5, ff.getKupacFizickoLice().getKupacFizId());
            ps.setString(6, ff.getNacinPlacanja());
            ps.setInt(7, ff.getBrojRacuna());


           
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
           // System.out.println(ex.getMessage());
            throw new Exception(ex);
        } catch (SQLException sqlEx) {
          //  System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx);
        }    }

    public void obrisiFakturu(FakturaFizickoLice k) throws Exception {
          List<FakturaFizickoLice> listaFaktura = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from fakturafizickolice where brojracuna = " + k.getBrojRacuna();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void dodajFakturu(FakturaFizickoLice ff) throws Exception {
        
        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO fakturafizickolice VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
           
            
               ps.setInt(1, ff.getBrojRacuna());

              ps.setString(2, ff.getMestoIzdavanja());
             ps.setInt(3, ff.getUkupno());

              ps.setString(4, ff.getKorisniciNocenja());


            ps.setInt(5, ff.getZaposleni().getZaposleniID());
            ps.setInt(6, ff.getKupacFizickoLice().getKupacFizId());
            ps.setString(7, ff.getNacinPlacanja());

            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }

    }

    public void dodajStavkuFakture(StavkaFakture k) throws Exception {
        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO stavkafakture VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
              ps.setInt(1,k.getRbrStavke());

            ps.setInt(2,k.getFaktura().getBrojRacuna());

             ps.setInt(3,k.getKolicina());

             ps.setInt(4,k.getJedinicaMere().getJmId());

              ps.setInt(5,k.getUsluga().getUslugaId());

         
       
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public List<StavkaFakture> vratiListuStavkiFakture() {
         List<StavkaFakture> listaStavki = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "select * from stavkafakture f join jedinicamere z on f.jmid=z.jmid join usluga k on f.uslugaid=k.uslugaid";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            

            while (rs.next()) {

               
                
                 int rbr = rs.getInt("rbrstavke");
                 
                 FakturaFizickoLice f=new FakturaFizickoLice();
                 int brracuna = rs.getInt("brojracuna");

                 f.setBrojRacuna(brracuna);
                int kol = rs.getInt("kolicina");
                
                
                int jmid = rs.getInt("jmid");
                String nn = rs.getString("nazivjm");
                
               JedinicaMere jm = new JedinicaMere();
               jm.setJmId(jmid);
               jm.setNazivJM(nn);

                Usluga u=new Usluga();
                
            int uid=rs.getInt("uslugaid");
            String nazz = rs.getString("nazivusluge");
            
            u.setUslugaId(uid);
            u.setNazivUsluge(nazz);
            
            
                StavkaFakture sf = new StavkaFakture(rbr, f,kol,jm,u );
              
                
               listaStavki.add(sf);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStavki;
        
    }

    public void izmeniStavkuFakture(StavkaFakture k) throws Exception {

           try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE stavkafakture set kolicina=?,jmid=?,uslugaid=? WHERE rbrstavke=? AND brojracuna=?";
            PreparedStatement ps = connection.prepareStatement(upit);


             ps.setInt(1,k.getKolicina());

             ps.setInt(2,k.getJedinicaMere().getJmId());

              ps.setInt(3,k.getUsluga().getUslugaId());

           ps.setInt(4,k.getRbrStavke());
            ps.setInt(5,k.getFaktura().getBrojRacuna());

            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void obrisiStavku(StavkaFakture k) throws Exception {
          List<StavkaFakture> listaStavki = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from stavkafakture where brojracuna = " + k.getFaktura().getBrojRacuna()+"AND rbrstavke="+k.getRbrStavke();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }

    }

    public void dodajBuking(Buking k) throws Exception {
         try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO buking_view VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getAgencijaID());
            ps.setString(2, k.getNazivAgencije());
            ps.setString(3, k.getKontaktTel());
            ps.setString(4, k.getEmail());
            ps.setString(5, k.getAdresa());
           
            
         
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    
    }

    public List<BukingPrva> vratiListuBukinga() {
          List<BukingPrva> listaBuk = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from bukingprva";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                int brojR = rs.getInt("agencijaid");
             
                  String naz = rs.getString("nazivagencije");    
     
                BukingPrva nar = new BukingPrva(brojR, naz);
                     

               
                listaBuk.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBuk;
    }

    public List<BukingDruga> vratiListuDruga() {
 List<BukingDruga> listaBuk = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from bukingdruga";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                int brojR = rs.getInt("agencijaid");
             
                  String naz = rs.getString("kontakttel");    
                  String email = rs.getString("email");    
                  String adr = rs.getString("adresa");    

                BukingDruga nar = new BukingDruga(brojR, naz,email,adr);
                     

               
                listaBuk.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBuk;
    
    }

    public void obrisiBukPrvu(BukingPrva m) throws Exception {

           List<BukingPrva> listaBukAg = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from bukingprva where agencijaid = " + m.getAgencijaID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void izmeniBukingPrvu(BukingPrva k) throws Exception {
 try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE bukingprva set nazivagencije=? WHERE agencijaid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


            ps.setString(1, k.getNazivAgencije());
             ps.setInt(2,k.getAgencijaID());

           

            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void obrisiDruguBuk(BukingDruga m) throws Exception {

              List<BukingDruga> listaDruga = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from bukingdruga where agencijaid = " + m.getAgencijaID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void izmeniBukingDrugu(BukingDruga k) throws Exception {
 try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE bukingdruga set kontakttel=?, email=?,adresa=? WHERE agencijaid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


            ps.setString(1, k.getKontaktTel());
             ps.setString(2, k.getEmail());
             ps.setString(3, k.getAdresa());


             ps.setInt(4,k.getAgencijaID());

           

            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }

    public List<TipSobe> vratiListuPrviTip() {
        List<TipSobe> listaBuk = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from tipprvi";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                int brojR = rs.getInt("tipsobeid");
             
                  String naz = rs.getString("nazivsobe");    
                    
                   int rbr = rs.getInt("rednibroj");

                TipSobe nar = new TipSobe(brojR, naz,rbr);
                     

               
                listaBuk.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBuk;    }

    public List<TipSobe> vratiListuDrugiTip() {
 List<TipSobe> listaBuk = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from tipdrugi";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                int brojR = rs.getInt("tipsobeid");
             
                  String naz = rs.getString("nazivsobe");    
                    
                   int rbr = rs.getInt("rednibroj");

                TipSobe nar = new TipSobe(brojR, naz,rbr);
                     

               
                listaBuk.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBuk;     }

    public void obrisiPrviTip(TipSobe m) throws Exception {
        
              List<TipSobe> listaDruga = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from tipprvi where tipsobeid = " + m.getTipSobeID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }
    }

    public void obrisiDrugiTip(TipSobe m) throws Exception {

              List<TipSobe> listaDruga = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from tipdrugi where tipsobeid = " + m.getTipSobeID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }

    public void dodajTipSobe(TipSobe k) throws Exception {
       try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "INSERT INTO tipsobe_view VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,k.getTipSobeID());
            ps.setString(2, k.getNazivSobe());
           
           ps.setInt(3,k.getRedniBroj());

            
         
            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }

    public void izmmeniTipSobePrvi(TipSobe k) throws Exception {
try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE tipprvi set nazivsobe=?, rednibroj=? WHERE tipsobeid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


            ps.setString(1, k.getNazivSobe());
              ps.setInt(2,k.getRedniBroj());


             ps.setInt(3,k.getTipSobeID());

           

            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }      }

    public void izmmeniTipSobeDrugi(TipSobe k) throws Exception {
try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "UPDATE tipdrugi set nazivsobe=?, rednibroj=? WHERE tipsobeid=?";
            PreparedStatement ps = connection.prepareStatement(upit);


            ps.setString(1, k.getNazivSobe());
              ps.setInt(2,k.getRedniBroj());


             ps.setInt(3,k.getTipSobeID());

           

            
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }     }

    public List<Buking> vratiListuBukingView() {
          List<Buking> listaBuk = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

   
            String upit = "select * from buking_view";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {

                 int brojR = rs.getInt("agencijaid");
                  String naziv = rs.getString("nazivagencije");    
                  String naz = rs.getString("kontakttel");    
                  String email = rs.getString("email");    
                  String adr = rs.getString("adresa");    

                Buking nar = new Buking(brojR,naziv, naz,email,adr);
                     

               
                listaBuk.add(nar);

            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaBuk;    }

    public void izmeniBukingView(Buking k) throws Exception {
       try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

          //  String upit = "UPDATE buking_view set nazivagencije=?, kontakttel=?, email=?,adresa=? WHERE agencijaid=?";
            
            //String upit = "UPDATE buking_view set nazivagencije=? WHERE agencijaid=?";
            
            String upit = "UPDATE buking_view set nazivagencije=?, kontakttel=?, email=?, adresa=? WHERE agencijaid=?";
            
           PreparedStatement ps = connection.prepareStatement(upit);

            ps.setString(1, k.getNazivAgencije());
            ps.setString(2, k.getKontaktTel());
             ps.setString(3, k.getEmail());
             ps.setString(4, k.getAdresa());

             ps.setInt(5,k.getAgencijaID());
    
            ps.executeUpdate();
            System.out.println("Upit je izvrsen");
            ps.close();
            connection.close();

        } catch (SQLException sqlEx) {
           System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        } 
    }

    public void obrisiListuBukinga(Buking m) throws Exception {

              List<Buking> listaDruga = new ArrayList<>();

        try {
            String url = Util.url;
            String password = Util.password;
            String username = Util.username;
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija je uspostavljena");

            String upit = "delete from buking_view where agencijaid = " + m.getAgencijaID();
            Statement s = connection.createStatement();
            s.executeUpdate(upit);

            s.close();
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println("Konekcija nije uspostavljena " + sqlEx.getMessage());
            throw new Exception(sqlEx.getMessage());
        }    }
}
       
   


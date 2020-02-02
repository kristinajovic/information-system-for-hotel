/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.StavkaFakture;
import gui.komponente.TblModelStavki;
import java.util.List;
import javax.swing.JOptionPane;
import pl.kontroler.Kontroler;


public class FmStavke extends javax.swing.JFrame {

    /**
     * Creates new form FmKupac
     */
    public FmStavke() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblStavke = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();
        obrisiKupcaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblStavke);

        jbtnDetalji.setText("Detalji ");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        obrisiKupcaBtn.setText("Obrisi ");
        obrisiKupcaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisiKupcaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(obrisiKupcaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDetalji)
                    .addComponent(obrisiKupcaBtn))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        int red = jtblStavke.getSelectedRow();
        TblModelStavki model = (TblModelStavki) jtblStavke.getModel();
        StavkaFakture k = model.vratiStavkuFakture(red);
        Kontroler.vratiInstancuKontrolera().getMapa().put("stavka_izabran", k);
       FmIzmenaStavkeFak fki= new FmIzmenaStavkeFak(null, false, this);
       fki.setVisible(true);
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void obrisiKupcaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisiKupcaBtnActionPerformed
           int red = jtblStavke.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Nista odabrali red!!!");
        } else {
            try {
                TblModelStavki model = (TblModelStavki) jtblStavke.getModel();
                StavkaFakture k = (StavkaFakture) model.vratiStavkuFakture(red);
                Kontroler.vratiInstancuKontrolera().obrisiStavkuFakture(k);
                List<StavkaFakture> lm = Kontroler.vratiInstancuKontrolera().vratiListuStavki();

                jtblStavke.setModel(new TblModelStavki(lm));

                JOptionPane.showMessageDialog(this, "Stavka je obrisana!!!");
                model.obrisiRed(red);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Stavka nije obrisana!!! " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_obrisiKupcaBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FmStavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmStavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmStavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmStavke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmStavke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JTable jtblStavke;
    private javax.swing.JButton obrisiKupcaBtn;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
         List<StavkaFakture> lk = Kontroler.vratiInstancuKontrolera().vratiListuStavki();
        jtblStavke.setModel(new TblModelStavki(lk));
    }

   

    void osvezi() {
        srediFormu();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme;

import domen.TipSobe;
import gui.komponente.TblModelDruga;
import gui.komponente.TblModelDrugiTip;
import gui.komponente.TblModelPrviTip;
import java.util.List;
import javax.swing.JOptionPane;
import pl.kontroler.Kontroler;

/**
 *
 * @author admin
 */
public class FmPrikazTipaSobe extends javax.swing.JFrame {

    /**
     * Creates new form FmPrikazTipaSobe
     */
    public FmPrikazTipaSobe() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jtblDrugi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblPrvi = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtblDrugi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtblDrugi);

        jtblPrvi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jtblPrvi);

        jButton4.setText("Obrisi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Izmeni");
        jButton5.setActionCommand("Obrisi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Obrisi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Izmeni");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(363, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 int red = jtblDrugi.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Nista odabrali red!!!");
        } else {
            try {
                TblModelDrugiTip model = (TblModelDrugiTip) jtblDrugi.getModel();
                TipSobe m = (TipSobe) model.vratiPrvu(red);
                Kontroler.vratiInstancuKontrolera().obrisiDrugiTip(m);
                List<TipSobe> lm = Kontroler.vratiInstancuKontrolera().vratiListuDrugiTip();

                jtblDrugi.setModel(new TblModelDrugiTip(lm));

                JOptionPane.showMessageDialog(this, "Tip sobe je obrisan!!!");
                model.obrisiRed(red);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Tip sobe nije obrisan!!! " + ex.getMessage());
                
                ex.getMessage();
                ex.printStackTrace();
            }    }  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int red = jtblPrvi.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Nista odabrali red!!!");
        } else {
            try {
                TblModelPrviTip model = (TblModelPrviTip) jtblPrvi.getModel();
                TipSobe m = (TipSobe) model.vratiPrvu(red);
                Kontroler.vratiInstancuKontrolera().obrisiPrviTip(m);
                List<TipSobe> lm = Kontroler.vratiInstancuKontrolera().vratiListuPrviTip();

                jtblPrvi.setModel(new TblModelPrviTip(lm));

                JOptionPane.showMessageDialog(this, "Tip sobe je obrisan!!!");
                model.obrisiRed(red);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Tip sobe nije obrisan!!! " + ex.getMessage());
                
                ex.getMessage();
                ex.printStackTrace();
            }    }//GEN-LAST:event_jButton4ActionPerformed
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 int red = jtblPrvi.getSelectedRow();
        TblModelPrviTip model = (TblModelPrviTip) jtblPrvi.getModel();
        TipSobe k = model.vratiPrvu(red);
        Kontroler.vratiInstancuKontrolera().getMapa().put("tipprvi_izabran", k);
        FmIzmenaTipaSobe fki= new FmIzmenaTipaSobe(null, false, this);
        fki.setVisible(true);  


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int red = jtblDrugi.getSelectedRow();
        TblModelDrugiTip model = (TblModelDrugiTip) jtblDrugi.getModel();
        TipSobe k = model.vratiPrvu(red);
        Kontroler.vratiInstancuKontrolera().getMapa().put("tipdrugi_izabran", k);
        FmIzmenaTipaSobeDva fki= new FmIzmenaTipaSobeDva(null, false, this);
        fki.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    
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
            java.util.logging.Logger.getLogger(FmPrikazTipaSobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmPrikazTipaSobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmPrikazTipaSobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmPrikazTipaSobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmPrikazTipaSobe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtblDrugi;
    private javax.swing.JTable jtblPrvi;
    // End of variables declaration//GEN-END:variables

private void srediFormu() {
         List<TipSobe> lk = Kontroler.vratiInstancuKontrolera().vratiListuPrviTip();
        jtblPrvi.setModel(new TblModelPrviTip(lk));
        
          List<TipSobe> lkk = Kontroler.vratiInstancuKontrolera().vratiListuDrugiTip();
         jtblDrugi.setModel(new TblModelDrugiTip(lkk));
    }

   
    void osvezi() {
        srediFormu();
    }

}

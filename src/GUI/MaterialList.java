package GUI;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class MaterialList extends javax.swing.JFrame {

    String material;

    public MaterialList() {
        initComponents();
    }

    public MaterialList(String mat) {
        initComponents();
        this.material = mat;
        retrieve();
    }

    public void retrieve() {
        try {
            System.out.println("retreive method " + material);
            ResultSet r = DBConnection.query("SELECT *FROM " + material + " ");
            while (r.next()) {
                String name = r.getString("name");
                String byQnt = r.getString("bq");
                String slQnt = r.getString("sq");
                String avalQnt = r.getString("aq");
                String[] sArr = {name, byQnt, slQnt, avalQnt};
                DefaultTableModel tblModel = (DefaultTableModel) tblM.getModel();
                tblModel.addRow(sArr);
                System.out.println(name + byQnt + slQnt + avalQnt);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblM = new javax.swing.JTable();
        btngetItem = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(212, 228, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(17, 48, 89));
        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("X");
        btnBack.setBorder(null);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 40, 25));

        tblM.setBackground(new java.awt.Color(17, 48, 89));
        tblM.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblM.setForeground(new java.awt.Color(255, 255, 255));
        tblM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Buying Quntity", "Selling Quntity", "Available Quntity"
            }
        ));
        jScrollPane1.setViewportView(tblM);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, 780, 420));

        btngetItem.setBackground(new java.awt.Color(17, 48, 89));
        btngetItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btngetItem.setForeground(new java.awt.Color(255, 255, 255));
        btngetItem.setText("Select");
        btngetItem.setBorder(null);
        btngetItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngetItemActionPerformed(evt);
            }
        });
        jPanel1.add(btngetItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 130, 25));

        btnBack2.setBackground(new java.awt.Color(17, 48, 89));
        btnBack2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack2.setForeground(new java.awt.Color(255, 255, 255));
        btnBack2.setText("Add New");
        btnBack2.setBorder(null);
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 130, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btngetItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngetItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btngetItemActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack2ActionPerformed

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
            java.util.logging.Logger.getLogger(MaterialList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterialList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterialList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterialList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaterialList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btngetItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblM;
    // End of variables declaration//GEN-END:variables
}

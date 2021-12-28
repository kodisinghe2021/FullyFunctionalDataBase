/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import javax.swing.JOptionPane;
import util.DBConnection;

/**
 *
 * @author UComputers
 */
public class ItemBuyingForm extends javax.swing.JFrame {

    /**
     * Creates new form ItemBuyingForm
     */
    public ItemBuyingForm() {
        initComponents();
     //   getID();
        getitemList();
    }
    String date;
    String description;
    String invoice;
    String material;
    String itemName;
    String quntity;
    String totalPrice;
    String buyingquntity_ID;
    int ibuyingquntity_ID;

    //find item list and set it to the MAterialList table
    public void itemFinder() {
        itemName = cmbxItem.getSelectedItem().toString();
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement save = c.prepareStatement("SELECT * FROM " + material + " ");
            ResultSet r = save.executeQuery();

        } catch (Exception e) {
        }

    }
    // get item list from DB

    public void getitemList() {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement retriev = c.prepareStatement("SELECT * FROM materialtlist");
            ResultSet r = retriev.executeQuery();

            while (r.next()) {
                cmbxItem.addItem(r.getString("materialName"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //get last id from buyingquntity table
    public void getID() {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement save = c.prepareStatement("SELECT *FROM `assignment-ad-db`.buyingquntity ORDER BY buyingID DESC LIMIT 1");
            save.executeQuery();
            ResultSet r = save.executeQuery();
            while (r.next()) {
                buyingquntity_ID = r.getString("buyingID");
            }
            System.out.println(buyingquntity_ID);
        } catch (Exception e) {
            System.out.println(e);
        }
        // System.out.println(ibuyingquntity_ID);
    }

// add data to DB
    public void itemBySave() {
        int k = Integer.parseInt(buyingquntity_ID);
        buyingquntity_ID = String.valueOf(ibuyingquntity_ID = k + 1);
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement save = c.prepareStatement("INSERT INTO `assignment-ad-db`.`buyingquntity` (`material`, `date`, `quntity`) VALUES ('" + material + "', '" + date + "', '" + quntity + "')");
            save.execute();
            JOptionPane.showMessageDialog(this, "All Details Are saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateComponentFactory1 = new org.jdatepicker.JDateComponentFactory();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfTotalPrice = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        tfDesCription = new javax.swing.JTextField();
        tfInvoice = new javax.swing.JTextField();
        tfQuntity = new javax.swing.JTextField();
        cmbxItem = new javax.swing.JComboBox<>();
        btnGoToTbl = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(212, 228, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 48, 89));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setAlignmentX(1.0F);
        jPanel2.setAlignmentY(1.0F);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(17, 48, 89));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Date");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));

        jLabel2.setBackground(new java.awt.Color(17, 48, 89));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Invoice");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 30));

        jLabel3.setBackground(new java.awt.Color(17, 48, 89));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Description");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        jLabel4.setBackground(new java.awt.Color(17, 48, 89));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Quntity");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, 30));

        jLabel5.setBackground(new java.awt.Color(17, 48, 89));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total Price");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 100, 30));

        jLabel6.setBackground(new java.awt.Color(17, 48, 89));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Item");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        tfTotalPrice.setBackground(new java.awt.Color(10, 40, 80));
        tfTotalPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        tfTotalPrice.setBorder(null);
        jPanel2.add(tfTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 259, 34));

        tfDate.setBackground(new java.awt.Color(10, 40, 80));
        tfDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDate.setForeground(new java.awt.Color(255, 255, 255));
        tfDate.setBorder(null);
        jPanel2.add(tfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 90, 259, 34));

        tfDesCription.setBackground(new java.awt.Color(10, 40, 80));
        tfDesCription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDesCription.setForeground(new java.awt.Color(255, 255, 255));
        tfDesCription.setBorder(null);
        jPanel2.add(tfDesCription, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 259, 34));

        tfInvoice.setBackground(new java.awt.Color(10, 40, 80));
        tfInvoice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfInvoice.setForeground(new java.awt.Color(255, 255, 255));
        tfInvoice.setBorder(null);
        jPanel2.add(tfInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 259, 34));

        tfQuntity.setBackground(new java.awt.Color(10, 40, 80));
        tfQuntity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfQuntity.setForeground(new java.awt.Color(255, 255, 255));
        tfQuntity.setBorder(null);
        jPanel2.add(tfQuntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 259, 34));

        cmbxItem.setBackground(new java.awt.Color(17, 48, 89));
        cmbxItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(cmbxItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 259, 34));

        btnGoToTbl.setBackground(new java.awt.Color(17, 48, 89));
        btnGoToTbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGoToTbl.setForeground(new java.awt.Color(255, 255, 255));
        btnGoToTbl.setText("Get List");
        btnGoToTbl.setBorder(null);
        btnGoToTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToTblActionPerformed(evt);
            }
        });
        jPanel2.add(btnGoToTbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 130, 25));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Item Buying");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        btnSave.setBackground(new java.awt.Color(17, 48, 89));
        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 130, 25));

        btnClear.setBackground(new java.awt.Color(17, 48, 89));
        btnClear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setBorder(null);
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 130, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 490));

        btnBack.setBackground(new java.awt.Color(17, 48, 89));
        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back To DashBoard");
        btnBack.setBorder(null);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
// back button
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed
// save button
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        date = tfDate.getText();
        material = cmbxItem.getSelectedItem().toString();
        quntity = tfQuntity.getText();
        itemBySave();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnGoToTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToTblActionPerformed
        material = cmbxItem.getSelectedItem().toString();
        System.out.println("combo value : "+material);
        new MaterialList(material).setVisible(true);
    }//GEN-LAST:event_btnGoToTblActionPerformed

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
            java.util.logging.Logger.getLogger(ItemBuyingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemBuyingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemBuyingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemBuyingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemBuyingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGoToTbl;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxItem;
    private org.jdatepicker.JDateComponentFactory jDateComponentFactory1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDesCription;
    private javax.swing.JTextField tfInvoice;
    private javax.swing.JTextField tfQuntity;
    private javax.swing.JTextField tfTotalPrice;
    // End of variables declaration//GEN-END:variables
}

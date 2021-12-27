/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import util.DBConnection;

/**
 *
 * @author UComputers
 */
public class ItemSelling extends javax.swing.JFrame {

    /**
     * Creates new form ItemSelling
     */
    public ItemSelling() {
        initComponents();
        getitemList();
    }

    // create String Vector for get material list
    Vector<String> vec = new Vector<String>();
    // get item list from DB
    public void getitemList(){
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement retriev = c.prepareStatement("SELECT * FROM materialtlist");
            ResultSet r = retriev.executeQuery();
            
            while(r.next()){
           //   vec.add(r.getString("materialName"));
              cmbxMainItem.addItem(r.getString("materialName"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAvailableQuntity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSellingQuntity = new javax.swing.JTextField();
        lblDate = new javax.swing.JTextField();
        lblDes = new javax.swing.JTextField();
        lblInvoice = new javax.swing.JTextField();
        cmbxMainItem = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfttlPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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

        lblAvailableQuntity.setBackground(new java.awt.Color(17, 48, 89));
        lblAvailableQuntity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAvailableQuntity.setForeground(new java.awt.Color(255, 255, 255));
        lblAvailableQuntity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAvailableQuntity.setText("Available Quntity");
        jPanel2.add(lblAvailableQuntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, 30));

        jLabel5.setBackground(new java.awt.Color(17, 48, 89));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Quntity");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 30));

        jLabel6.setBackground(new java.awt.Color(17, 48, 89));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Item");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        lblSellingQuntity.setBackground(new java.awt.Color(10, 40, 80));
        lblSellingQuntity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSellingQuntity.setForeground(new java.awt.Color(255, 255, 255));
        lblSellingQuntity.setBorder(null);
        jPanel2.add(lblSellingQuntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 259, 34));

        lblDate.setBackground(new java.awt.Color(10, 40, 80));
        lblDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setBorder(null);
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 90, 259, 34));

        lblDes.setBackground(new java.awt.Color(10, 40, 80));
        lblDes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDes.setForeground(new java.awt.Color(255, 255, 255));
        lblDes.setBorder(null);
        jPanel2.add(lblDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 259, 34));

        lblInvoice.setBackground(new java.awt.Color(10, 40, 80));
        lblInvoice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblInvoice.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoice.setBorder(null);
        jPanel2.add(lblInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 259, 34));

        cmbxMainItem.setBackground(new java.awt.Color(17, 48, 89));
        cmbxMainItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbxMainItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agricultural equipment", "Seeds", "Plants", "Fertilizer", "Insecticides and herbicides" }));
        jPanel2.add(cmbxMainItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 259, 34));

        jButton1.setBackground(new java.awt.Color(17, 48, 89));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.setBorder(null);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 130, 25));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Item Selling");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        jButton3.setBackground(new java.awt.Color(17, 48, 89));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save");
        jButton3.setBorder(null);
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 130, 25));

        jLabel8.setBackground(new java.awt.Color(17, 48, 89));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Available Quntity");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, 30));

        tfttlPrice.setBackground(new java.awt.Color(10, 40, 80));
        tfttlPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfttlPrice.setForeground(new java.awt.Color(255, 255, 255));
        tfttlPrice.setBorder(null);
        jPanel2.add(tfttlPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 259, 34));

        jLabel9.setBackground(new java.awt.Color(17, 48, 89));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total Price");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 470));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
this.dispose();
new MainForm().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ItemSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemSelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemSelling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cmbxMainItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAvailableQuntity;
    private javax.swing.JTextField lblDate;
    private javax.swing.JTextField lblDes;
    private javax.swing.JTextField lblInvoice;
    private javax.swing.JTextField lblSellingQuntity;
    private javax.swing.JTextField tfttlPrice;
    // End of variables declaration//GEN-END:variables
}

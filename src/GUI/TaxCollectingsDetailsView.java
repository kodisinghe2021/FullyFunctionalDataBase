package GUI;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class TaxCollectingsDetailsView extends javax.swing.JFrame {
    
    public TaxCollectingsDetailsView() {
        initComponents();
        retrieve();
    }

    // get data from DB to Table
    public void retrieve() {
        DefaultTableModel tblModel = (DefaultTableModel) tblMain.getModel();
        tblModel.setRowCount(0);
        try {
            ResultSet r = DBConnection.query("SELECT *FROM taxcollectings ");
            while (r.next()) {
                String date = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {date, txnum, amount, fname};
                //define table and add values for table
                tblModel.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//filter result by date

    public void filterByDate() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE date BETWEEN '" + tfDateStart.getText() + "' AND '" + tfDateEnd.getText() + "';");
            while (r.next()) {
                String date = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {date, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //filter result using amount

    public void filterByAmount() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE amount BETWEEN '" + tfMin.getText() + "' AND '" + tfMax.getText() + "';");
            while (r.next()) {
                String date = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {date, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //filter result using amount and date

    public void filterByAmount_And_Date() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE date BETWEEN '" + tfDateStart.getText() + "' AND '" + tfDateEnd.getText() + "' AND amount BETWEEN '" + tfMin.getText() + "' AND '" + tfMax.getText() + "';");
            while (r.next()) {
                String date = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {date, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //search result using date ~~ when typing

    public void serchResult_Date() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        String date = tfDate.getText() + "%";
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE date LIKE '" + date + "';");
            while (r.next()) {
                String dt = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {dt, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //search result using farmer name ~~ when typing

    public void serchResult_FarmerName() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        String fName = tfFamerName.getText() + "%";
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE farmerName LIKE '" + fName + "';");
            while (r.next()) {
                String dt = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {dt, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //search result using farmer name ~~ when typing

    public void serchResult_taxNumber() {
        DefaultTableModel tblModelF = (DefaultTableModel) tblMain.getModel();
        tblModelF.setRowCount(0);
        String fName = tfTxNumber.getText() + "%";
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE taxNumber LIKE '" + fName + "';");
            while (r.next()) {
                String dt = r.getString("date");
                String fname = r.getString("farmerName");
                String txnum = r.getString("taxNumber");
                String amount = r.getString("amount");
                String[] sArr = {dt, txnum, amount, fname};
                tblModelF.addRow(sArr);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //  //Find total amount given time period

    public void findTtlAmount() {
        System.out.println(" in method");
        double ttl=0.0;
        String from = tfTtlFrom.getText();
        String to = tfTtlTo.getText();
        System.out.println(from+"  "+to);
        try {
            ResultSet r = DBConnection.query("SELECT * FROM taxcollectings WHERE amount BETWEEN '" + from + "' AND '" + to + "' ");
           
            while (r.next()) {
                String am = r.getString("amount");   
                System.out.println(am);
                ttl = ttl + Double.parseDouble(am);
            }
            lblTT.setText(String.valueOf(ttl));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfDateEnd = new javax.swing.JTextField();
        tfDateStart = new javax.swing.JTextField();
        chbxDate = new javax.swing.JCheckBox();
        chbxAmount = new javax.swing.JCheckBox();
        tfMin = new javax.swing.JTextField();
        tfMax = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfFamerName = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfTxNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblTT = new javax.swing.JLabel();
        tfTtlTo = new javax.swing.JTextField();
        tfTtlFrom = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(212, 228, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 48, 89));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setAlignmentX(1.0F);
        jPanel2.setAlignmentY(1.0F);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove.setBackground(new java.awt.Color(17, 48, 89));
        btnRemove.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove Filter");
        btnRemove.setBorder(null);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 130, 25));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Filter Result By");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 360, 40));

        tfDateEnd.setBackground(new java.awt.Color(10, 40, 80));
        tfDateEnd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDateEnd.setForeground(new java.awt.Color(255, 255, 255));
        tfDateEnd.setBorder(null);
        jPanel2.add(tfDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, 34));

        tfDateStart.setBackground(new java.awt.Color(10, 40, 80));
        tfDateStart.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDateStart.setForeground(new java.awt.Color(255, 255, 255));
        tfDateStart.setBorder(null);
        jPanel2.add(tfDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 90, 150, 34));

        chbxDate.setBackground(new java.awt.Color(17, 48, 89));
        chbxDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chbxDate.setForeground(new java.awt.Color(255, 255, 255));
        chbxDate.setText("Date");
        chbxDate.setBorder(null);
        jPanel2.add(chbxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));

        chbxAmount.setBackground(new java.awt.Color(17, 48, 89));
        chbxAmount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chbxAmount.setForeground(new java.awt.Color(255, 255, 255));
        chbxAmount.setText("Amount");
        chbxAmount.setBorder(null);
        jPanel2.add(chbxAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 30));

        tfMin.setBackground(new java.awt.Color(10, 40, 80));
        tfMin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfMin.setForeground(new java.awt.Color(255, 255, 255));
        tfMin.setBorder(null);
        jPanel2.add(tfMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 150, 34));

        tfMax.setBackground(new java.awt.Color(10, 40, 80));
        tfMax.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfMax.setForeground(new java.awt.Color(255, 255, 255));
        tfMax.setBorder(null);
        jPanel2.add(tfMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 150, 34));

        jLabel1.setBackground(new java.awt.Color(17, 48, 89));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Min");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 190, 50, 30));

        jLabel2.setBackground(new java.awt.Color(17, 48, 89));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Max");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 240, 50, 30));

        jLabel3.setBackground(new java.awt.Color(17, 48, 89));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Start");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 90, 50, 30));

        jLabel4.setBackground(new java.awt.Color(17, 48, 89));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("End");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 140, 50, 30));

        btnFilter.setBackground(new java.awt.Color(17, 48, 89));
        btnFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.setBorder(null);
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel2.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 130, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 360, 330));

        jButton2.setBackground(new java.awt.Color(17, 48, 89));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back To DashBoard");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 25));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tax Collecting details view");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 430, 40));

        jPanel3.setBackground(new java.awt.Color(17, 48, 89));
        jPanel3.setForeground(new java.awt.Color(204, 204, 255));
        jPanel3.setAlignmentX(1.0F);
        jPanel3.setAlignmentY(1.0F);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Search By");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 360, 40));

        tfFamerName.setBackground(new java.awt.Color(10, 40, 80));
        tfFamerName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfFamerName.setForeground(new java.awt.Color(255, 255, 255));
        tfFamerName.setBorder(null);
        jPanel3.add(tfFamerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 150, 34));

        tfDate.setBackground(new java.awt.Color(10, 40, 80));
        tfDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDate.setForeground(new java.awt.Color(255, 255, 255));
        tfDate.setBorder(null);
        tfDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDateKeyTyped(evt);
            }
        });
        jPanel3.add(tfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 150, 34));

        jLabel11.setBackground(new java.awt.Color(17, 48, 89));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Farmer Name");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 30));

        jLabel12.setBackground(new java.awt.Color(17, 48, 89));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Date");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 50, 30));

        jLabel16.setBackground(new java.awt.Color(17, 48, 89));
        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tax Number");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, 30));

        tfTxNumber.setBackground(new java.awt.Color(10, 40, 80));
        tfTxNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTxNumber.setForeground(new java.awt.Color(255, 255, 255));
        tfTxNumber.setBorder(null);
        jPanel3.add(tfTxNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 150, 34));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 410, 330));

        tblMain.setBackground(new java.awt.Color(255, 255, 255));
        tblMain.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblMain.setForeground(new java.awt.Color(0, 0, 0));
        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Tax Number", "Amount", "Farmer name"
            }
        ));
        jScrollPane1.setViewportView(tblMain);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 780, 140));

        jPanel4.setBackground(new java.awt.Color(17, 48, 89));
        jPanel4.setForeground(new java.awt.Color(204, 204, 255));
        jPanel4.setAlignmentX(1.0F);
        jPanel4.setAlignmentY(1.0F);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTT.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTT.setForeground(new java.awt.Color(255, 255, 255));
        lblTT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTT.setText("78,000 LKR");
        lblTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTTMouseClicked(evt);
            }
        });
        jPanel4.add(lblTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 160, 40));

        tfTtlTo.setBackground(new java.awt.Color(10, 40, 80));
        tfTtlTo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTtlTo.setForeground(new java.awt.Color(255, 255, 255));
        tfTtlTo.setBorder(null);
        jPanel4.add(tfTtlTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 150, 34));

        tfTtlFrom.setBackground(new java.awt.Color(10, 40, 80));
        tfTtlFrom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTtlFrom.setForeground(new java.awt.Color(255, 255, 255));
        tfTtlFrom.setBorder(null);
        jPanel4.add(tfTtlFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 150, 34));

        jLabel13.setBackground(new java.awt.Color(17, 48, 89));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("To");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 80, 30));

        jLabel14.setBackground(new java.awt.Color(17, 48, 89));
        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("From");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 50, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total Erning");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 690, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (chbxDate.isSelected() && chbxAmount.isSelected()) {
            filterByAmount_And_Date();
        } else if (chbxDate.isSelected()) {
            filterByDate();
        } else if (chbxAmount.isSelected()) {
            filterByAmount();
        }
        

    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        retrieve();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tfDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDateKeyTyped
        serchResult_Date();
    }//GEN-LAST:event_tfDateKeyTyped

    private void lblTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTTMouseClicked
findTtlAmount();
    }//GEN-LAST:event_lblTTMouseClicked

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
            java.util.logging.Logger.getLogger(TaxCollectingsDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaxCollectingsDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaxCollectingsDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaxCollectingsDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaxCollectingsDetailsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRemove;
    private javax.swing.JCheckBox chbxAmount;
    private javax.swing.JCheckBox chbxDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTT;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDateEnd;
    private javax.swing.JTextField tfDateStart;
    private javax.swing.JTextField tfFamerName;
    private javax.swing.JTextField tfMax;
    private javax.swing.JTextField tfMin;
    private javax.swing.JTextField tfTtlFrom;
    private javax.swing.JTextField tfTtlTo;
    private javax.swing.JTextField tfTxNumber;
    // End of variables declaration//GEN-END:variables
}

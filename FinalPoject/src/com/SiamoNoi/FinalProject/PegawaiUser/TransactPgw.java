/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.PegawaiUser;

import com.SiamoNoi.FinalProject.Model.Barang;
import com.SiamoNoi.FinalProject.Model.Brands;
import com.SiamoNoi.FinalProject.Model.Pembeli;
import com.SiamoNoi.FinalProject.Model.Transaksi;
import com.SiamoNoi.FinalProject.dao.ITransaksi;
import com.SiamoNoi.FinalProject.dao.InterfaceBarang;
import com.SiamoNoi.FinalProject.dao.daoBarang;
import com.SiamoNoi.FinalProject.dao.daoBrands;
import com.SiamoNoi.FinalProject.dao.daoPembeli;
import com.SiamoNoi.FinalProject.dao.daoTransaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class TransactPgw extends javax.swing.JFrame {
    daoBarang daoBarang ;
    daoPembeli daoPembeli;
    daoTransaksi daoTrans;
    /**
     * Creates new form TransactPgw
     */
    public TransactPgw() {
        initComponents();
        this.setLocationRelativeTo(null);
        daoBarang = new daoBarang();
        daoPembeli = new daoPembeli();
        daoTrans=new daoTransaksi();
        getBrands();
//        getBarang();
        getPembeli();
        getInfoPembeli();
        FilterComboBarang();
        isicmbtahun();
        isicmbtanggal();
    }
    private void getBrands(){
        List<Brands> brand = daoBarang.getAllBrands();
        int i=0;
        for(Brands item:brand){
            brandsComboBox.addItem(brand.get(i).toString());
            i++;
        }
    }
    
    private void getBarang(){
        List<Barang> barang = daoBarang.getALL();
        int i=0;
        for(Barang item:barang){
            barangComboBox.addItem(barang.get(i).getNama_barang());
            i++;
        }
    }
    
    private void FilterComboBarang(){
        String nama = brandsComboBox.getModel().getSelectedItem().toString();
        List<Barang> b = daoBarang.getBarangFilter(getIDBrand(nama));
        int i=0;
        barangComboBox.removeAllItems();
        for(Barang item:b){
            barangComboBox.addItem(b.get(i).getNama_barang());
            i++;
        }
    }
    
    private void getInfoPembeli(){
        String nama = pembeliComboBox.getModel().getSelectedItem().toString();
        List<Pembeli> cust = daoPembeli.autoFill(nama);
        int i=0;
        for(Pembeli item:cust){
            alamatTextArea.setText(cust.get(i).getAlamat());
            telpTextField.setText(cust.get(i).getTelepon());
            i++;
        }
    }
    
    public String getTgl(){
        int dd=Integer.parseInt(tglComboBox.getSelectedItem().toString());
        int mm=blnComboBox.getSelectedIndex()+1;
        int yy=Integer.parseInt(thnComboBox.getSelectedItem().toString());
        String tgl=yy+"/"+mm+"/"+dd;
        return tgl;
    }
    
    private void isicmbtahun(){
        Calendar cal =Calendar.getInstance();
        int tahun=cal.get(cal.YEAR);
        Integer[] isi = new Integer[60];
        for (int i = 0; i < isi.length; i++) {
            isi[i]=tahun-i;
        }
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel(isi);
        thnComboBox.setModel(cbModel);
    }
    
    private void isicmbtanggal(){
        int tgl = 1;
        Integer[] isi = new Integer[31];
        for (int i = 0; i < isi.length; i++) {
           isi[i]=tgl;
            tgl++;
        }
        
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel(isi);
        tglComboBox.setModel(cbModel);
    }
    
//    private class cbListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            Pembeli cust=(Pembeli) pembeliComboBox.getSelectedItem();
//            alamatTextArea.setText(cust.getAlamat());
//            telpTextField.setText(cust.getTelepon());
//        }
//    }
    
    private void getPembeli(){
//        List<Pembeli> cust = daoPembeli.getALL();
//        int i=0;
//        for(Pembeli item:cust){
//            pembeliComboBox.addItem(cust.get(i).getNama_pembeli());
//            i++;
//        }
        pembeliComboBox.removeAllItems();
        List<Pembeli> Customers=daoPembeli.getALL();
        for(Pembeli cust:Customers){
            pembeliComboBox.addItem(cust.getNama_pembeli());
        }
    }
    
    private int getIDBarang(String nama){
    daoBarang daoBarang = new daoBarang();
    return daoBarang.getID(nama);
    }
    
    private int getIDBrand(String nama){
    daoBrands daoBrand = new daoBrands();
    return daoBrand.getID(nama);
    }
    
    private int getIDPembeli(String nama){
    daoPembeli daoPembeli = new daoPembeli();
    return daoPembeli.getID(nama);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telpTextField = new javax.swing.JTextField();
        QtyTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        barangComboBox = new javax.swing.JComboBox<>();
        brandsComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pembeliComboBox = new javax.swing.JComboBox<>();
        tglComboBox = new javax.swing.JComboBox<>();
        blnComboBox = new javax.swing.JComboBox<>();
        thnComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Tanggal Transaksi");

        jLabel2.setText("Nama Pembeli");

        jLabel3.setText("Alamat Pembeli");

        jLabel4.setText("No Telp. Pembeli");

        jLabel5.setText("Barang");

        jLabel6.setText("Brand");

        jLabel7.setText("Jumlah");

        brandsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandsComboBoxActionPerformed(evt);
            }
        });

        alamatTextArea.setColumns(20);
        alamatTextArea.setRows(5);
        jScrollPane1.setViewportView(alamatTextArea);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pembeliComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembeliComboBoxActionPerformed(evt);
            }
        });

        tglComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        blnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        thnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tglComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thnComboBox, 0, 78, Short.MAX_VALUE))
                            .addComponent(barangComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brandsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telpTextField)
                            .addComponent(jScrollPane1)
                            .addComponent(QtyTextField)
                            .addComponent(pembeliComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tglComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pembeliComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(barangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(brandsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        try {
            String nama=barangComboBox.getSelectedItem().toString();
//            InterfaceBarang iBarang = new daoBarang();
            List<Barang> lb =  daoBarang.getCariNama(nama);

            Transaksi trx = new Transaksi();
            trx.setTanggal(getTgl());
            trx.setNama_pembeli(pembeliComboBox.getSelectedItem().toString());
            trx.setId_pembeli(getIDPembeli(pembeliComboBox.getSelectedItem().toString()));
            trx.setAlamat_pembeli(alamatTextArea.getText());
            trx.setTelepon(telpTextField.getText());
            trx.setNama_barang(barangComboBox.getSelectedItem().toString());
            trx.setId_barang(getIDBarang(barangComboBox.getSelectedItem().toString()));
            trx.setNama_brand(brandsComboBox.getSelectedItem().toString());
            trx.setId_brand(getIDBrand(brandsComboBox.getSelectedItem().toString()));
            trx.setQty(Integer.parseInt(QtyTextField.getText()));
            int i=0;
            int hrg=0;
            for(Barang item:lb){
                hrg=lb.get(i).getHarga();
                i++;
            }
            trx.setHarga_satuan(hrg);
            trx.setHarga_total();
            String brg = barangComboBox.getSelectedItem().toString();
            int jml=daoBarang.selectJumlah(getIDBarang(brg));
            if (jml<=0) {
                JOptionPane.showMessageDialog(null, "Mohon Maaf Stok Barang Habis");
            }else{
               daoTrans.insert(trx);
               jml=jml-Integer.parseInt(QtyTextField.getText());
               daoBarang.updateJumlah(getIDBarang(brg), jml);
               JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Transaksi Gagal");
        }
       
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pembeliComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembeliComboBoxActionPerformed
        // TODO add your handling code here:
        getInfoPembeli();

    }//GEN-LAST:event_pembeliComboBoxActionPerformed

    private void brandsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandsComboBoxActionPerformed
        // TODO add your handling code here:
        FilterComboBarang();
    }//GEN-LAST:event_brandsComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(TransactPgw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactPgw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactPgw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactPgw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactPgw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QtyTextField;
    private javax.swing.JTextArea alamatTextArea;
    private javax.swing.JComboBox<String> barangComboBox;
    private javax.swing.JComboBox<String> blnComboBox;
    private javax.swing.JComboBox<String> brandsComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pembeliComboBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField telpTextField;
    private javax.swing.JComboBox<String> tglComboBox;
    private javax.swing.JComboBox<String> thnComboBox;
    // End of variables declaration//GEN-END:variables

}

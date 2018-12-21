/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Brands;
import com.SiamoNoi.FinalProject.Model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class daoTransaksi implements ITransaksi{
    Connection connection;
    String insert ="INSERT INTO tbl_transaksi (tanggal,nama_pembeli,alamat_pembeli,telepon,nama_barang,nama_brand,qty,harga_satuan,harga_total) VALUES (?,?,?,?,?,?,?,?,?);";
    String delete ="DELETE FROM tbl_transaksi where id_transaksi=? ;";
    String select ="SELECT * FROM tbl_brand;";
    String update ="UPDATE tbl_transaksi set tanggal=?,nama_pembeli=?,alamat_pembeli=?,telepon=?,nama_barang=?,nama_brand=?,qty=?,harga_satuan=?,harga_total=? ;";
    
    @Override
    public void insert(Transaksi trx) {
        PreparedStatement statement = null;
           try {
               statement=connection.prepareStatement(insert);
               statement.setString(1, trx.getTanggal());
               statement.setString(2, trx.getNama_pembeli());
               statement.setString(3, trx.getAlamat_pembeli());
               statement.setString(4, trx.getTelepon());
               statement.setString(5, trx.getNama_barang());
               statement.setString(6, trx.getNama_brand());
               statement.setInt(7, trx.getQty());
               statement.setInt(8, trx.getHarga_satuan());
               statement.setInt(9, trx.getHarga_total());
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           } finally{
               try {
                   statement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Transaksi> getALL() {
        List<Transaksi> lt=null;
        try {
            lt=new ArrayList<Transaksi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Transaksi trx = new Transaksi();
                trx.setId_transaksi(rs.getInt("id_transaksi"));
                trx.setTanggal(rs.getString("tanggal"));
                trx.setNama_pembeli(rs.getString("nama_pembeli"));
                trx.setAlamat_pembeli(rs.getString("alamat_pembeli"));
                trx.setTelepon(rs.getString("telepon"));
                trx.setNama_barang(rs.getString("nama_barang"));
                trx.setNama_brand(rs.getString("nama_brand"));
                trx.setQty(rs.getInt("qty"));
                trx.setHarga_satuan(rs.getInt("harga_satuan"));
                trx.setHarga_total();
                lt.add(trx);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return lt;
    }
    
}

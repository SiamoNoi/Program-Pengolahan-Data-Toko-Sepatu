/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Barang;
import com.SiamoNoi.FinalProject.koneksi.koneksi;
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
public class daoBarang implements InterfaceBarang{
    
    Connection connection;
    String insert ="INSERT INTO toko_sepatu (nama_brand,nama_brand,size,color,harga,jumlah_barang) VALUES (?,?,?,?,?,?,?);";
    String update ="UPDATE toko_sepatu set nama_brand=?,nama_brand=?,size=?,color=?,harga=?,jumlah_barang=? ;";
    String delete ="DELETE FROM toko_sepatu where id_barang=? ;";
    String select ="SELECT * FROM toko_sepatu;";
    String carinama ="SELECT * FROM toko_sepatu WHERE nama_barang like ?";
    
    public daoBarang(){
        connection = koneksi.conection();
    }

    @Override
    public void insert(Barang b) {
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement(insert);
            statement.setString(2, b.getNama_brand());
            statement.setString(3, b.getNama_barang());
            statement.setString(4, b.getSize());
            statement.setString(5, b.getColor());
            statement.setInt(6, b.getHarga());
            statement.setInt(7, b.getJumlah_barang());
            statement.executeUpdate();
            ResultSet rs= statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId_barang(rs.getInt(1));
            }
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
    public void update(Barang b) {
        PreparedStatement statement =null;
        try {
            statement=connection.prepareStatement(update);
            statement.setInt(1, b.getId_barang());
            statement.setString(2, b.getNama_brand());
            statement.setString(3, b.getNama_barang());
            statement.setString(4, b.getSize());
            statement.setString(5, b.getColor());
            statement.setInt(6, b.getHarga());
            statement.setInt(7, b.getJumlah_barang());
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
    public List<Barang> getALL() {
        List<Barang> lb=null;
        try {
            lb=new ArrayList<Barang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Barang b = new Barang();
                b.setId_barang(rs.getInt("ID"));
                b.setNama_brand(rs.getString("Brand"));
                b.setNama_barang(rs.getString("Nama Barang"));
                b.setSize(rs.getString("Size"));
                b.setColor(rs.getString("Warna"));
                b.setHarga(rs.getInt("Harga"));
                b.setJumlah_barang(rs.getInt("Jumlah Stok"));
                lb.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return lb;
    }

    @Override
    public List<Barang> getCariNama(String nama) {
        List<Barang> lb=null;
        try {
            lb=new ArrayList<Barang>();
            PreparedStatement st= connection.prepareStatement(carinama);
            st.setString(1,"%"+nama+"%");
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                Barang b = new Barang();
                b.setId_barang(rs.getInt("ID"));
                b.setNama_brand(rs.getString("Brand"));
                b.setNama_barang(rs.getString("Nama Barang"));
                b.setSize(rs.getString("Size"));
                b.setColor(rs.getString("Warna"));
                b.setHarga(rs.getInt("Harga"));
                b.setJumlah_barang(rs.getInt("Jumlah Stok"));
                lb.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        return lb;
    }
    

}

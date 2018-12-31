/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Barang;
import com.SiamoNoi.FinalProject.Model.Brands;
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
    String insert ="INSERT INTO tbl_barang (id_brand,nama_barang,size,color,harga,jumlah_barang) VALUES (?,?,?,?,?,?);";
    String update ="UPDATE tbl_barang set id_brand=?,nama_brand=?,size=?,color=?,harga=?,jumlah_barang=? ;";
    String delete ="DELETE FROM tbl_barang where id_barang=? ;";
    String select ="SELECT * FROM tbl_barang join tbl_brand on tbl_barang.id_brand=tbl_brand.id_brand;";
    String carinama ="SELECT * FROM tbl_barang WHERE nama_barang like ?";
    String getBarangFilter ="SELECT nama_barang FROM tbl_barang WHERE nama_brand like ?";
    String SelectJumlah="SELECT jumlah_barang FROM tbl_barang WHERE id_barang=?;";
    String updateJumlah="update tbl_barang set jumlah_barang=? where id_barang=? ;";
    public daoBarang(){
        connection = koneksi.conection();
    }

    @Override
    public void insert(Barang b) {
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement(insert);
            statement.setInt(1, b.getId_brand());
            statement.setString(2, b.getNama_barang());
            statement.setString(3, b.getSize());
            statement.setString(4, b.getColor());
            statement.setInt(5, b.getHarga());
            statement.setInt(6, b.getJumlah_barang());
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
    public void update(Barang b) {
        PreparedStatement statement =null;
        try {
            statement=connection.prepareStatement(update);
            statement.setInt(1, b.getId_barang());
            statement.setString(2, b.getNama_brand());
            statement.setInt(3, b.getId_brand());
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
                b.setId_barang(rs.getInt("id_barang"));
                b.setNama_brand(rs.getString("nama_brand"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setSize(rs.getString("size"));
                b.setColor(rs.getString("color"));
                b.setHarga(rs.getInt("harga"));
                b.setJumlah_barang(rs.getInt("jumlah_barang"));
                lb.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return lb;
    }
    
    public List<Brands> getAllBrands(){
        List<Brands> lb=null;
        try {
            lb = new ArrayList<Brands>();
            Statement st =connection.createStatement();
            ResultSet rs =st.executeQuery("SELECT * FROM tbl_brand");
            while (rs.next()) {
                Brands brand=new Brands();
                brand.setId_brand(rs.getInt("id_brand"));
                brand.setNama_brand(rs.getString("nama_brand"));
                lb.add(brand);
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
                b.setId_barang(rs.getInt("id_barang"));
                b.setNama_brand(rs.getString("nama_brand"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setSize(rs.getString("size"));
                b.setColor(rs.getString("color"));
                b.setHarga(rs.getInt("harga"));
                b.setJumlah_barang(rs.getInt("jumlah_barang"));
                lb.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        return lb;
    }
    
    public List<Barang> getBarangFilter (String nama){
        List<Barang> lp=null;
        try {
            lp=new ArrayList<Barang>();
            PreparedStatement st= connection.prepareStatement(getBarangFilter);
            st.setString(1,"%"+nama+"%");
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                 Barang b = new Barang();
                b.setNama_barang(rs.getString("nama_barang"));
                lp.add(b);
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        return lp;
    }
    
    public int selectJumlah (int id){
        int jumlah=0;
        try {
            PreparedStatement st= connection.prepareStatement(SelectJumlah);
            st.setInt(1,id);
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                jumlah=rs.getInt("jumlah_barang");
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        return jumlah;
    }
    
    public void updateJumlah (int id,int qty){
        PreparedStatement statement =null;
        try {
            statement=connection.prepareStatement(updateJumlah);
            statement.setInt(1,qty);
            statement.setInt(2,id);
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
}

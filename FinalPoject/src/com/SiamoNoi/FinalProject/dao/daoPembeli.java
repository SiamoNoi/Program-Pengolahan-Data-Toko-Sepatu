/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;


import com.SiamoNoi.FinalProject.Model.Barang;
import com.SiamoNoi.FinalProject.Model.Pembeli;
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
public class daoPembeli implements IPembeli{

    Connection connection;
    String insert ="INSERT INTO tbl_pembeli (nama_pembeli,kota,alamat,gender,telepon) VALUES (?,?,?,?,?);";
    String delete ="DELETE FROM tbl_pembeli where id_pembeli=? ;";
    String select ="SELECT * FROM tbl_pembeli;";
    String autoFill="SELECT alamat,telepon FROM tbl_pembeli where nama_pembeli like ?;";
    String getIdPembeli ="SELECT id_pembeli FROM tbl_pembeli WHERE nama_pembeli like ?";
    
    public daoPembeli() {
    connection= koneksi.conection();
    }
    
    public List<Pembeli> autoFill(String nama){
        List<Pembeli> lp=null;
        try {
            lp=new ArrayList<Pembeli>();
            PreparedStatement st= connection.prepareStatement(autoFill);
            st.setString(1,"%"+nama+"%");
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                 Pembeli p = new Pembeli();               
                p.setAlamat(rs.getString("alamat"));
                p.setTelepon(rs.getString("telepon"));
                lp.add(p);
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        return lp;
    }
    
    @Override
    public void insert(Pembeli p) {
        PreparedStatement statement = null;
        try {
               statement=connection.prepareStatement(insert);
               statement.setString(1, p.getNama_pembeli());
               statement.setString(2, p.getKota());
               statement.setString(3, p.getAlamat());
               statement.setString(4, p.getGender());
               statement.setString(5, p.getTelepon());
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
    public List<Pembeli> getALL() {
        List<Pembeli> lp=null;
        try {
            lp=new ArrayList<Pembeli>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Pembeli p = new Pembeli();
                p.setId_pembeli(rs.getInt("id_pembeli"));
                p.setNama_pembeli(rs.getString("nama_pembeli"));
                p.setKota(rs.getString("kota"));
                p.setAlamat(rs.getString("alamat"));
                p.setGender(rs.getString("gender"));
                p.setTelepon(rs.getString("telepon"));
                lp.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return lp;
    }
    
    public int getID (String nama){
        int id = 0;
        try {
            PreparedStatement st= connection.prepareStatement(getIdPembeli);
            st.setString(1,"%"+nama+"%");
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                id=rs.getInt("id_pembeli");
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        System.out.println(id);
        return id;
    }
}

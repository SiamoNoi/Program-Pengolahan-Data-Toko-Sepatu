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
public class daoBrands implements IBrands{
    Connection connection;
    String insert ="INSERT INTO tbl_brand (nama_brand) VALUES (?);";
    String delete ="DELETE FROM tbl_brand where id_brand=? ;";
    String getIdBrand ="SELECT id_brand FROM tbl_brand WHERE nama_brand like ?";
    String select ="SELECT * FROM tbl_brand;";

    public daoBrands() {
    connection= koneksi.conection();
    }
    
    @Override
    public void insert(Brands b) {
        PreparedStatement statement = null;
           try {
               statement=connection.prepareStatement(insert);
               statement.setString(1, b.getNama_brand());
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
    public List<Brands> getALL() {
        List<Brands> lb=null;
        try {
            lb=new ArrayList<Brands>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Brands b = new Brands();
                b.setId_brand(rs.getInt("id_brand"));
                b.setNama_brand(rs.getString("nama_brand"));
                lb.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return lb;
    }
    
    public int getID (String nama){
        int id = 0;
        try {
            PreparedStatement st= connection.prepareStatement(getIdBrand);
            st.setString(1,"%"+nama+"%");
            ResultSet rs =st.executeQuery();
            while (rs.next()) {
                id=rs.getInt("id_brand");
            }
        } catch (Exception e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE, null , e);
        }
        System.out.println(id);
        return id;
    }
}

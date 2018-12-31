/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Account;
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
public class daoAccount implements IAccount{
    Connection connection;
    String insertAdmin ="INSERT INTO tbl_loginadmin (username,password) VALUES (?,?);";
    String insertPegawai ="INSERT INTO tbl_loginpegawai (username,password) VALUES (?,?);";
    String updateAdmin ="UPDATE tbl_loginadmin set username=?,password=? where id_akun=? ;";
    String updatePegawai ="UPDATE tbl_loginpegawai set username=?,password=? where id_akun=? ;";
    String deleteAdmin ="DELETE FROM tbl_loginadmin where id_akun=? ;";
    String deletePegawai ="DELETE FROM tbl_loginpegawai where id_akun=? ;";
    String selectAdmin ="SELECT * FROM tbl_loginadmin;";
    String selectPegawai ="SELECT * FROM tbl_loginpegawai;";

    public daoAccount() {
        connection=koneksi.conection();
    }
    
    
    @Override
    public void insert(Account akun) {
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement(insertAdmin);
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
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
    
    public void insertPegawai(Account akun) {
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement(insertPegawai);
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
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
            statement = connection.prepareStatement(deleteAdmin);
            
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
    
    public void deletePegawai(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deletePegawai);
            
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
    public List<Account> getALL() {
       List<Account> akun=null;
        try {
            akun=new ArrayList<Account>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectAdmin);
            while (rs.next()) {
                Account a = new Account();
                a.setId_akun(rs.getInt("id_akun"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                akun.add(a);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return akun;
    }
    
    public List<Account> getALLPegawai() {
       List<Account> akun=null;
        try {
            akun=new ArrayList<Account>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectPegawai);
            while (rs.next()) {
                Account a = new Account();
                a.setId_akun(rs.getInt("id_akun"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                akun.add(a);
            }
        } catch (SQLException e) {
            Logger.getLogger(daoBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        return akun;
    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

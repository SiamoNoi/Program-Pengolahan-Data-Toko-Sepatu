/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.koneksi;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import javax.swing.JOptionPane;
public class koneksi {
    static Connection connect;
    
    public static Connection conection(){
        if (connect==null) {
            MysqlDataSource data = new MysqlConnectionPoolDataSource();
            data.setDatabaseName("toko_sepatu");
            data.setUser("root");
            data.setPassword("");
            try {
                connect= data.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connect=DriverManager.getConnection("jdbc:mysql://localhost/toko_sepatu", "root", "");
//            stm = connect.createStatement();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
//        }
        return connect;
    }
}

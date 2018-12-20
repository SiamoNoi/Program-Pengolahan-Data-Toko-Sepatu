/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.Model;

import com.SiamoNoi.FinalProject.koneksi.koneksi;
import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class comboBrandsModel{
    private HashMap<Integer, String> Items = new HashMap<>();
    Connection connection;
    String query = "SELECT * FROM brand";

    public comboBrandsModel() {
        connection=koneksi.conection();
    }
    
    
}

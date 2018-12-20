/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.Model;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class Brands {
    private int id_brand;
    private String nama_brand;

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getNama_brand() {
        return nama_brand;
    }

    public void setNama_brand(String nama_brand) {
        this.nama_brand = nama_brand;
    }

    @Override
    public String toString() {
        String str=nama_brand;
        return str;
    }
    
    
}

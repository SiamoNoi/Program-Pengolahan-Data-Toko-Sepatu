/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class TableModeltransaksi extends AbstractTableModel{
    List<Transaksi> lt;

    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    public String getColumnName (int column){
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Tanggal";
            case 2:
                return "Nama Pembeli";
            case 3:
                return "Alamat";
            case 4:
                return "Telp";
            case 5:
                return "Barang";
            case 6:
                return "Brands";
            case 7:
                return "Qty";
            case 8:
                return "Harga Satuan";
            case 9:
                return "Harga Total";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lt.get(rowIndex).getId_transaksi();
            case 1:
                return lt.get(rowIndex).getTanggal();
            case 2:
                return lt.get(rowIndex).getNama_pembeli();
            case 3:
                return lt.get(rowIndex).getAlamat_pembeli();
            case 4:
                return lt.get(rowIndex).getTelepon();
            case 5:
                return lt.get(rowIndex).getNama_barang();
            case 6:
                return lt.get(rowIndex).getNama_brand();
            case 7:
                return lt.get(rowIndex).getQty();
            case 8:
                return lt.get(rowIndex).getHarga_satuan();
            case 9:
                return lt.get(rowIndex).getHarga_total();
            default:
                return null;
        }
    }
}

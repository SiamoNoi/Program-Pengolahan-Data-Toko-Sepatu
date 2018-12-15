/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.Model;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public class TableModelBarang extends AbstractTableModel{
    List<Barang> lb;

    public TableModelBarang(List<Barang> lb) {
        this.lb = lb;
    }
        
    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public String getColumnName (int column){
        switch(column) {
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Brand";
            case 2:
                return "Nama Barang";
            case 3:
                return "Size";
            case 4:
                return "Color";
            case 5:
                return "Harga";
            case 6:
                return "Jumlah Barang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lb.get(rowIndex).getId_barang();
            case 1:
                return lb.get(rowIndex).getNama_brand();
            case 2:
                return lb.get(rowIndex).getNama_barang();
            case 3:
                return lb.get(rowIndex).getSize();
            case 4:
                return lb.get(rowIndex).getColor();
            case 5:
                return lb.get(rowIndex).getHarga();
            case 6:
                return lb.get(rowIndex).getJumlah_barang();
            default:
                return null;
        }
    }
    
}

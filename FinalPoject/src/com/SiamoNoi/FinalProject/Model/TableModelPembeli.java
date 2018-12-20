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
public class TableModelPembeli extends AbstractTableModel{
    List<Pembeli> lp ;

    public TableModelPembeli(List<Pembeli> lp) {
        this.lp = lp;
    }
    
    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
         return 6;
    }
    
    public String getColumnName (int column){
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Kota";
            case 3:
                return "Alamat";
            case 4:
                return "Gender";
            case 5:
                return "No.Telp";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lp.get(rowIndex).getId_pembeli();
            case 1:
                return lp.get(rowIndex).getNama_pembeli();
            case 2:
                return lp.get(rowIndex).getKota();
            case 3:
                return lp.get(rowIndex).getAlamat();
            case 4:
                return lp.get(rowIndex).getGender();
            case 5:
                return lp.get(rowIndex).getTelepon();
            default:
                return null;
        }
    }
    
}

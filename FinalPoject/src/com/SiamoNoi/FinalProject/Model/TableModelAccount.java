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
public class TableModelAccount extends AbstractTableModel{
    List<Account> akun ;
    
    public TableModelAccount(List<Account> akun) {
        this.akun = akun;
    }
    
    @Override
    public int getRowCount() {
        return akun.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    public String getColumnName (int column){
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Username";
            case 2:
                return "Password";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return akun.get(rowIndex).getId_akun();
            case 1:
                return akun.get(rowIndex).getUsername();
            case 2:
                return akun.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    
}

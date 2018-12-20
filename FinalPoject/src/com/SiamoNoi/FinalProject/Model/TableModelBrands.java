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
public class TableModelBrands extends AbstractTableModel{
    List<Brands> lb;

    public TableModelBrands(List<Brands> lb) {
        this.lb = lb;
    }
    
    
    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }
    
    public String getColumnName (int column){
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Brand";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex){
            case 0:
                return lb.get(rowIndex).getId_brand();
            case 1:
                return lb.get(rowIndex).getNama_brand();
            default:
                return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import java.util.*;
import com.SiamoNoi.FinalProject.Model.*;
/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public interface InterfaceBarang {
    public void insert (Barang b);
    public void update (Barang b);
    public void delete (int id);
    public List<Barang> getALL();
    public List<Barang> getCariNama(String nama);
    
}

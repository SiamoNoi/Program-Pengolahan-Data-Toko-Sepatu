/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Pembeli;
import java.util.List;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public interface IPembeli {
    public void insert (Pembeli p);
    public void delete (int id);
    public List<Pembeli> getALL();
}

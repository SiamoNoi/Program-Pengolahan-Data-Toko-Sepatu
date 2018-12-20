/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Transaksi;
import java.util.List;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public interface ITransaksi {
    public void insert (Transaksi trx);
    public void delete (int id);
    public List<Transaksi> getALL();
}

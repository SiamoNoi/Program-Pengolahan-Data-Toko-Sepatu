/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SiamoNoi.FinalProject.dao;

import com.SiamoNoi.FinalProject.Model.Account;
import java.util.List;

/**
 *
 * @author AhmadSyifaur<ahmadsyifaur11@gmail.com>
 */
public interface IAccount {
    public void insert (Account akun);
    public void delete (int id);
    public void update (int id);
    public List<Account> getALL();
}

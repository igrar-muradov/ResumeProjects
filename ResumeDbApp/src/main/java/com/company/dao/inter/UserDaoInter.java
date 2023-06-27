/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.bean.User;
import java.util.List;

/**
 *
 * @author Igrar
 */
public interface UserDaoInter {
    public List<User> getAll();
    public User getById(int i);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
}

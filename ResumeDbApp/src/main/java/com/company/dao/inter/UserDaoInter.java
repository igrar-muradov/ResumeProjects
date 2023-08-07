/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author Igrar
 */
public interface UserDaoInter {

    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(Integer i);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(Integer id);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

/**
 *
 * @author Igrar
 */
public class Config {
    
    private static final UserDaoInter userDao = Context.instanceUserDao();
    public static User loggedInUser= userDao.getById(6);
}


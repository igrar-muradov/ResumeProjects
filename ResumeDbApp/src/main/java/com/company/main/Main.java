/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.company.main;

import com.company.bean.User;
import com.company.dao.inter.UserDaoInter;

/**
 *
 * @author Igrar
 */
public class Main {

    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getById(2);
        u.setName("Eldar");
        userDao.updateUser(u);
        System.out.println(userDao.getById(2));

    }

}

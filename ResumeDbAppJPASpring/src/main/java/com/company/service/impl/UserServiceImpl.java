/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author Igrar
 */

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return  userDao.getAll(name, surname, nationalityId);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

        @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    
    @Override
    public User getById(Integer userId) {
        return userDao.getById(userId);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean removeUser(Integer id) {
        return userDao.removeUser(id);
    }


    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

}

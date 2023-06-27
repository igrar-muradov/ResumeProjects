/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;

/**
 *
 * @author Igrar
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @SneakyThrows
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        Connection con = connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            result.add(new User(id, name, surname, phone, email));
        }
        con.close();
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where id = "+userId);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                result = new User(id, name, surname, phone, email);
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("update user set name=?, surname=?, phone=?, email=? where id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getId());
            stmt.execute();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from user where id = " + id);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

}

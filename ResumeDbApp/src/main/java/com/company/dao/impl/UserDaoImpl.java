/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

/**
 *
 * @author Igrar
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @SneakyThrows
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        Country nationality = new Country(nationalityId, nationalityStr, null);
        Country birthPlace = new Country(birthplaceId, null, birthPlaceStr);

        return new User(id, name, surname, phone, email, birthdate, nationality, birthPlace);
    }

    @SneakyThrows
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            stmt.execute("select "
                    + "    u.*, "
                    + "    c.nationality as nationality, "
                    + "    n.name as birthplace "
                    + "    from user u "
                    + "left join country n ON u.nationality_id  = n.id "
                    + "left join country c ON u.birthplace_id  = c.id ");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            stmt.execute("select "
                    + "    u.*, "
                    + "    c.nationality as nationality, "
                    + "    n.name as birthplace "
                    + "    from user u "
                    + "left join country n ON u.nationality_id  = n.id "
                    + "left join country c ON u.birthplace_id  = c.id "
                    + "where u.id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
            con.close();

        } catch (Exception ex) {
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

    @Override
    public boolean addUser(User u) {
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("insert into user(name, surname, phone, email) values(?,?,?,?) ");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.execute();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

}

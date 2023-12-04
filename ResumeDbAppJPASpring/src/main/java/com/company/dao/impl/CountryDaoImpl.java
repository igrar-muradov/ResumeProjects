/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igrar
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    
    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(id, name, nationality);
    }
    
    
    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try(Connection con = connect();) {
            Statement stmt = con.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country c = getCountry(rs);
                result.add(c);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

   

}

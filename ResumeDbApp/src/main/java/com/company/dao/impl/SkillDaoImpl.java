/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Country;
import com.company.entity.Skill;
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
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    
    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Skill(id, name);
    }
    
    
    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try(Connection con = connect();) {
            Statement stmt = con.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill s = getSkill(rs);
                result.add(s);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

   

}

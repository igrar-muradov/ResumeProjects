/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try ( Connection con = connect();) {
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

    @Override
    public Skill getSkillById(int id) {
        Skill s = null;
        try ( Connection con = connect();) {
            PreparedStatement stmt = con.prepareStatement("select * from skill where id=? ;");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            s = getSkill(rs);

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return s;
    }

    @Override
    public boolean addSkill(Skill s) {
        boolean b = true;
        try ( Connection con = connect();) {
            PreparedStatement stmt = con.prepareStatement("insert into skill(name) values (?);");
            stmt.setString(1, s.getName());
            b = stmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return b;
    }

    @Override
    public boolean removeSkillById(int id) {
        boolean b = true;
        try ( Connection con = connect();) {
            PreparedStatement stmt = con.prepareStatement("delete from skill where id = ?");
            stmt.setInt(1, id);
            b = stmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return b;
    }

}

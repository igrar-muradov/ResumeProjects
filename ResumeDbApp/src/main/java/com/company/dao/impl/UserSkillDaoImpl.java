/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igrar
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        Integer userSkillId = rs.getInt("user_skill_id");
        Integer userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);

    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection con = connect();){
            PreparedStatement stmt = con.prepareStatement("select "
                    + "   us.id as user_skill_id, "
                    + "   u.*, "
                    + "   us.skill_id, "
                    + "   s.name as skill_name, "
                    + "   us.power "
                    + "from  "
                    + "   user_skill us  "
                    + "   left join user u on us.user_id = u.id "
                    + "   left join skill s on us.skill_id = s.id "
                    + "where  "
                    + "   us.user_id = ? ");
            stmt.setInt(1, userId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public boolean insertUserSkill(UserSkill us) {
        boolean b=true;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("insert into user_skill (skill_id, user_id, power) values (?, ?, ?)");
            stmt.setInt(1, us.getSkill().getId());
            stmt.setInt(2, us.getUser().getId());
            stmt.setInt(3, us.getPower());
            
            b = stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return b;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        boolean b=true;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("update user_skill set skill_id=?, user_id=?, power = ? where id = ?");
            stmt.setInt(1, us.getSkill().getId());
            stmt.setInt(2, us.getUser().getId());
            stmt.setInt(3, us.getPower());
            stmt.setInt(4, us.getId());
            b = stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return b;
    }

    @Override
    public boolean removeUserSkillById(int id) {
                boolean b=true;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("delete from user_skill where id = ?");
            stmt.setInt(1, id);
            b = stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return b;
    }
    
    

}

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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igrar
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        Integer userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);

    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try {
            Connection con = connect();
            PreparedStatement stmt = con.prepareStatement("select "
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
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

}

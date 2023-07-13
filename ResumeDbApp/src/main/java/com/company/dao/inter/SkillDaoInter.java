/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author Igrar
 */
public interface SkillDaoInter {

    public List<Skill> getAll();
    
    public Skill getSkillById(int id);
    
    public boolean addSkill(Skill s);
    
    public boolean removeSkillById(int id);
    
}

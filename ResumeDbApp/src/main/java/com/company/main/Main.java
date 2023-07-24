/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.*;

/**
 *
 * @author Igrar
 */
public class Main {

    public static void main(String[] args) {
        
        UserSkillDaoInter  userSkillDao = Context.instanceUserSkillDao();
        UserDaoInter userDao = Context.instanceUserDao();
        EmploymentHistoryDaoInter  emp = Context.instanceEmploymentHistoryDao();
        CountryDaoInter country = Context.instanceCountryDao();
        SkillDaoInter skill = Context.instanceSkillDao();

        
        
        
    }

}

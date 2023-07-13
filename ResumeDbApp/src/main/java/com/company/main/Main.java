/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.*;
import com.company.entity.Country;
import com.company.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = null;
        try {
            birthdate = sdf.parse("1999-01-04");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        User u = new User(1, "Igrar","Muradov", "+994777555564",
                "igrar.muradov@gmail.com", "Java Enthuasist",
                "Baku",new java.sql.Date(birthdate.getTime()), new Country(2,null,null),
                new Country(1,null,null));

        System.out.println(userDao.getAll());
    }

}

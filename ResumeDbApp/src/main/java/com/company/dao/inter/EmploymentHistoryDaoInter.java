/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author Igrar
 */
public interface EmploymentHistoryDaoInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    
    public EmploymentHistory getEmploymentHistoryById(int id);
    
    public EmploymentHistory updateEmploymentHistoryById(int id);
    
    public EmploymentHistory addEmploymentHistory(int id);
    
    public boolean addEmploymentHistoryToUser(Skill s);
    
    public boolean removeEmploymentHistoryByIdFromUser(int id);
}

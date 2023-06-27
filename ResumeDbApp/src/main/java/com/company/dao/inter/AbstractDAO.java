/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.SneakyThrows;

/**
 *
 * @author Igrar
 */
public abstract class AbstractDAO {
    @SneakyThrows
    public Connection connect() {
        String url = "jdbc:mysql://localhost:3306/resume";
        String user = "root";
        String password = "12345";
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}

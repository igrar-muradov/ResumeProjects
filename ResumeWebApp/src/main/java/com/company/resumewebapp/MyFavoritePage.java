/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resumewebapp;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import com.company.main.Context;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igrar
 */
@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<User> users = userDao.getAll();

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyFavoritePage doGet request</h1>");
            for (User u : users) {
                out.println(u + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse response)
            throws ServletException, IOException {

//        String name = String.valueOf(req.getAttribute("name"));
//        String surname = String.valueOf(req.getAttribute("surname"));
//        User u = new  User(0, name, surname, null, null, null, null, null, null, null);
//        boolean b = userDao.addUser(u);

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>I GOT POST REQUEST</h1>");
            out.print("User inserted: Test  <br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

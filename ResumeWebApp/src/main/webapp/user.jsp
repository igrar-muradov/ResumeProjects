<%-- 
    Document   : user
    Created on : Aug 1, 2023, 8:14:57 PM
    Author     : Igrar
--%>

<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();

//            if (request.getParameter("save") != null && request.getParameter("save").equals("Save")) {
//                int id = Integer.valueOf(request.getParameter("id"));
//                String name = request.getParameter("name");
//                String surname = request.getParameter("surname");
//
//                System.out.println("name = " + name);
//                System.out.println("surname = " + surname);
//
//                User user = userDao.getById(id);
//                user.setName(name);
//                user.setSurname(surname);
//
//                userDao.updateUser(user);
//            }
            User u = userDao.getById(6);

        %>

        <div>
            <form action="UserController" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>">
                <label for="name">name</label>
                <input type="text" name="name" value="<%=u.getName()%>" /> 
                <br><br>
                <label for="surname">surname</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>" /> 
                <br><br>
                <label for="phone">phone</label>
                <input type="text" name="phone" value="<%=u.getPhone()%>" /> 
                <br><br>
                <label for="email">email</label>
                <input type="text" name="email" value="<%=u.getEmail()%>" />
                <br><br>
                <label for="address">address</label>
                <input type="text" name="address" value="<%=u.getAddress()%>" /> 
                <br><br>
                <input type="submit" name="save" value="Save"/>
            </form>
        </div>
    </body>
</html>

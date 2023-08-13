<%-- 
    Document   : user
    Created on : Aug 1, 2023, 8:14:57 PM
    Author     : Igrar
--%>

<%@page import="com.company.main.Context" %>
<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        User u = (User) request.getAttribute("user");
    %>

    <div>
        <form action="userdetail" method="POST">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <label>name</label>
            <input type="text" name="name" value="<%=u.getName()%>"/>
            <br><br>
            <label>surname</label>
            <input type="text" name="surname" value="<%=u.getSurname()%>"/>
            <br><br>
            <label>phone</label>
            <input type="text" name="phone" value="<%=u.getPhone()%>"/>
            <br><br>
            <label>email</label>
            <input type="text" name="email" value="<%=u.getEmail()%>"/>
            <br><br>
            <label>address</label>
            <input type="text" name="address" value="<%=u.getAddress()%>"/>
            <br><br>
            <input type="submit" name="save" value="Save"/>
        </form>
    </div>
    </body>
</html>

<%-- 
    Document   : user
    Created on : Aug 1, 2023, 8:14:57 PM
    Author     : Igrar
--%>

<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.main.Context" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/users.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nationalityIdStr = request.getParameter("nid");

    Integer nationalityId = null;
    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }
    List<User> list = userDao.getAll(name, surname, nationalityId);

%>
<div class="container">
    <div class="raw">
        <div class="col-4">
        <form action="users.jsp" method="GET">
            <div class="form-group">
                <label>Name:</label>
                <input placeholder="Enter name" class="form-control" name="name" value=""/>
            </div>
            <div class="form-group">
                <label>Surname:</label>
                <input placeholder="Enter surname" class="form-control" type="text" name="surname" value=""/>
            </div>
            <input class="btn btn-primary" type="submit" name="search" value="Search"/>
        </form>
    </div>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>nationality</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (User u : list) {
        %>
        <tr>
            <td><%=u.getName()%>
            </td>
            <td><%=u.getSurname()%>
            </td>
            <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%>
            </td>
            <td>
                <button class="btn btn-danger" type="submit" value="delete" name="action">
                    <i class="btn_table fa fa-trash-o"></i>
                </button>
                <button class="btn btn-secondary" type="submit" value="update" name="action">
                    <i class="fa fa-pencil"></i>
                </button>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</div>
</body>
</html>

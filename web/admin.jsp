<%-- 
    Document   : admin
    Created on : Jun 7, 2022, 11:44:01 AM
    Author     : phuth
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="ThangTP.reg.RegDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome Admin ${sessionScope.LOGIN_USER.fullname}</h1>
        <form action="MainServlet" >
        <input type="submit" name="BTACTION" value="Logout"/>
        </form>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    session = request.getSession(false);//bcaz we can't create session second time
    String username = null;

    if(session != null) {
        username = (String) session.getAttribute("username");
    }

    if(username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<center>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= username %>!</h2>
</body>
</center>
</html>

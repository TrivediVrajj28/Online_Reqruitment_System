<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Jobseeker List</title>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.dao.jobseekerdao,com.pojo.jobseeker.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
<h2>All Registered Jobseekers</h2>
<table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Edit Reord</th>
            <th>Delete Reord</th>
        </tr>
        
        <c:forEach var="j" items="${list}">
            <tr>
                <td>${j.id}</td>
                <td>${j.name}</td>
                <td>${j.email}</td>
                <td>${j.password}</td>
                <td><a href="edit.jsp?id=${j.id}">Edit</a>
                <td><a href="DeleteServlet?id=${j.id}"
           onclick="return confirm('Are you sure you want to delete this record?');">
           Delete
        </a>
                </td>
                
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
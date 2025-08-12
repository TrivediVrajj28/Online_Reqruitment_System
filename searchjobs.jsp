<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<br>
<h2>Search Jobs</h2>
<br>
<form action="SearchServlet" method="get">
    <input type="text" name="keyword" placeholder="Enter job title or company">
    <input type="submit" value="Search">
</form>

<hr>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Company</th>
        <th>Location</th>
    </tr>
    <c:forEach var="j" items="${list}">
        <tr>
            <td>${j.title}</td>
            <td>${j.company}</td>
            <td>${j.location}</td>
        </tr>
    </c:forEach>
</table>
</center>
</body>
</html>
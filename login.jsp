<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <center>
    
        <h2>Jobseeker Login</h2>
        
        <form action="LoginServlet" method="post">
            <label>Email:</label>
            <input type="text" name="email" required><br><br>

            <label>Password:</label>
            <input type="password" name="password" required><br><br>

            <input type="submit" value="Login">
            
        </form>

        <%
            String msg = (String) request.getAttribute("msg");//msg come from servlet
            if (msg != null) {
        %>
            <p style="color:red;"><%= msg %></p>
        <% } %>
    </center>
</body>
</html>

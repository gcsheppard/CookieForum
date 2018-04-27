<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/CookieForum/styles/styles.css">
    </head>
    <body>
        <h1><c:out value = "${flash}"/></h1>
        
        <h2>Register:</h2>
        <form action="register" method="post">
            <div class="b"><input type="text" name="username" value="${user.username}" placeholder="Username"}></div><br>
            <div class="b"><input type="password" size="30" name="password" placeholder="Password"></div><br>
            <div class="b"><input type="text" size="50" name="name" value="${user.name}" placeholder="Name"></div><br>
            <div class="b"><input type="text" size="50" name="email" value="${user.email}" placeholder="Email"></div><br>
            <div class="c"><input type="submit" value="Submit" /><br>
        </form>  
        <br><div class="e">${errors}</div>
    </body>
</html>
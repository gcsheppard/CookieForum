<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/CookieForum/styles/styles.css">
    </head>
    <body>
        <h1><c:out value = "${flash}"/></h1>
        
        <h2>Login:</h2>
        <form action="login" method="post">
            <div class="b"><input type="text" name="username" placeholder="Username"}></div><br>
            <div class="b"><input type="password" name="password" placeholder="Password"></div><br>
            <div class="c"><input type="submit" value="Submit" /><br>
        </form>  
        
        <br><br><div class="b">or <a href="/CookieForum/register">Register</a> if you haven't done so yet.</div><br>
    </body>
</html>

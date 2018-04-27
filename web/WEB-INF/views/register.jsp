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
        <form action="login" method="post">
            <div class="b"><input type="text" name="username" placeholder="Username"}></div><br>
            <div class="b"><input type="password" size="30" name="password1" placeholder="Password"></div><br>
            <div class="b"><input type="password" size="30" name="password2" placeholder="Confirm Password"></div><br>
            <div class="b"><input type="text" size="50" name="name" placeholder="Name"></div><br>
            <div class="b"><input type="text" size="50" name="email" placeholder="Email"></div><br>
            <div class="c"><input type="submit" value="Submit" /><br>
        </form>  
        
    </body>
</html>
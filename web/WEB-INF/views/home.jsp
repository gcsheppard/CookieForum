<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/CookieForum/styles/styles.css">
    </head>
    <body>
        <h1>Welcome to the Cookie Forum!<br>
        The place to discuss all things cookie!</h1>
        
        <c:choose>
            <c:when test = "${user == null}">
                <h2>Our website is under development.<br>
                Please login to see some of our planned topics.</h2>
                <br><br><div class="d"><a href="/CookieForum/login">Login</a></div><br>
            </c:when>
            <c:otherwise>
                <h2>Hello ${user.name}!<br>
                Some of our planned topics:</h2>
                <div class="g">
                <ul>
                    <c:forEach var="topic" items="${topics}">
                    <li>${topic}</li>
                    </c:forEach>
                </ul>
                </div>    
                <br><div class="d"><a href="/CookieForum/logout">Logout</a></div><br>
            </c:otherwise>
        </c:choose>

    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/CookieForum/styles/styles.css">
    </head>
    <body>
        <img src="images/chocolatechip.jpg" alt="" width="100">
        <img src="images/christmas.jpg" alt="" width="100">
        <img src="images/macaroons.jpg" alt="" width="100">
        <img src="images/molasses.jpg" alt="" width="100">
        <img src="images/nut.jpg" alt="" width="100">
        <img src="images/peanutbutter.jpg" alt="" width="100">
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

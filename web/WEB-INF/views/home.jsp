<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the Cookie Forum!</h1>
        
        <c:choose>
            <c:when test = "${user == null}">
                <br><div class="d"><a href="/CookieForum/login">Login</a></div><br>
            </c:when>
            <c:otherwise>
                <br><div class="d"><a href="/CookieForum/logout">Logout</a></div><br>
            </c:otherwise>
        </c:choose>

    </body>
</html>

<%-- 
    Document   : KlantHome
    Created on : Jun 16, 2015, 7:48:20 PM
    Author     : Max
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="content">
        <h1>Welkom bij ATD</h1>
        <p>
            
        </p>
        <div class="homepageKlantInfo">
            U heeft
        <c:choose>
            <c:when test="${autos.size() == 1}">
                1 auto
            </c:when>
            <c:otherwise>
                ${autos.size()} auto's
            </c:otherwise>
        </c:choose>
                geregistreerd bij ATD</br>
        <c:forEach var="a" items="${autos}">
            Kenteken: ${a.kenteken} Merk: ${a.merk} Type: ${a.naam} </br>
        </c:forEach>
        </br>
        U heeft nog
        <c:choose>
            <c:when test="${klantenfacturen.size() == 1}">
                1 factuur
            </c:when>
            <c:otherwise>
                ${klantenfacturen.size()} facturen
            </c:otherwise>
        </c:choose>
        open staan bij ATD
        <c:forEach var="factuur" items="${klantenfacturen}">

        </c:forEach>
        </div>
    </body>
</html>

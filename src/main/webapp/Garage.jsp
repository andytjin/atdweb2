<%-- 
    Document   : Garage
    Created on : Jun 15, 2015, 12:49:51 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/Headers/klantheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <form action="GarageServlet" method="post">
        Voor hoeveel uur wilt u een parkeerplek reserveren:</br>
        <input type="number" name="aantaluur"></br>

        <input type="submit" name="button" value="Reserveer">
    </form>
    ${msgs}</br>
    <c:forEach var="i" begin="1" end="5">
        <c:choose>
            <c:when test="${i < bezettePlaatsen}">
                | x 
            </c:when>
            <c:otherwise>
                | o
            </c:otherwise>
        </c:choose> 
    </c:forEach>
    </br>

    <c:forEach var="i" begin="6" end="10">
        <c:choose>
            <c:when test="${i < bezettePlaatsen}">
                | x
            </c:when>
            <c:otherwise>
                | o
            </c:otherwise>    
        </c:choose>
    </c:forEach>
    </br>
    <c:forEach var="i" begin="11" end="15">
        <c:choose>
            <c:when test="${i < bezettePlaatsen}">
                | x
            </c:when>
            <c:otherwise>
                | o
            </c:otherwise>    
        </c:choose>
    </c:forEach>
    </br>
    <c:forEach var="i" begin="16" end="20">
        <c:choose>
            <c:when test="${i < bezettePlaatsen}">
                | x
            </c:when>
            <c:otherwise>
                | o
            </c:otherwise>    
        </c:choose>
    </c:forEach>
    </br>
    <c:forEach var="i" begin="21" end="25">
        <c:choose>
            <c:when test="${i < bezettePlaatsen}">
                | x
            </c:when>
            <c:otherwise>
                | o
            </c:otherwise>    
        </c:choose>
    </c:forEach>


</head>
<body>

</body>
</html>

<%-- 
    Document   : Garage
    Created on : Jun 15, 2015, 12:49:51 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" type="text/css" href="MaxStyle.css" />
    <form action="GarageServlet" method="post">
        Voor hoeveel uur wilt u een parkeerplek reserveren:</br>
        <input type="number" name="aantaluur"></br>

        <input type="submit" name="button" value="Reserveer">
    </form>
    ${msgs}</br>
    </br>
    <div class="parkeerplaats">
        <c:forEach var="i" begin="1" end="5">
            <c:choose>
                <c:when test="${i < bezettePlaatsen}">
                    <img src="Images/bezetteplaats.jpg" alt="bezet" title="Sectie A"/>
                </c:when>
                <c:otherwise>
                    <img src="Images/legeplaats.jpg" alt="leeg" title="Sectie A"/>
                </c:otherwise>
            </c:choose> 
        </c:forEach>
        </br>
        </br>
        </br>
        <c:forEach var="i" begin="6" end="10">
            <c:choose>
                <c:when test="${i < bezettePlaatsen}">
                    <img src="Images/bezetteplaats.jpg" alt="bezet" title="Sectie B"/>
                </c:when>
                <c:otherwise>
                    <img src="Images/legeplaats.jpg" alt="leeg" title="Sectie B"/>
                </c:otherwise>    
            </c:choose>
        </c:forEach>
        </br>
        <c:forEach var="i" begin="11" end="15">
            <c:choose>
                <c:when test="${i < bezettePlaatsen}">
                    <img src="Images/bezetteplaats.jpg" alt="bezet" title="Sectie C"/>
                </c:when>
                <c:otherwise>
                    <img src="Images/legeplaats.jpg" alt="leeg" title="Sectie C"/>
                </c:otherwise>    
            </c:choose>
        </c:forEach>
        </br>
        </br>
        </br>
        <c:forEach var="i" begin="16" end="20">
            <c:choose>
                <c:when test="${i < bezettePlaatsen}">
                    <img src="Images/bezetteplaats.jpg" alt="bezet" title="Sectie D"/>
                </c:when>
                <c:otherwise>
                    <img src="Images/legeplaats.jpg" alt="leeg" title="Sectie D"/>
                </c:otherwise>    
            </c:choose>
        </c:forEach>
        </br>
        <div class="GarageVakE">
            <c:forEach var="i" begin="21" end="25">
                <c:choose>
                    <c:when test="${i < bezettePlaatsen}">
                        <img src="Images/bezetteplaats2.jpg" alt="bezet" title="Sectie E"/></br>
                    </c:when>
                    <c:otherwise>
                        <img src="Images/legeplaats2.jpg" alt="leeg" title="Sectie E"/></br>
                    </c:otherwise>    
                </c:choose>
            </c:forEach>
        </div>
    </div>

</head>
<body>

</body>
</html>

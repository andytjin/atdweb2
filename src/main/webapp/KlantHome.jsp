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

        <div class="homepageATDinfo">
            <h1>Welkom bij ATD</h1>
            <p>
                Het bedrijf Auto Totaal Diensten(ATD) biedt drie verschillende auto-gerelateerde 
                diensten. </br>
                </br>
                Als eerste kunt u bij ATD uw auto laten repareren. Hiervoor moet 
                er wel een auto aan uw account gekoppeld zijn (Dit kunt u doen bij het kopje "Mijn Account")
                </br>
                </br>
                Daarnaast kunt u ook uw auto parkeren in de garage van ATD. Dit kunt u doen 
                door op de knop "Garage" te klikken. Daar kunt u de uren instellen voor hoelang
                u een parkeer plek wilt reserveren.
                </br>
                </br>
                Tot slot kunt u ook bij ATD tanken. Hiervoor hoeft u niks online te doen
                en kan u gewoon langs komen bij ATD zelf.
            </p>
        </div>
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

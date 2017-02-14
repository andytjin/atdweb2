<%-- 
    Document   : WerkzaamhedenOverzicht
    Created on : 16-jun-2015, 17:56:59
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Werkzaamheden Overzicht</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div class="tabelDivWO">
            <h1>Onderhoudsbeurten</h1>
            <table id="tabel">
                <tr class="head">
                    <th>Onderhoudsid</th>
                    <th>datum</th>
                    <th>Aantal Bestede Uur</th>
                    <th>Kenteken</th>
                    <th>MonteurID</th>
                    <th>Status</th>

                </tr>


                <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
                    <tr class="info">
                        <td><c:out value="${Onderhoudsbeurt.dienstNummer}" /></td>
                        <td><c:out value="${Onderhoudsbeurt.calendarNaarString}" /></td>
                        <td><c:out value="${Onderhoudsbeurt.aantalBestedeUur}" /></td>
                        <td><c:out value="${Onderhoudsbeurt.deAuto.kenteken}" /></td>
                        <td><c:out value="${Onderhoudsbeurt.deMonteur.ID}" /></td>
                        <td><c:out value="${Onderhoudsbeurt.status}" /></td>
                    </tr>
                </c:forEach>


            </table> 

            <h1>Gebruikte artikelen</h1>
            <table id="tabel">
                <tr class="head">
                    <th>Onderhoudsid</th>
                    <th>ArtikelID:</th>
                    <th>Aantal Gebruikt</th>
                    <th>GebruikteArtikelID</th>


                </tr>


                <c:forEach var="GebruikteArtikelen" items="${gebruikteartikelen}">
                    <tr class="info">
                        <td><c:out value="${GebruikteArtikelen.onderhoudsBeurtId}" /></td>
                        <td><c:out value="${GebruikteArtikelen.hetArtikel.code}" /></td>
                        <td><c:out value="${GebruikteArtikelen.aantal}" /></td>
                        <td><c:out value="${GebruikteArtikelen.gebruikteArtikelId}" /></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

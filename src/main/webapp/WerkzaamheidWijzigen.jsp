<%-- 
    Document   : WerkzaamheidToevoegen
    Created on : 11-mei-2015, 18:29:44
    Author     : andy
--%>
<%@page import="Domain.Artikel"%>
<jsp:include page="Headers/monteurheader.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="Script.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Werkzaamheid Wijzigen</title>
    </head>
    <body>
        <div id="mainWT">
            <form action="WerkzaamheidWijzigen" method="post">
                <table>
                    <tr>
                        <td><label>Selecteer OnderhoudsbeurtID</label></td>
                        <td><select name="onderhoudsbeurtID" id="onderhoudsbeurtID" onchange="fillOnderhoudsbeurt()">
                                <option>Selecteer OnderhoudsbeurtID</option>
                                <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
                                    <option value="${Onderhoudsbeurt.dienstNummer},${Onderhoudsbeurt.calendarNaarString},${Onderhoudsbeurt.deAuto.kenteken},${Onderhoudsbeurt.deMonteur.ID},${Onderhoudsbeurt.aantalBestedeUur},${Onderhoudsbeurt.status}">${Onderhoudsbeurt.dienstNummer}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Huidige Datum:</label></td>
                        <td><input type="text" name="datum" id="datum"><br/></td>
                    </tr>
                    <tr>
                        <td><label>Datum Wijzigen:</label></td>
                        <td><input type="date" name="wijzigDatum"><br/></td>
                    </tr>
                    <tr>
                        <td><label>aantal besteden uur:</label></td>
                        <td><input type="text" name="uur" id="uur"><br/></td>
                    </tr>
                    <tr>
                        <td><label>Auto ID:</label></td>
                        <td><select name="auto" id="auto">
                                <c:forEach var="Auto" items="${auto}">
                                    <option>Selecteer Kenteken</option>
                                    <option value="${Auto.kenteken}">${Auto.kenteken}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Monteur: ID</label></td>
                        <td><select name="monteur" id="monteur">
                                <c:forEach var="Monteur" items="${monteur}">
                                    <option>Selecteer MonteurID</option>
                                    <option value="${Monteur.ID}">${Monteur.ID}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Status</label></td>
                        <td><select name="status" id="status" >
                                <option>Selecteer Status</option>
                                <option value="In-onderhoud">In-onderhoud</option>
                                <option value="Gerepareerd">Gerepareerd</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button name="knop" value="Terug" type="submit">
                                Terug
                            </button>
                            <button name="knop" value="Opslaan" type="submit">
                                Opslaan
                            </button></td>
                    <tr>
                </table>
            </form>
        </div>
        <div id="mainWT3">
            <jsp:include page="/GebruikteArtikelWijzigen.jsp"/>
        </div>
    </body>
</html>

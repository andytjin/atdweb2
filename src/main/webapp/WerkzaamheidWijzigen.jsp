<%-- 
    Document   : WerkzaamheidToevoegen
    Created on : 11-mei-2015, 18:29:44
    Author     : andy
--%>
<%@page import="Domain.Artikel"%>
<jsp:include page="/Headers/monteurheader.jsp"/>
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
        <form action="WerkzaamheidWijzigen" method="post"> 
            <label>Selecteer OnderhoudsbeurtID</label>
            <select name="onderhoudsbeurtID" id="onderhoudsbeurtID" onchange="fillOnderhoudsbeurt()">
                <option disabled Selected>Selecteer OnderhoudsbeurtID</option>
                <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
                 <option value="${Onderhoudsbeurt.dienstNummer},${Onderhoudsbeurt.calendarNaarString},${Onderhoudsbeurt.deAuto.kenteken},${Onderhoudsbeurt.deMonteur.ID},${Onderhoudsbeurt.aantalBestedeUur}">${Onderhoudsbeurt.dienstNummer}</option>
                </c:forEach>
            </select>
            <label>Huidige Datum:</label>
            <input type="text" name="datum" id="datum"><br/>
            <label>Datum Wijzigen:</label>
            <input type="date" name="wijzigDatum"><br/>
            <label>aantal besteden uur:</label>
            <input type="text" name="uur" id="uur"><br/>
            <label>Auto ID:</label>
            <select name="auto" id="auto">
                <c:forEach var="Auto" items="${auto}">
                    <option disabled Selected>Selecteer Kenteken</option>
                    <option value="${Auto.kenteken}">${Auto.kenteken}</option>
                </c:forEach>
            </select>

            <label>Monteur: ID</label>
            <select name="monteur" id="monteur">
                <c:forEach var="Monteur" items="${monteur}">
                    <option disabled Selected>Selecteer MonteurID</option>
                    <option value="${Monteur.ID}">${Monteur.ID}</option>
                </c:forEach>
            </select>
            <button name="knop" value="Terug" type="submit">
                Terug
            </button>
            <button name="knop" value="Opslaan" type="submit">
                Opslaan
            </button>
        </form>
        <jsp:include page="/GebruikteArtikelWijzigen.jsp"/>
    </body>
</html>

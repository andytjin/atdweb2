<%-- 
    Document   : WerkzaamheidVerwijderen
    Created on : 11-mei-2015, 18:30:23
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
        <title>Werkzaamheid Verwijderen</title>
    </head>
    <body>
        <form action="WerkzaamheidVerwijderen" method="post"> 
            <label>Selecteer OnderhoudsbeurtID</label>
            <select name="onderhoudsbeurtID" id="onderhoudsbeurtID" onchange="fillOnderhoudsbeurt()">
                <option disabled Selected>Selecteer OnderhoudsbeurtID</option>
                <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
                 <option value="${Onderhoudsbeurt.dienstNummer},${Onderhoudsbeurt.calendarNaarString},${Onderhoudsbeurt.deAuto.kenteken},${Onderhoudsbeurt.deMonteur.ID},${Onderhoudsbeurt.aantalBestedeUur}">${Onderhoudsbeurt.dienstNummer}</option>
                </c:forEach>
            </select>
            <label>Huidige Datum:</label>
            <input type="text" name="datum" id="datum" readonly><br/>
            
            <label>aantal besteden uur:</label>
            <input type="text" name="uur" id="uur" readonly><br/>
            <label>Auto ID:</label>
            <input type="text" name="auto" id="auto" readonly>
            <label>Monteur: ID</label>
            <input type="text" name="monteur" id="monteur" readonly>
            <button name="knop" value="Terug" type="submit">
                Terug
            </button>
            <button name="knop" value="Verwijder" type="submit">
               Verwijder
            </button>
        </form>
        
    </body>
</html>

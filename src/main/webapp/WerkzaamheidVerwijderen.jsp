<%-- 
    Document   : WerkzaamheidVerwijderen
    Created on : 11-mei-2015, 18:30:23
    Author     : andy
--%>

<%@page import="Domain.Artikel"%>
<jsp:include page="Headers/monteurheader.jsp"/>
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
        <div class="tabelDivWO2" >
            <form action="WerkzaamheidVerwijderen" method="post"> 
                <table id="tabel">
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
                        <td><input type="text" name="datum" id="datum" readonly><br/></td>
                    </tr>
                    <tr>
                        <td><label>aantal besteden uur:</label></td>
                        <td><input type="text" name="uur" id="uur" readonly><br/></td>
                    </tr>
                    <tr>
                        <td><label>Auto ID:</label></td>
                        <td><input type="text" name="auto" id="auto" readonly></td>
                    </tr>
                    <tr>
                        <td><label>Monteur: ID</label></td>
                        <td><input type="text" name="monteur" id="monteur" readonly></td>
                    </tr>
                    <tr>
                        <td><label>Status:</label></td>
                        <td><input type="text" name="status" id="status" readonly></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button name="knop" value="Terug" type="submit">
                                Terug
                            </button>
                            <button name="knop" value="Verwijder" type="submit">
                                Verwijder
                            </button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

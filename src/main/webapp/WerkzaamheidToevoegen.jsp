<%-- 
    Document   : WerkzaamheidToevoegen
    Created on : 11-mei-2015, 18:29:44
    Author     : andy
--%>
<%@page import="Domain.Artikel"%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Werkzaamheid toevoegen</title>
    </head>
    <body>
        
        <form action="WerkzaamheidToevoegen" method="post">    
        <label>onderhoudsbeurt ID:</label>
        <input type="text" name="werkzaamheid"><br/>
        <label>Datum:</label>
        <input type="text" name="datum"><br/>
        <label>NettoPrijs:</label>
        <input type="text" name="prijs"><br/>
        <label>aantal besteden uur:</label>
        <input type="text" name="uur"><br/>
        <label>Auto ID:</label>
        <select name="auto" id="auto">
            <c:forEach var="Auto" items="${auto}">
             <option value="${Auto.kenteken}">${Auto.kenteken}</option>
            </c:forEach>
        </select>
       
        <label>Monteur: ID</label>
        <select name="monteur" id="monteur">
            <c:forEach var="Monteur" items="${monteur}">
             <option value="${Monteur.ID}">${Monteur.ID}</option>
            </c:forEach>
        </select>
        
        
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button>
        </form>
        <jsp:include page="/GebruikteArtikelToevoegen.jsp"/>
    </body>
</html>

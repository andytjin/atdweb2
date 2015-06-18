<%-- 
    Document   : GebruikteArtikelToevoegen
    Created on : 1-jun-2015, 13:50:14
    Author     : andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="Script.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GebruikteArtikelWijzigen" method="post">
        <label>GebruikteArtikelenID</label>
        
        <select name="gebruikteartikelen" id="gebruikteartikelen" onchange="fillGebruikteArtikelen()">
            <option disabled Selected>Selecteer GebruikteArtikelID</option>
            <c:forEach var="GebruikteArtikelen" items="${gebruikteartikelen}">
             <option value="${GebruikteArtikelen.gebruikteArtikelId},${GebruikteArtikelen.onderhoudsBeurtId},${GebruikteArtikelen.hetArtikel.code},${GebruikteArtikelen.aantal}">${GebruikteArtikelen.gebruikteArtikelId}</option>
            </c:forEach>
        </select>
            
        <label>OnderhoudsbeurtID</label>
        <select name="onderhoudsbeurt" id="onderhoudsbeurt">
            <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
             <option value="${Onderhoudsbeurt.dienstNummer}">${Onderhoudsbeurt.dienstNummer}</option>
            </c:forEach>
        </select>
        <label>ArtikelID:</label>
        <select name="artikel" id="artikel">
            <c:forEach var="Artikel" items="${artikel}">
             <option value="${Artikel.code}">${Artikel.code}</option>
            </c:forEach>
        </select>
        <label>aantal Gebruikte artikelen:</label>
        <input type="text" name="ga" id="ga"><br/>
        <button name="knop" value="Opslaan" type="submit">
                Opslaan
        </button>
        </form>
    </body>
</html>

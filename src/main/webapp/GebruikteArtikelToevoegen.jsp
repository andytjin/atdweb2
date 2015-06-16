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
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GebruikteArtikelToevoegen" method="post">
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
        <input type="text" name="ga"><br/>
        <button name="knop" value="voeg toe" type="submit">
                voeg toe
        </button>
        <label>Toegevoegde gebruikte artikelen</label> 
        <table>
            <c:forEach var="GebruikteArtikelen" items="${gaLijst}">
                <tr>
               <td>ArtikelCode:<c:out value="${GebruikteArtikelen.hetArtikel.code}"/></td>
               <td>aantal:<c:out value="${GebruikteArtikelen.aantal}"/></td>
                </tr>
           </c:forEach>
        </table>
        </form>
    </body>
</html>

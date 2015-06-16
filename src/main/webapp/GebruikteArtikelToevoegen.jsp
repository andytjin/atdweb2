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
            <table>
                <tr>
                    <td><label>OnderhoudsbeurtID</label></td>
                    <td><select name="onderhoudsbeurt" id="onderhoudsbeurt">
                            <c:forEach var="Onderhoudsbeurt" items="${onderhoudsbeurt}">
                                <option value="${Onderhoudsbeurt.dienstNummer}">${Onderhoudsbeurt.dienstNummer}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>ArtikelID:</label></td>
                    <td><select name="artikel" id="artikel">
                            <c:forEach var="Artikel" items="${artikel}">
                                <option value="${Artikel.code}">${Artikel.code}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td><label>aantal Gebruikte artikelen:</label></td>
                    <td><input type="text" name="ga"><br/></td>
                    <td><button name="knop" value="voeg toe" type="submit">
                    voeg toe
                        </button></td>
                </tr>
                <tr>
                    <td><label>Toegevoegde gebruikte artikelen</label> </td>

                <td><c:forEach var="GebruikteArtikelen" items="${gaLijst}">

                    ArtikelCode:<c:out value="${GebruikteArtikelen.hetArtikel.code}"/>
                    aantal:<c:out value="${GebruikteArtikelen.aantal}"/>

                    </c:forEach></td>
                </tr>
            </table>
        </form>
    </body>
</html>

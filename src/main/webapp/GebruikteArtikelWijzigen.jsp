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
            <table>
                <tr>
                    <td><label>GebruikteArtikelenID</label></td>

                    <td> <select name="gebruikteartikelen" id="gebruikteartikelen" onchange="fillGebruikteArtikelen()">
                            <option disabled Selected>Selecteer GebruikteArtikelID</option>
                            <c:forEach var="GebruikteArtikelen" items="${gebruikteartikelen}">
                                <option value="${GebruikteArtikelen.gebruikteArtikelId},${GebruikteArtikelen.onderhoudsBeurtId},${GebruikteArtikelen.hetArtikel.code},${GebruikteArtikelen.aantal}">${GebruikteArtikelen.gebruikteArtikelId}</option>
                            </c:forEach>
                        </select></td>
                </tr>
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
                    <td><input type="text" name="ga" id="ga"><br/></td>                    
                </tr>
                <tr>
                    <td></td>
                    <td><button name="knop" value="Opslaan" type="submit">
                            Opslaan
                        </button></td>
                </tr>
            </table>
        </form>
    </body>
</html>

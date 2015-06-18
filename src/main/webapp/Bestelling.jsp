<%-- 
    Document   : Bestellen
    Created on : 17-jun-2015, 17:36:50
    Author     : freekvdp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestellen</title>
    </head>
    <body>
        <h1>Bestel Artikelen</h1>

        <form action="BestellingServlet" method="post">
            <input type="submit" name ="knop" value="Bestel!">
        </form>
        <div>
            <div>
                <table>
                    <tr><th>Te Bestellen</th></tr>

                    <tr><th>Artikelnaam</th><th>aantal aanwezig</th><th>minimum artikel</tr>
                </table>
                <c:forEach var="Artikel" items="${teBestellen}">
                    <form action="VerwijderVanLijstServlet" method="post">
                        <table>
                            <tr><td>${Artikel.type}</td><td>${(Artikel.aantal)}</td><td>${Artikel.minimum}</td>
                                <td><input type="submit" name="button" value="verwijder"></td>
                                <td><input type="hidden" name="Artikelcode" value="${Artikel.code}"></td>
                            </tr>
                        </table>
                    </form>     
                </c:forEach>
            </div>
            <div>
                <table>
                    <tr><th>Bijna te Bestellen</th></tr>
                    <tr><th>Artikelnaam</th><th>aantal aanwezig</th><th>minimum artikel</tr>
                </table>
                <c:forEach var="Artikel" items="${bijnaBestellen}">
                    <form action="NaarBestelLijstServlet" method="post">
                        <table>
                            <tr><td>${Artikel.type}</td><td>${(Artikel.aantal)}</td><td>${Artikel.minimum}</td>
                                <td><input type="submit" name="${Artikel.code}" value="Naar Bestellijst"></td>
                            <td><input type="hidden" name="Artikelcode" value="${Artikel.code}"></td>
                            </tr>
                        </table>
                    </form>
                </c:forEach>
            </div>
            <div>
                <table>
                    <tr><th>Besteld:</th></tr>

                    <tr><th>Artikelnaam</th><th>aantal aanwezig</th><th>minimum artikel</tr>
                </table>
                <c:forEach var="Artikel" items="${besteldeLijst}">
                        <table>
                            <tr><td>${Artikel.type}</td><td>${(Artikel.aantal)}</td><td>${Artikel.minimum}</td>
                            </tr>
                        </table>     
                </c:forEach>
                Totaalprijs = ${totaalprijs}
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : Bestellen
    Created on : 17-jun-2015, 17:36:50
    Author     : freekvdp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="AdminPage.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestellen</title>
    </head>
    <body>




        <div class="tabelDivWO2"> 
            <h1>Bestel Artikelen</h1>
            <form action="BestellingServlet" method="post">
                <input type="submit" name ="knop" value="Bestel!">
            </form>
            <div>
                <div>
                    <table>
                        <tr><td>Te Bestellen</td></tr>

                        <tr style="font-weight: bold;"><td>Artikelnaam</td><td>aantal aanwezig</td><td>minimum artikel</td></tr>

                        <c:forEach var="Artikel" items="${teBestellen}">
                            <form action="VerwijderVanLijstServlet" method="post">
                                <tr>
                                    <td>${Artikel.type}</td><td>${(Artikel.aantal)}</td><td>${Artikel.minimum}</td>
                                    <td><input type="submit" name="button" value="verwijder"></td>
                                    <td><input type="hidden" name="Artikelcode" value="${Artikel.code}"></td>
                                </tr>

                            </form>     
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <table>
                        <tr><th>Bijna te Bestellen</th></tr>
                        <tr style="font-weight: bold;"><td>Artikelnaam</td><td>aantal aanwezig</td><td>minimum artikel</td></tr>
                        <c:forEach var="Artikel" items="${bijnaBestellen}">
                            <form action="NaarBestelLijstServlet" method="post">

                                <tr><td>${Artikel.type}</td><td>${(Artikel.aantal)}</td><td>${Artikel.minimum}</td>
                                    <td><input type="submit" name="${Artikel.code}" value="Naar Bestellijst"></td>
                                    <td><input type="hidden" name="Artikelcode" value="${Artikel.code}"></td>
                                </tr>

                            </form>
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <table>
                        <tr><th>Besteld:</th></tr>

                        <tr style="font-weight: bold;"><td>Artikelnaam</td><td>aantal aanwezig</td><td>minimum artikel</td></tr>

                        <c:forEach var="Artikel" items="${besteldeLijst}">

                            <tr>
                                <td>${Artikel.type}</td>
                                <td>${(Artikel.aantal)}</td>
                                <td>${Artikel.minimum}</td>
                            </tr>

                        </c:forEach>
                    </table>     
                    Totaalprijs = ${totaalprijs}
                </div>
            </div>
        </div>
    </body>
</html>

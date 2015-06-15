<%@page import="java.util.List"%>
<%@page import="Service.FactuurService"%>
<%@page import="Service.ServiceProvider"%>
<%@page import="Domain.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="AdminPage.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Factuur</title>
    </head>
    <body>
        <div class="main">
            <form action="ZoekKlantServlet" method="post">
                <table>
                    <tr>
                        <td>Klantnaam:</td>
                        <td>
                            <select name="klant" id="klant">
                                <c:forEach var="Klant" items="${klanten}">                                    
                                    <option value="${Klant.username}">${Klant.username}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input type="submit" name="button" value="Zoek factuur"></td>
                    </tr>
                </table>    
                <c:forEach var="factuur" items="${klantFactuur}">
                    <table>
                        <tr style="background-color:#ffffff; font-weight: bold;">
                            <td>Factuurnummer</td>
                            <td>Factuurdatum</td>
                            <td>Vervaldatum</td>
                        </tr>
                        <tr style="background-color:#33ccff;">
                            <td>${factuur.factuurNummer}</td>
                            <td>${factuur.factuurDatum}</td>
                            <td>${factuur.vervalDatum}</td>
                        </tr>
                        <tr style="background-color:#ffffff; font-weight: bold;">
                            <td>Brutoprijs</td>
                            <td>Betaald?</td>
                        </tr>
                        <tr style="background-color:#33ccff;">
                            <td>${factuur.brutoPrijs}</td>
                            <td>${factuur.isBetaald()}</td>
                        </tr>
                        <tr style="background-color:#ffffff; font-weight: bold;">
                            <td>Omschrijving</td>
                        </tr>
                        <tr style="background-color:#33ccff;">
                            <td>${factuur.omschrijving}</td>
                        </tr>
                        <tr style="background-color:#ffffff; font-weight: bold;">
                            <td>Klant</td>
                        </tr>
                        <tr style="background-color:#33ccff;">
                            <td>${factuur.getKlantNaam()}</td>

                        </tr>

                    </table>
                </c:forEach>
            </form>
        </div>

        <div id="alleFactures">
            <form action="ForwardServlet" method="post">
                <table>
                    <tr>
                        <td style="font-family: Arial; font-size: 2em; color: #ffffff">Alle facturen:</td>
                        <td><input type="submit" name="button" value="Alle Facturen"></td>
                    </tr>
                </table>
            </form>
        </div>
        <form action ="FactuurServlet" method="post">
            <div id ="factuuraanmaken">  
                <h1> Factuur aanmaken</h1>
                <table>
                    <tr>
                        <td>Factuurnummer:</td>
                        <td><input type="text" name="Factuurnummer"></td>
                    </tr>
                    <tr>
                        <td>Geparkeerde uren:</td>
                        <td><input type="text" name="parkeeruren"></td>
                    </tr>
                    <tr>
                        <td>Arbeidsuren:</td>
                        <td><input type="text" name="arbeidsuren"></td>
                    </tr>
                    <tr>
                        <td>Gebruikte artikelen:</td>
                        <td><select name="artikel" id="artikel">
                                <c:forEach var="Artikel" items="${artikel}">
                                    <option value="${Artikel.hetType}">${Artikel.hetType}</option>
                                </c:forEach>
                            </select></td>
                        <td><input type="text" name="hoeveelheid" size="4"></td>
                        <td><input type="submit" name="voegArtikelToe" value="Toevoegen"></td>
                    </tr>
                    <tr>
                        <td>Bereken prijs:</td>
                        <td><input type="submit" name="bereken" value="Bereken"></td>
                        <td><c:out value="${prijs}"/></td>
                    </tr>
                    <tr>
                        <td>Betaald:</td>
                        <td><input type="checkbox" name="Betaald"></td>
                    </tr>
                    <tr>
                        <td>Factuurdatum:</td>
                        <td><input type="date" name="Factuurdatum"></td>
                    </tr>                                 
                    <tr>
                        <td>Vervaldatum:</td>
                        <td><input type="date" name="Vervaldatum"></td>
                    </tr>
                    <tr>
                        <td>Omschrijving</td>
                        <td><input type ="text" size="20" maxlength="20" style="height: 150px;" name ="Omschrijving"> </td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Klant:</td>
                        <td><select name="Klantnaam" id="klant">
                                <c:forEach var="Klant" items="${klanten}">                                    
                                    <option value="${Klant.username}">${Klant.username}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Aanmaken:</td>
                        <td><input type="submit" name="button" value ="Aanmaken"></td>
                        <td>Reset:</td>
                        <td><input type="reset" name="Reset" value="Reset form" /></td>
                    </tr>
                </table>

                <div class ="errormessage">
                    <%                    if (request.getAttribute("msgs") != null) {
                            out.println(request.getAttribute("msgs"));
                        }
                    %>
                </div>
            </div>
        </form>
    </body>
</html>
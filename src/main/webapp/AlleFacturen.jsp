<%-- 
    Document   : AlleFacturen
    Created on : May 28, 2015, 12:55:12 PM
    Author     : Thijs
--%>

<%@page import="Domain.Factuur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Service.FactuurService"%>
<%@page import="Service.ServiceProvider"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="AdminPage.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturen</title>
    </head>
    <body>

        <div class="main">            
            <c:forEach var="factuur" items="${alleFacturen}">
                <form action="alleFacturenServlet" method="post">
                    <div class="spacing">
                        <table>
                            <tr style="color:#ffffff; font-size: 1em;">
                                <td>Factuurnummer</td>
                                <td>Factuurdatum</td>
                                <td>Klant</td>                                
                            </tr>
                            <tr>
                                <td>${factuur.factuurNummer}</td>
                                <td>${factuur.factuurDatum}</td>
                                <td>${factuur.getKlantNaam()}</td>     
                                <td><input type="hidden" name="id" value="${factuur.factuurNummer}" /></td>
                                <td><input type="submit" name="button" value="Open"/></td>                                
                            </tr>
                        </table>

                    </div>
                </form>
            </c:forEach>                
            <%-- <input type="text" name="fNummer">
             <input type="submit" name="button" value="Haal op"> --%>

        </div>
        <div id="main3">

            <table>
                <tr>
                    <td>Factuurnummer</td>
                    <td>Factuurdatum</td>
                    <td>Vervaldatum</td>
                </tr>
                <tr>
                    <td>${fact.factuurNummer}</td>
                    <td>${fact.factuurDatum}</td>
                    <td>${fact.vervalDatum}</td>
                </tr>
                <tr>
                    <td>Brutoprijs</td>
                    <td>Betaald?</td>
                </tr>
                <tr>
                    <td>${fact.brutoPrijs}</td>
                    <td>${fact.isBetaald()}</td>
                </tr>
                <tr>
                    <td>Omschrijving</td>
                </tr>
                <tr>
                    <td>${fact.omschrijving}</td>
                </tr>
                <tr>
                    <td>Klant</td>
                </tr>
                <tr>
                    <td>${fact.getKlantNaam()}</td>
                </tr>
            </table>

        </div>
    </body>
</html>

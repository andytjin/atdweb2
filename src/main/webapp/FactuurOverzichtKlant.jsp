<%@page import="Domain.Factuur"%>
<%@page import="java.util.List"%>
<%@page import="Service.FactuurService"%>
<%@page import="Service.ServiceProvider"%>
<%@page import="Domain.Klant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factuur</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <form action="/KlantPageServlet" method="post">
            <div id="main4">               

                <table id="tabel">
                    <tr class="head">
                        <td>Factuurnummer</td>
                        <td>Factuurdatum</td>
                        <td>Vervaldatum</td>
                        <td>Brutoprijs</td>
                        <td>Betaald?</td>
                        <td>Omschrijving</td>
                        <td>Klant</td>
                    </tr>
                    <c:forEach var="factuur" items="${klantenfacturen}">
                        <tr class="info">
                            <td>${factuur.factuurNummer}</td>
                            <td>${factuur.factuurDatum}</td>
                            <td>${factuur.vervalDatum}</td>
                            <td>${factuur.brutoPrijs}</td>
                            <td>${factuur.isBetaald()}</td>
                            <td>${factuur.omschrijving}</td>
                            <td>${factuur.getKlantNaam()}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </form>
    </body>
</html>

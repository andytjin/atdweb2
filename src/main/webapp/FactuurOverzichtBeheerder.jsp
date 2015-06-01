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
        <div id="main">
            
                <form action="ZoekKlantServlet" method="post">
                    
                    <table>
                        <tr>
                            <td>Klantnaam:</td>
                            <td><input type="text" name="klant" ></td>
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
                        <td>Alle facturen:</td>
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
                        <td>Brutoprijs: € </td>
                        <td><input type="text" name="Brutoprijs"></td>
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
                        <td><input type ="text" style="height: 150px; width: 150px;" name ="Omschrijving"> </td>
                    </tr>
                    <tr>
                        <td>Klantnaam:</td>
                        <td><input type="text" name="Klantnaam"></td>
                    </tr>
                    <tr>
                        <td>Aanmaken:</td>
                        <td><input type="submit" name="button" value ="Aanmaken"></td>
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

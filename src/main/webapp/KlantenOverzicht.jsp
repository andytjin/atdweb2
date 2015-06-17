<%-- 
    Document   : KlantenOverzicht
    Created on : Jun 17, 2015, 2:36:32 PM
    Author     : Max
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="tabelDiv">
            
            <form action="KlantenOverzichtServlet" method="post">
                <input type="text" name="uname" placeholder="Username">
                <input type="submit" name="button" value="Zoek klant">
                <input type="submit" name="button" value="Automatische herinnering">
                
            </form>
            
            
            <table id="tabel">
                <tr class="head">
                    <td>Gebruikersnaam</td>
                    <td>Naam</td>
                    <td>adres</td>
                    <td>geboortedatum</td>
                    <td>telefoonnummer</td>
                    <td>postcode</td>
                    <td>e-mail</td>
                    <td>Herinnering</td>
                </tr> 
                <c:forEach var="k" items="${KlantenLijst}">
                    <tr class="info">
                        <td>
                            ${k.username} 
                        </td>
                        <td>
                            ${k.naam}
                        </td>
                        <td>
                            ${k.adres}
                        </td>
                        <td>
                            ${k.geboortedatum}
                        </td>
                        <td>
                            ${k.telefoonnummer}
                        </td>
                        <td>
                            ${k.postcode}
                        </td>
                        <td>
                            ${k.emailadres}
                        </td>
                        <td>
                            ${k.getWiltHerinnering()}
                        </td>
                    </c:forEach>
            </table>
        </div>
    </body>
</html>

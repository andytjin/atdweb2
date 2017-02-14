<%-- 
    Document   : PlanningOverzicht
    Created on : 3-jun-2015, 18:32:04
    Author     : freekvdp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onderhoudsbeurt Overzicht</title>
    </head>
    <body>
        <h1>Onderhoudsbeurt Overzicht</h1>

        <form action="PlanningOverzichtServlet" method="post">
            <div>
                <table>
                    <select name="autos" id="auto" >
                        <option value="" disabled selected>Selecteer uw auto</option>
                        <c:forEach var="Auto" items="${Autos}">
                            <option value="${Auto.kenteken}">${Auto.merk} | ${Auto.kenteken}</option>
                        </c:forEach>
                    </select>

                </table>

                <input type="submit" name="button" value="haal op"/> 


                <c:forEach var="Onderhoudsbeurt" items="${planningen}">
                    <table style="background-color:#ffffff; font-weight: bold; ">
                        <tr><th>Referentienummer: </th><td>${Onderhoudsbeurt.dienstNummer}</td></tr>
                        <tr><th>Datum: </th><td>${Onderhoudsbeurt.SQLdatum}</td></tr>
                        <tr><th>Kenteken: </th><td>${Onderhoudsbeurt.kenteken}</td></tr>
                    </table>
                </c:forEach>

                <div>
                    <br/>
                    <input type="submit" name="button" value ="Terug" />
                    <input type="submit" name="button" value ="Nieuwe Planning" />
                </div>
            </div>
        </form>
    </body>
</html>

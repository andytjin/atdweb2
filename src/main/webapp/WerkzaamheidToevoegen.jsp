<%-- 
    Document   : WerkzaamheidToevoegen
    Created on : 11-mei-2015, 18:29:44
    Author     : andy
--%>
<%@page import="Domain.Artikel"%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Werkzaamheid toevoegen</title>
    </head>
    <body>
        <form action="WerkzaamheidToevoegen" method="post">
            <div id="mainWT">
                <table>
                    <tr>
                        <td><label>onderhoudsbeurt ID:</label></td>
                        <td><input type="text" name="werkzaamheid"><br/></td>
                    </tr>
                    <tr>
                        <td><label>Datum:</label></td>
                        <td><input type="date" name="datum"><br/></td>
                    </tr>
                    <tr>
                        <td><label>aantal besteden uur:</label></td>
                        <td><input type="text" name="uur"><br/></td>
                    </tr>          
                    <tr>
                        <td><label>Auto ID:</label></td>
                        <td><select name="auto" id="auto">
                                <c:forEach var="Auto" items="${auto}">
                                    <option value="${Auto.kenteken}">${Auto.kenteken}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Monteur: ID</label></td>
                        <td><select name="monteur" id="monteur">
                                <c:forEach var="Monteur" items="${monteur}">
                                    <option value="${Monteur.ID}">${Monteur.ID}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr> 
                        <td><label>Status:</label></td>
                        <td><select name="status" >
                            <option>Selecteer Status</option>
                            <option value="In-onderhoud">In-onderhoud</option>
                            <option value="Gerepareerd">Gerepareerd</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button name="knop" value="Terug" type="submit"><br>
                                Terug
                            </button>
                            <button name="knop" value="Opslaan" type="submit"><br>
                                Opslaan
                            </button></td>
                    </tr>
                </table>
            </div>
        </form>
        <div id="mainWT2">
            <jsp:include page="/GebruikteArtikelToevoegen.jsp"/>
        </div>
    </body>
</html>

<%-- 
    Document   : Planning
    Created on : 27-mei-2015, 12:51:35
    Author     : freekvdp
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Auto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planning</title>
    </head>
    <body>
        <h1>Planning</h1>
        Selecteer hieronder de Auto voor een Afspraak:<br/>
        <form action="PlanningServlet" method="post">
            <table>
                <c:forEach var = "autos" items="${Autos}">
                    <tr>
                        <td>
                            <input type="radio" name="autoradios" value= "${autos.kenteken}" >${autos.merk} | ${autos.kenteken}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
            <div>
                
                <input type="date" name ="SelectedDate" />
                <br/>
                <br/>
                <input type="submit" name="button" value ="Terug" />
                <input type="submit" name="button" value ="Auto Toevoegen" />
                <input type="submit" name="button" value="Akkoord" />
            </div>

        </form>
    </body>
</html>
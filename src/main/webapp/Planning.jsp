<%-- 
    Document   : Planning
    Created on : 27-mei-2015, 12:51:35
    Author     : freekvdp
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Auto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Headers/klantheader.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planning</title>
    </head>
    <body>
        <div id="mainmonteur">
        <h1>Planning</h1>
        Selecteer hieronder de Auto voor een Afspraak:<br/>
        <form action="PlanningServlet" method="post">
            <div>
                <c:forEach var = "autos" items="${Autos}">
                    <input type="radio" name="autos" value= "${autos.kenteken}" >${autos.kenteken} , ${autos.merk}
                </c:forEach>
                <br/>
                <div>
                    <br/>
                    <br/>
                    <input type="date" name ="SelectedDate" />
                    <br/>
                    <br/>
                    <input type="submit" name="button" value ="Terug" />
                    <input type="submit" name="button" value ="Auto Toevoegen" />
                    <input type="submit" name="button" value="Akkoord" />
                </div>
            </div>
        </form>
        </div>
    </body>
</html>

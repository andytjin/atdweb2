<%-- 
    Document   : OnderhoudsbeurtOverzicht
    Created on : 3-jun-2015, 18:32:04
    Author     : freekvdp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onderhoudsbeurt Overzicht</title>
    </head>
    <body>
        <h1>Onderhoudsbeurt Overzicht</h1>
        
        <form action="PlanningServlet" method="post">
            <div>
                <table>
                <c:forEach var = "autos" items="${Autos}">
                    <input type="button" name="autoradios" value= "${autos.kenteken}" >${autos.kenteken} , ${autos.merk}
                </c:forEach>
                <br/>
                </table>
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
    </body>
</html>

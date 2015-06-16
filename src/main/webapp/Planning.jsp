<%-- 
    Document   : Planning
    Created on : 27-mei-2015, 12:51:35
    Author     : freekvdp
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Auto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <input type="submit" name="button" value ="Get Autos" />
            <div>
                <%
                    String melding = "";
                    List<Auto> alleAutos = (List<Auto>) request.getSession().getAttribute("Autos");
                    String autonaam = "";
                    /*
                     Object Obj = request.getSession().getAttribute("Autos");
                     if (Obj != null) {
                     alleAutos = (List<Auto>) Obj;
                     } else {
                     melding = "Klik hieronder om uw auto toe te voegen";
                     }
                     */
                    if (alleAutos != null) {
                        int i = 1;
                        for (Auto a : alleAutos) {
                            autonaam = "auto" + i;
                %>
                <input type="radio" name="autoradios" value= "<%= autonaam%>" />
                <%
                            out.println(a.getNaam());
                            i++;
                        }
                    }
                %>
                <br/>
                <div>
                    <%
                        if (!melding.equals("")) {
                            out.println(melding);
                        }
                    %>
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

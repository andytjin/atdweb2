<%-- 
    Document   : AutoGegevens
    Created on : May 14, 2015, 5:58:19 PM
    Author     : Max
--%>

<%@page import="Domain.Auto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.Bedrijf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto settings</title>
    </head>
    <body>
        <form action="AutoGegevensServlet" method="post" class="klantgegevenstable">
            <input type="text" name="naam" placeholder="Auto type">
            <input type="text" name="merk" placeholder="Automerk">
            <input type="submit" name="button" value="Auto toevoegen">     
        </form>

        <table class="klantgegevenstable">
            <%
                Object obj = request.getServletContext().getAttribute("bedrijf");
                Bedrijf bedrijf = null;
                if (obj != null) {
                    bedrijf = (Bedrijf) obj;
                }
                if (bedrijf != null) {
                    ArrayList<Auto> autolijst = bedrijf.getAlleAutos();
                    if (autolijst != null) {
                        for (Auto a : autolijst) {
                            %> 
                            <tr class="autotabelrow">
                            <form action="AutoGegevens" method="post">
                                <td><%= a.getNaam()%> </td>
                                <td><%= a.getMerk()%> </td>
                                <td><input type="submit" name="button" value="Wijzig">
                                <input type="submit" name="button" value="Verwijder"></td>
                            </form>
                            </tr>
                            <%
                        }
                    }
                }


            %>
        </table>
    </body>
</html>

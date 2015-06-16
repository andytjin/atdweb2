<%-- 
    Document   : WerkzaamhedenOverzicht
    Created on : 11-mei-2015, 18:30:36
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoofdscherm Werkzaamheden</title>
    </head>
    <body>
        <form action="HoofdSchermWerkzaamheden" method="post">
        <input type="submit" name="button" value="Toevoegen">
        <br>
        <input type="submit" name="button" value="wijzigen">
        <br>
        <input type="submit" name="button" value="verwijderen">
        <br>
        <input type="submit" name="button" value="Overzicht">
        </form>
    </body>
</html>

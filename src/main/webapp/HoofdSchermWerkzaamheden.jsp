<%-- 
    Document   : HoofdSchermWerkzaamheden
    Created on : 11-mei-2015, 18:29:21
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoofdscherm werkzaamheden</title>
    </head>
    <body>
        <form action="HoofdSchermWerkzaamheden" method="post">
        <button name="knop" value="werkzaamheidOverzicht" type="submit">
                Werkzaamheid Overzicht
        </button>
        <button name="knop" value="werkzaamheidToevoegen" type="submit">
                Werkzaamheid Toevoegen
        </button>
        <button name="knop" value="werkzaamheidWijzigen" type="submit">
                Werkzaamheid Wijzigen
        </button>
        <button name="knop" value="werkzaamheidVerwijderen" type="submit">
                Werkzaamheid verwijderen
        </button>
        <button name="knop" value="terug" type="submit">
                Terug
        </button>
        </form>
    </body>
</html>

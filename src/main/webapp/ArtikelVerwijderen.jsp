<%-- 
    Document   : ArtikelVerwijderen
    Created on : 13-mei-2015, 17:36:10
    Author     : andy
--%>
<jsp:include page="Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <label>Selecteer onderdeel</label>
        <select name="onderdelen"></select>
        <label>Naam:</label>
        <label>Nummer:</label>
        <label>Prijs:</label>
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="verwijder" type="submit"><br>
                Verwijder
        </button>
    </body>
</html>

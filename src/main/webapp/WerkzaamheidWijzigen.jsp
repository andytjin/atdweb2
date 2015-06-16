<%-- 
    Document   : WerkzaamheidWijzigen
    Created on : 11-mei-2015, 18:30:02
    Author     : andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <label>Werkzaamhedennummer</label>
        <select name="Werkzaamheidnummer"></select>
        <label>Werkzaamheid:</label>
        <input type="text" name="Username"><br/>
        <label>Kenteken</label>
        <input type="text" name="Username"><br/>
        <label>Status</label>
        <textarea rows="4" cols="50"></textarea><br/>
        <label>Werknemer:</label>
        <select name="Werknemer"></select>
        <label>gebruikte onderdelen:</label>
        <select name="GebruikteOnderdelen"></select><br>
        <button name="knop" value="wijzigen" type="submit">
               Wijzigen
        </button>
        <textarea rows="4" cols="50"></textarea><br/>
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button>
    </body>
</html>

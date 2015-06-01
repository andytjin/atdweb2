<%-- 
    Document   : ArtikelWijzigen
    Created on : 13-mei-2015, 17:35:58
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
        <label>Selecteer Artikel</label>
        <select name="Onderdelen"></select>
        <label>Artikel naam:</label>
        <input type="text" name="artikelNaam"><br/>
        <label>Artikel nummer:</label>
        <input type="text" name="artikelNummer"><br/>
        <label>Prijs:</label>
        <input type="text" name="prijs"><br/>
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button>
    </body>
</html>

<%-- 
    Document   : ArtikelToevoegen
    Created on : 13-mei-2015, 17:26:58
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikel Toevoegen</title>
    </head>
    <body>
        <form action="ArtikelToevoegen" method="post">
        <label>Artikel nummer:</label>
        <input type="text" name="artikelNummer"><br/>
        <label>Artikel Type</label>
        <input type="text" name="artikelType"><br/>
        <label>Aantal artikelen:</label>
        <input type="text" name="aantal"><br/>
        <label>Minimum:</label>
        <input type="text" name="minimum"><br/>
        <label>Prijs:</label>
        <input type="text" name="prijs"><br/>
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button>
        </form>
    </body>
</html>

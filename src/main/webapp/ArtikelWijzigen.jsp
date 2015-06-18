<%-- 
    Document   : ArtikelWijzigen
    Created on : 13-mei-2015, 17:35:58
    Author     : andy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src="Script.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ArtikelWijzigen" method="post">
        <label>Selecteer ArtikelID:</label>
        <select name="artikelNummer" id="artikel" onchange="fillArtikelVerwijderen()" >
            <option>Selecteer ArtikelID</option>
            <c:forEach var="Artikel" items="${artikel}">
             <option value="${Artikel.code},${Artikel.hetType.type},${Artikel.aantal},${Artikel.minimum},${Artikel.prijs}">${Artikel.code}</option>
            </c:forEach>
        </select>
        <label>Artikel type:</label>
        <select name="artikelType" id="artikelType" >
            <option>Selecteer ArtikelType</option>
            <c:forEach var="ArtikelType" items="${artikeltype}">
             <option value="${ArtikelType.type}">${ArtikelType.type}</option>
            </c:forEach>
        </select>
        <br/>
        <label>Aantal artikelen:</label>
        <input type="text" name="aantal" id="aantal" /><br/>
        <label>Minimum:</label>
        <input type="text" name="minimum" id="minimum" /><br/>
        <label>Prijs:</label>
        <input type="text" name="prijs" id="prijs" /><br/>
        
        <button name="knop" value="Terug" type="submit"><br>
                Terug
        </button>
        <button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button>
        </form>
    </body>
</html>

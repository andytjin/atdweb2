<%-- 
    Document   : ArtikelWijzigen
    Created on : 13-mei-2015, 17:35:58
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
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
        <form action="ArtikelVerwijderen" method="post">
        <label>Selecteer ArtikelID:</label>
        <select name="artikelNummer" id="artikel" onchange="fillArtikelVerwijderen()" >
            <option disabled Selected>Selecteer ArtikelID</option>
            <c:forEach var="Artikel" items="${artikel}">
             <option value="${Artikel.code},${Artikel.hetType.type},${Artikel.aantal},${Artikel.minimum},${Artikel.prijs}">${Artikel.code}</option>
            </c:forEach>
        </select>
        <label>Artikel type:</label>
        <input type="text" id="artikelType" readonly/>
        <br/>
        <label>Aantal artikelen:</label>
        <input type="text" id="aantal" readonly/><br/>
        <label>Minimum:</label>
        <input type="text" id="minimum" readonly/><br/>
        <label>Prijs:</label>
        <input type="text" id="prijs" readonly/><br/>
        <button name="knop" value="Terug" type="submit">
                Terug
        </button><br>
        <button name="knop" value="Verwijder" type="submit">
                Verwijder
        </button>
        <label>${error}</label>
        </form>
    </body>
</html>

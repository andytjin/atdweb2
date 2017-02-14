<%-- 
    Document   : ArtikelWijzigen
    Created on : 13-mei-2015, 17:35:58
    Author     : andy
--%>
<jsp:include page="Headers/monteurheader.jsp" />
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
        <div class="tabelDivWO2" style="left: 41%;">
            <form action="ArtikelVerwijderen" method="post">
                <table>
                    <tr>
                        <td><label>Selecteer ArtikelID:</label></td>
                        <td><select name="artikelNummer" id="artikel" onchange="fillArtikelVerwijderen()" >
                                <option>Selecteer ArtikelID</option>
                                <c:forEach var="Artikel" items="${artikel}">
                                    <option value="${Artikel.code},${Artikel.hetType.type},${Artikel.aantal},${Artikel.minimum},${Artikel.prijs}">${Artikel.code}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td><label>Artikel type:</label></td>
                        <td><input type="text" id="artikelType" readonly/></td>
                    </tr>
                    <tr>
                        <td><label>Aantal artikelen:</label></td>
                        <td><input type="text" id="aantal" readonly/></td>
                    </tr>
                    <tr>
                        <td><label>Minimum:</label></td>
                        <td><input type="text" id="minimum" readonly/></td>
                    </tr>
                    <tr>
                        <td><label>Prijs:</label></td>
                        <td><input type="text" id="prijs" readonly/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <button name="knop" value="Terug" type="submit">
                                Terug
                            </button>
                            <button name="knop" value="Verwijder" type="submit">
                                Verwijder
                            </button></td>
                    </tr>
                    <tr>
                        <td><label>${error}</label></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>

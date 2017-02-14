<%-- 
    Document   : ArtikelWijzigen
    Created on : 13-mei-2015, 17:35:58
    Author     : andy
--%>
<jsp:include page="Headers/monteurheader.jsp"/>
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
            <form action="ArtikelWijzigen" method="post">
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
                        <td><select name="artikelType" id="artikelType" >
                                <option>Selecteer ArtikelType</option>
                                <c:forEach var="ArtikelType" items="${artikeltype}">
                                    <option value="${ArtikelType.type}">${ArtikelType.type}</option>
                                </c:forEach>
                            </select></td>
                    <tr>

                        <td><label>Aantal artikelen:</label></td>
                        <td><input type="text" name="aantal" id="aantal" /></td>
                    </tr>
                    <tr>
                        <td><label>Minimum:</label></td>
                        <td><input type="text" name="minimum" id="minimum" /></td>
                    </tr>
                    <tr>
                        <td><label>Prijs:</label></td>
                        <td><input type="text" name="prijs" id="prijs" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <button name="knop" value="Terug" type="submit"><br>
                                Terug
                            </button>
                            <button name="knop" value="Opslaan" type="submit"><br>
                                Opslaan
                            </button></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>

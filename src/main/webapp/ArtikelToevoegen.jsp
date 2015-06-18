<%-- 
    Document   : ArtikelToevoegen
    Created on : 13-mei-2015, 17:26:58
    Author     : andy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div id="main" style="height: 10em; left: 37.5%; ">
            <form action="ArtikelToevoegen" method="post">
                <table>
                    <tr>
                    <td><label>Artikel Type toevoegen</label></td>
                    <td><input type="text" name="artikelType"><br/></td>
                    <td><button name="knop" value="voeg toe" type="submit">
                            voeg toe
                    </button><br></td>
                    </tr>
        
        <tr>            
        <td><label>Artikel nummer:</label></td>
        <td><input type="text" name="artikelNummer"><br/></td>
        </tr>
        <tr>
        <td><label>Artikel Type</label></td>
        <td><select name="artikeltype" >
                <c:forEach var="ArtikelType" items="${artikeltype}">
                    <option value="${ArtikelType.type}">${ArtikelType.type}</option>
                </c:forEach>
        </select></td>
        </tr>
        <tr>
        <td><label>Aantal artikelen:</label></td>
        <td><input type="text" name="aantal"><br/></td>
        </tr>
        <tr>
        <td><label>Minimum:</label></td>
        <td><input type="text" name="minimum"><br/></td>
        </tr>
        <tr>
        <td><label>Prijs:</label></td>
        <td><input type="text" name="prijs"><br/></td>
        </tr>
        <tr>
        <td><button name="knop" value="Terug" type="submit"><br>
                Terug
        </button></td>
        <td><button name="knop" value="Opslaan" type="submit"><br>
                Opslaan
        </button></td>
        </tr>
        <label>${error}</label>
        </form>
        <!--
        
                        <td><input type="text" name="artikelNummer"></td>
                    </tr>
                    <tr>
                        <td><label>Artikel Type</label></td>
                        <td><input type="text" name="artikelType"></td>
                    </tr>
                    <tr>
                        <td><label>Aantal artikelen:</label></td>
                        <td><input type="text" name="aantal"><br/></td>
                    </tr>
                    <tr>
                        <td><label>Minimum:</label></td>
                        <td><input type="text" name="minimum"></td>
                    </tr>
                    <tr>
                        <td><label>Prijs:</label></td>
                        <td><input type="text" name="prijs"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button name="knop" value="Terug" type="submit"><br>
                                Terug
                            </button>
                            <button name="knop" value="Opslaan" type="submit"><br>
                                Opslaan
                            </button></td>
                    </tr>
                </table>
            </form>
        </div>
        -->
    </body>
</html>

<%-- 
    Document   : KlantGegevens
    Created on : May 14, 2015, 5:49:06 PM
    Author     : Max
--%>

<%@page import="Domain.Klant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klant gegevens</title>
    </head>
    <body>

        <form action="KlantGegevensServlet" method="post" id="klantgegevensform">
            <div class="username">
                <table class="klantgegevenstable">
                    <tr>
                        <td> Username: </td>
                        <td>${User.username}</td>
                    </tr>
                    <tr>
                        <td> Naam: </td>
                        <td><input type="text" name="naam" value="${User.getNaam()}"/></td>
                    </tr>
                    <tr>
                        <td>Huidig wachtwoord:</td>
                        <td><input type="password" name="wachtwoord"></td>
                    </tr>
                    <tr>
                        <td>Nieuw wachtwoord:</td>
                        <td><input type="password" name="nwachtwoord1"></td>
                    </tr>
                    <tr>
                        <td>Bevestig wachtwoord:</td>
                        <td><input type="password" name="nwachtwoord2"</td>
                    </tr>
                </table>
            </div>
            <table class="klantgegevenstable">
                <tr>
                    <td> Adres: </td>
                    <td><input type="text" name="adres" value="${User.getAdres()}"/></td>
                </tr>
                <tr>
                    <td> Geboortedatum:  </td>
                    <td><input type="date" name="gdatum" value="${User.getGeboortedatum()}"/></td>
                </tr>
                <tr>
                    <td> Telefoon: </td>
                    <td><input type="text" name="telnmmr" value="${User.getTelefoonnummer()}"/></td>
                </tr>
                <tr>
                    <td> Postcode: </td>
                    <td><input type="text" name="postcode" value="${User.getPostcode()}"/></td>
                </tr>
                <tr>
                    <td> E-mail: </td>
                    <td><input type="text" name="email" value="${User.getEmailadres()}"/></td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" name="button" value="Opslaan"></td>
                </tr>


                ${settingmsgs1}
            </table>

        </form>
    </body>
</html>

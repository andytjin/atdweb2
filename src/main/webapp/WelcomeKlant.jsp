<%-- 
    Document   : WelcomeKlant
    Created on : Apr 24, 2015, 3:54:15 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATD</title>
    </head>
    <body>
        <div id="header">
            <h1>Welkom Klant</h1>

            <div class="navbar">
                <form action="KlantPageSevlet" method="post" class="navForm">
                    <input type="submit" name="button" value="Home" class="navbutton5">
                    <input type="submit" name="button" value="afspraak"class="navbutton5">
                    <input type="submit" name="button" value="garage"class="navbutton5">
                    <input type="submit" name="button" value="mijn account"class="navbutton5">
                    <input type="submit" name="button" value="log out"class="navbutton5" >
                </form>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : AdminPage
    Created on : Apr 28, 2015, 8:28:36 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="Images/picatd2.png"/>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN PAGE</title>
    </head>
    <body>
        <div id="header">
            <h1>Homepage</h1>
            <div class="login">
                ingelogd als: HenkPaladijn
            </div>
            <div class="navbar">
                <form action="AdminPageServlet" method="post" class="navForm">
                    <input type="submit" name="button" value="Home" class="navbutton5"/>
                    <input type="submit" name="button" value="add monteur" class="navbutton5"/>  
                    <input type="submit" name="button" value="Factuur" class="navbutton5"/>
                    <input type="submit" name="button" value="Bestelling" class="navbutton5"/>
                    <input type="submit" name="button" value="Klanten" class="navbutton5"/>
                    <input type="submit" name="button" value="log out" class="navbutton5"/>
                </form>
            </div>
        </div>


    </body>
</html>

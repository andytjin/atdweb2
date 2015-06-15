<%-- 
    Document   : header
    Created on : May 11, 2015, 1:36:52 PM
    Author     : Thijs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div id="header">
            <h1>Homepage</h1>
           <div class="navbar">
                <form action="KlantPageServlet" method="post" class="navForm">
                    <input type="submit" name="button" value="Home" class="navbutton5">
                    <input type="submit" name="button" value="afspraak" class="navbutton5">
                    <input type="submit" name="button" value="garage" class="navbutton5">
                    <input type="submit" name="button" value="factuur" class="navbutton5">
                    <input type="submit" name="button" value="mijn account" class="navbutton5">
                    <input type="submit" name="button" value="log out" class="navbutton5" >
                </form>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : monteurheader
    Created on : May 21, 2015, 2:44:15 PM
    Author     : Max
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
                <form action="MonteurPageServlet" method="post" class="navForm">
                    <input type="submit" name="button" value="Home" class="navbutton5">
                    <input type="submit" name="button" value="Onderhoudsbeurt" class="navbutton5">
                    
                </form>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : AddMonteur
    Created on : May 7, 2015, 11:40:30 AM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add monteur</title>
    </head>
    <body>
        <div id="header">
            <h1>Monteur toevoegen</h1>
        </div>

        <div>
            <form action="AddMonteurServlet" method="post">
                <input type="text" name="ID" placeholder="Monteurs ID">
                <input type="text" name="Naam" placeholder="Naam">
                <input type="submit" name="button" value="Voeg toe">
                <input type="submit" name="button" value="terug">
            </form>
            ${msgs}

        </div>
    </body>
</html>

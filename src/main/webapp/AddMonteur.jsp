<%-- 
    Document   : AddMonteur
    Created on : May 7, 2015, 11:40:30 AM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="AdminPage.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add monteur</title>
    </head>
    <body>
        <div class="position">
            <form action="AddMonteurServlet" method="post" class="content">
                <table class="klantgegevenstable">
                    <tr>
                        <td>Monteurs ID:</td>
                        <td><input type="text" name="ID"></td>
                    </tr>
                    <tr>
                        <td>Naam:</td>
                        <td><input type="text" name="Naam"></td>
                    </tr>
                    <tr>
                        <td>Wachtwoord:</td>
                        <td><input type="password" name="Password"></td>
                    </tr>
                    <tr>
                        <td>Bevestig wachtwoord:</td>
                        <td><input type="password" name="PasswordCheck"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="button" value="Voeg toe">
                            <input type="submit" name="button" value="terug"> 
                        </td>
                    </tr>

                </table>
            </form>
            ${msgs}

        </div>
    </body>
</html>

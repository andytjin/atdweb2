<%-- 
    Document   : AdminPage
    Created on : Apr 28, 2015, 8:28:36 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN PAGE</title>
    </head>
    <body>
        <h1>Welkom Admin</h1>


        <div class="button">
            <form action="LogoutServlet" method="post">
                <input type="submit" name="button" value="log uit">
            </form>
            <form action="AdminpageServlet" method="post">
                <input type="submit" name="button" value="add monteur">  
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : KlantSettings
    Created on : May 14, 2015, 5:34:15 PM
    Author     : Max
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="Images/picatd2.png"/>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATD: Account Settings</title>
    </head>
    <body>
        
        <div id="KlantGegevens">
            <jsp:include page="/KlantSettingsPages/KlantGegevens.jsp"/> 
        </div>
        <div id="AutoGegevens">
            <jsp:include page="/KlantSettingsPages/AutoGegevens.jsp"/> 
        </div>



    </body>
</html>

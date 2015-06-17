<%-- 
    Document   : index
    Created on : Apr 22, 2015, 12:22:21 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Images/picatd.png"/>
        <title>ATD login</title>
    </head>
    <body>
        <div id="header">
            <h1>Auto Totaal Dienst</h1>
            <div class="login">
                <form action="LoginServlet" method="post">
                    <input type="text" name="Username" placeholder="Gebruikersnaam">
                    <input type="password" name="Password" placeholder="Wachtwoord">
                    <input type="submit" name="button" value="Login">
                    <input type="submit" name="button" value="Monteur login">
                </form>  
            </div>
            <p class="error" >
                ${loginmsgs}
            </p>
        </div>

        <div id="register" >
            <div class ="reg">
                <h2>Register</h2>
                <form action="RegisterServlet" method="post">
                    <table>
                        <tr>
                            <td>Gebruikersnaam:</td>
                            <td><input type="text" name="Username"></td>
                        </tr>
                        <tr>
                            <td>Naam:</td>
                            <td><input type="text" name="Fullname"></td>
                        </tr>
                        <tr>
                            <td>Wachtwoord:</td>
                            <td><input type="password" name="Password"></td>
                        </tr>
                        <tr>
                            <td>Bevestig wachtwoord:</td>
                            <td><input type="password" name="PasswordConfirm"></td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                            <td><input type="email" name="Email"></td>
                        </tr>
                        <tr>
                            <td>Bevestig E-mail:</td>
                            <td><input type="email" name="EmailConfirm"></td>
                        </tr>
                        <tr>
                            <td>Telefoonnummer:</td>
                            <td><input type="text" name="Phonenumber" placeholder="0612345678"></td>
                        </tr>
                        <tr>
                            <td>Adres</td>
                            <td><input type="text" name="Address"></td>
                        </tr>
                        <tr>
                            <td>Postcode:</td>
                            <td><input type="text" name="Postcode" placeholder="1234AB"></td>
                        </tr>
                        <tr>
                            <td>Geboortedatum:</td>
                            <td><input type="date" name="DateofBirth"></td>
                        </tr>
                    </table>
                    <label class="labels">
                    </label>
                    <label class ="inputs">
                        Ik wil graag een herrinnerings brief ontvangen<input type="checkbox" name="Herrinnering" ><br/><br/>

                    </label>
                    <input type="submit" name="register" value="Registreer">
                    <div class="errormessage">
                        <p>
                            <%
                                if (request.getAttribute("msgs") != null) {
                                    out.println(request.getAttribute("msgs"));
                                }
                            %>
                        </p>
                    </div>

                </form>
            </div>
        </div>


        <div id="infobar">
            <div class="informatie">
                Contact: contact@infoatd.com || Tel: 0900 - 030303030 ( 10ct. p/m) || Fax: 0900-30303030 
            </div>
        </div>
    </body>
</html>

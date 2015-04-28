<%-- 
    Document   : index
    Created on : Apr 22, 2015, 12:22:21 PM
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATD login</title>
    </head>
    <body>
        <div class="header">
            <h1>ATD</h1>
            <div class="login">
                <form action="LoginServlet" method="post">
                    <input type="text" name="Username" placeholder="Gebruikersnaam">
                    <input type="password" name="Password" placeholder="Wachtwoord">
                    <input type="submit" name="button" value="Login">
                </form>  
            </div>
            <p class="errormessage" <%
                if (request.getAttribute("loginmsgs") != null) {
                    out.println(request.getAttribute("loginmsgs"));
                }
               %>
        </p>
    </div>

    <div class="register">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            Gebruikersnaam:
            <input type="text" name="Username"><br/>
            Naam:
            <input type="text" name="Fullname"><br/>
            Wachtwoord:
            <input type="password" name="Password"><br/>
            Bevestig wachtwoord:
            <input type="password" name="PasswordConfirm"><br/>
            E-mail:
            <input type="email" name="Email"><br/>
            Bevestig e-mail
            <input type="email" name="EmailConfirm"><br/>
            Telefoon nummer:
            <input type="text" name="Phonenumber" placeholder="0612345678"><br/>
            Adres:
            <input type="text" name="Address"><br/>
            Postcode:
            <input type="text" name="Postcode" placeholder="1234AB"><br/>
            Geboortedatum:
            <input type="date" name="DateofBirth"><br/>
            <input type="checkbox" name="Herrinnering" >Ik wil graag een herrinnerings brief ontvangen<br/>
            <input type="submit" name="register" value="Registreer">
        </form>
    </div>

    <div class="errormessage">
        <p>
            <%
                if (request.getAttribute("msgs") != null) {
                    out.println(request.getAttribute("msgs"));
                }
            %>
        </p>
    </div>
</body>
</html>

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
                </form>  
            </div>
            <p class="error" >
               <%
                if (request.getAttribute("loginmsgs") != null) {
                    out.println(request.getAttribute("loginmsgs"));
                }
               %>
        </p>
    </div>
    
    <div id="register" >
        <div class ="reg">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <label class="labels">
            Gebruikersnaam:<br/>
            Naam:<br/>
            Wachtwoord:<br/>
            Bevestig wachtwoord:<br/>
            E-mail:<br/>
            Bevestig e-mail:<br/>
            Telefoon nummer:<br/>
            Adres:<br/>
            Postcode:<br/>
            Geboortedatum:<br/>
            
            </label>
            <label class ="inputs">
            <input type="text" name="Username"><br/>            
            <input type="text" name="Fullname"><br/>            
            <input type="password" name="Password"><br/>            
            <input type="password" name="PasswordConfirm"><br/>            
            <input type="email" name="Email"><br/>            
            <input type="email" name="EmailConfirm"><br/>            
            <input type="text" name="Phonenumber" placeholder="0612345678"><br/>            
            <input type="text" name="Address"><br/>            
            <input type="text" name="Postcode" placeholder="1234AB"><br/>            
            <input type="date" name="DateofBirth"><br/><br/>
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

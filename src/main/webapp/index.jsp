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
            <p class="errormessage" >
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
            <label class ="inputs">
            <input type="text" name="Username" placeholder="Gebruikersnaam"><br/>            
            <input type="text" name="Fullname" placeholder="volldige naam"><br/>            
            <input type="password" name="Password" placeholder="Wachtwoord"><br/>            
            <input type="password" name="PasswordConfirm" placeholder="Bevestig wachtwoord"><br/>            
            <input type="email" name="Email" placeholder="Email"><br/>            
            <input type="email" name="EmailConfirm" placeholder="Bevestig email"><br/>            
            <input type="text" name="Phonenumber" placeholder="0612345678"><br/>            
            <input type="text" name="Address" placeholder="Email"><br/>            
            <input type="text" name="Postcode" placeholder="Postcode: 1234AB"><br/>            
            <input type="date" name="DateofBirth" ><br/>
            <input type="checkbox" name="Herrinnering" >Ik wil graag een herrinnerings brief ontvangen<br/>
            
            <input type="submit" name="register" value="Registreer">
           </label>
        </form>
         </div>
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
        <div id="infobar">
            
        </div>
</body>
</html>

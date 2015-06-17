<%-- 
    Document   : WelcomeKlant
    Created on : Apr 24, 2015, 3:54:15 PM
    Author     : Max
--%>

<%-- <jsp:include page="Headers/klantheader.jsp"/> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function () {
                $("#banner a").bind("click", function (event) {
                    event.preventDefault();
                    var target = $(this).attr("href");
                    $("html, body").stop().animate({
                        scrollLeft: $(target).offset().left,
                        scrollTop: $(target).offset().top
                    }, 1000);
                });
            });
        </script>
        <title>ATD</title>
    </head>
    <body>
        <div id="header">
            <h1>Homepage</h1>
            <form class="login" action="KlantPageServlet" method="post">
                <input type="submit" name="button" value="Log uit">
            </form>    
            <div id="banner" class="navbar">
                <ul class="navForm">
                    <li> <a href="#Home">Home</a> </li>
                    <li><a href="#Afspraak">Afspraak</a> </li>
                    <li><a href="#Garage">Garage</a> </li>
                    <li><a href="#Factuur">Factuur</a> </li>
                    <li><a href="#Account">Account</a> </li>
                </ul>
            </div>
        </div>


        <div id="Home" class="panel">
            <jsp:include page="KlantHome.jsp"/>
        </div>
        <div id="Afspraak" class="panel">
            <jsp:include page="Planning.jsp"/>
        </div>
        <div id="Garage" class="panel">
            <jsp:include page="Garage.jsp"/>
        </div>
        <div id="Factuur" class="panel">
            <jsp:include page="FactuurOverzichtKlant.jsp"/>
        </div>
        <div id="Account" class="panel">
            <jsp:include page="KlantSettings.jsp"/>
        </div>

    </body>
</html>

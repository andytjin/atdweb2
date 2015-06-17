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
                $(".navbutton5").click(function (event) {

                    
                    var target = $(this).attr("href");
                    $("html, body").stop().animate({
                        scrollLeft: $(target).offset().left,
                        
                    }, 1000);
                });
            });
        </script>
        <title>ATD</title>
    </head>
    <body id="scrollableBody" class="content">
        <div id="header">
            <h1>Homepage</h1>

            <div class="navbar">
                <form action="KlantPageServlet" method="post" class="navForm">
                    <input type="button" href="#Home" value="Home" class="navbutton5">
                    <input type="button" href="#Afspraak" value="Afspraak" class="navbutton5">
                    <input type="button" href="#Garage" value="Garage" class="navbutton5">
                    <input type="button" href="#Factuur" value="Factuur" class="navbutton5">
                    <input type="button" href="#Account" value="Account" class="navbutton5">
                    <input type="submit" name="button" value="Log uit" class="navbutton5">
                </form>
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

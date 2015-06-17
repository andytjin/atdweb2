<%-- 
    Document   : header
    Created on : May 11, 2015, 1:36:52 PM
    Author     : Thijs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="shortcut icon" href="Images/picatd.png"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function () {
                $("#navbutton5 a").bind("click", function (event) {
                    event.preventDefault();
                    var target = $(this).attr("value");
                    $("html, body").stop().animate({
                        scrollLeft: $(target).offset().left,
                        scrollTop: $(target).offset().top
                    }, 1200);
                });
            });
        </script>
    </head>
    <body>
        <div id="header">
            <h1>Homepage</h1>
            <div class="navbar">

                <input type="submit" name="button" value="Home" class="navbutton5">

                <input type="submit" name="button" value="afspraak" class="navbutton5">
                <input type="submit" name="button" value="garage" class="navbutton5">
                <input type="submit" name="button" value="factuur" class="navbutton5">
                <input type="submit" name="button" value="mijn account"class="navbutton5">
                <input type="submit" name="button" value="log out"class="navbutton5" >
            </div>
        </div>
    </body>
</html>

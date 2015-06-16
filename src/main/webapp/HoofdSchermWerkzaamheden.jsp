<%-- 
    Document   : HoofdSchermWerkzaamheden
    Created on : 11-mei-2015, 18:29:21
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoofdscherm werkzaamheden</title>
    </head>
    <body>
        <div id="mainmonteur">
            <form action="HoofdSchermWerkzaamheden" method="post">   
                <div class="hswerkzaamheden">
                    <button name="knop" value="werkzaamheidOverzicht" type="submit" class="navbuttonmonteurHS">
                        Werkzaamheid Overzicht
                    </button>
                    <button name="knop" value="werkzaamheidToevoegen" type="submit" class="navbuttonmonteurHS">
                        Werkzaamheid Toevoegen
                    </button>
                    <button name="knop" value="werkzaamheidWijzigen" type="submit" class="navbuttonmonteurHS">
                        Werkzaamheid Wijzigen
                    </button>
                    <button name="knop" value="werkzaamheidVerwijderen" type="submit" class="navbuttonmonteurHS">
                        Werkzaamheid verwijderen
                    </button>
                    <button name="knop" value="terug" type="submit" class="navbuttonmonteurHS">
                        Terug
                    </button>
                </div>
            </form>
        </div>
    </body>
</html>

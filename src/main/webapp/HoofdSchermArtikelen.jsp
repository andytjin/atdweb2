<%-- 
    Document   : HoofdSchermArtikelen
    Created on : 13-mei-2015, 17:31:40
    Author     : andy
--%>
<jsp:include page="/Headers/monteurheader.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Hoofscherm Artrikelen</title>
    </head>
    <body>
        <div id="mainmonteur">
            <form action="HoofdSchermArtikelen" method="post">
                <div class="hswerkzaamheden">
                    <button name="knop" value="nieuwArtikel" type="submit" class="navbuttonmonteurHS">
                        Nieuw Artikel
                    </button>
                    <button name="knop" value="wijzigArtikel" type="submit" class="navbuttonmonteurHS">
                        Wijzig Artikel
                    </button>
                    <button name="knop" value="verwijderArtikel" type="submit" class="navbuttonmonteurHS">
                        Verwijder Artikel
                    </button>
                </div>
            </form>
        </div>
    </body>
</html>

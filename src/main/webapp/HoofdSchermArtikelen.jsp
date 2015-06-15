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
        <form action="HoofdSchermArtikelen" method="post">
        <button name="knop" value="nieuwArtikel" type="submit">
               Nieuw Artikel
        </button>
        <button name="knop" value="wijzigArtikel" type="submit">
               Wijzig Artikel
        </button>
        <button name="knop" value="verwijderArtikel" type="submit">
               Verwijder Artikel
        </button>
        </form>
    </body>
</html>

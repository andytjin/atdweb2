<%-- 
    Document   : AutoGegevens
    Created on : May 14, 2015, 5:58:19 PM
    Author     : Max
--%>

<%@page import="Domain.Auto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.Bedrijf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto settings</title>
    </head>
    <body>
        <table class="klantgegevenstable">
            <form action="AutoGegevensServlet" method="post" >
                
                <tr>
                    <td>Kenteken:</td>
                    <td><input type="text" name="kenteken"></td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td><input type="text" name="naam"></td>
                </tr>
                <tr>
                    <td>Merk:</td>
                    <td><input type="text" name="merk"></td>
                </tr>
                <tr><td><input type="submit" name="button" value="Auto toevoegen"> </td></tr>    
            </form>
        </table>

        <table class="klantgegevenstable">
            <tr>
                <td>Kenteken</td>
                <td>Merk</td>
                <td>Type</td>
            </tr>
            <c:forEach items="${autos}" var="a">
                <tr>
                    <td><c:out value="${a.kenteken}"/></td>
                    <td><c:out value="${a.naam}"/></td>
                    <td><c:out value="${a.merk}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

<%-- 
    Document   : LoginServletErrorPage
    Created on : 22-03-2019, 21:43:20
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                text-align: center;
            }
            linkA{
                color:blue;
            }
            
        </style>
    </head>
    <body>
        <h1>Error!!!</h1>
    <center>
        <br><p><%out.print(session.getAttribute("errormessage"));%></p>
        <p><%out.print(session.getAttribute("supportmessage"));%></p>
        <p><a href="index.html" class="linkA" role="button">Back to log in</a></p>
    </center>
    </body>
</html>

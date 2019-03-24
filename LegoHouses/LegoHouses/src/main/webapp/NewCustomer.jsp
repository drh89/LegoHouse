<%-- 
    Document   : NewCustomer
    Created on : 22-03-2019, 21:42:02
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
        <h1>Enter information</h1>
        <br>
    <center>
        <form method="POST">
            <input placeholder="Username..." type="text" name="username" value="">
            <input placeholder="Email..." type="text" name="email" value="">
            <input placeholder="Password..." type="text" name="pass" value="">
            <input type="submit" name="choice" value="Sign up" formaction="LoginServlet">



        </form>
        <p><a href="index.html" class="linkA" role="button">Back to log in</a></p>
    </center>
</body>
</html>

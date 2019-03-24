<%-- 
    Document   : FundsAddedPage
    Created on : 23-03-2019, 23:33:26
    Author     : Dennis
--%>

<%@page import="logic.Entities.Customer"%>
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

        </style>
    </head>
    <body>
        <h1>Succes!!!</h1>
        <form method="POST">
            <%Customer cust = (Customer) session.getAttribute("customer");%>
            <center>
                <p>Congratulations... You have added money to your wallet!</p>
                <br>
                <br>
                <input type="submit" name="choice" value="Back" formaction="LoginServlet">
            </center>
            <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
            <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
        </form>
    </body>
</html>

<%-- 
    Document   : OrderSent
    Created on : 24-03-2019, 01:32:02
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
        <h1>Succes!!!!</h1>
        <form method="POST">
            <center>
                 <%Customer cust = (Customer) session.getAttribute("customer");%>
                <input type="submit" name ="choice" value="Back" formaction="LoginServlet">

            </center>
            <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
            <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
            
        </form>
    </body>
</html>

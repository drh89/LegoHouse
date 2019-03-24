<%-- 
    Document   : AddFundsPage
    Created on : 23-03-2019, 01:39:30
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
        <h1>Hello World!</h1>

        <form method="POST">
            <%Customer cust = (Customer) session.getAttribute("customer");%>
            <center><input placeholder="Money to add..." type="text" name="funds" value="50">
                <br>
                <br>
                <input type="submit" name="choice" value="Add funds" formaction="ShopServlet">
                <br>
                <br>
                <input type="submit" name="choice" value="Back" formaction="LoginServlet">
            </center>
            <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
            <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
        </form>
    </body>
</html>

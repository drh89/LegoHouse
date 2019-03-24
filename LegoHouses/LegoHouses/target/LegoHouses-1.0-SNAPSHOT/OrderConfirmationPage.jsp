<%-- 
    Document   : OrderConfirmationPage
    Created on : 23-03-2019, 22:19:55
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
            p{
                text-align: center;
            }
            input{
                align-content: center;
            }

        </style>
    </head>
    <body>
        <h1>Succes!!</h1>
        <p>Congratulations your order has been registered, it will be shipped as soon as possible</p>
       
        <br>

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

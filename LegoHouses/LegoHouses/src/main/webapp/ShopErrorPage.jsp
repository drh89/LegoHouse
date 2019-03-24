<%-- 
    Document   : ShopErrorPage
    Created on : 23-03-2019, 01:49:08
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
            linkA{
                color:blue;
            }

        </style>
    </head>
    <body>
        <h1>Error!!!</h1>
        <form method="POST">
            <center>
                <br><p><%out.print(session.getAttribute("errormessage"));%></p>
                <p><%out.print(session.getAttribute("supportmessage"));%></p>


                <%Customer cust = (Customer) session.getAttribute("customer");%>
                <br>
                
                <input type="submit" name ="choice" value="Back" formaction="LoginServlet">
            </center>
                <input type ="hidden" name ="email" value="<%out.print(cust.getEmail());%>">
                <input type ="hidden" name ="pass" value="<%out.print(cust.getPass());%>">
        </form>
    </body>
</html>
